package com.ph.itsw.video.utils;

import com.ph.itsw.constant.VideoConstant;
import com.ph.itsw.video.entity.Configure;
import com.ph.itsw.video.entity.Video;
import com.ph.itsw.video.entity.VideoState;
import com.ph.itsw.video.service.ConfigureService;
import com.ph.itsw.video.service.VideoService;
import com.ph.itsw.video.service.VideoStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JasonPhui
 * 2018/12/15
 * 生成视频缩略图
 */
@Component
public class VideoThumbnailThread  extends Thread{

    @Autowired
    private ConfigureService config;

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoStateService videoState;

    public static VideoThumbnailThread thumbnailThread;

    private void genarator(String ffmpegPath,String upFilePath,String mediaPicPath, String ss){
        List<String> cutpic = new ArrayList<>();
        cutpic.add(ffmpegPath); // 视频提取工具的位置
        cutpic.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
        cutpic.add(upFilePath); // 视频文件路径
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add(ss); // 添加起始时间为第5秒
        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("0.001"); // 添加持续时间为1毫秒
        cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
        cutpic.add("274*123"); // 添加截取的图片大小为274*123
        cutpic.add(mediaPicPath); // 添加截取的图片的保存路径
        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(cutpic);
            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
            // 因此两者均可使用 Process.getInputStream() 方法读取。
            // 这使得关联错误消息和相应的输出变得更容易
            builder.redirectErrorStream(true);
            builder.start();
        }
        catch (Exception e) {
            mark = false;
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            int order = 2;
            File path = new File(VideoConstant.VIDEO_PATH);
            if(!path.exists())
                path = new File("");
            Configure thumbnail_ss = config.getConfigure("thumbnail_ss");
            Configure folder_thumbnail = config.getConfigure("folder_thumbnail");
            String realThumbnailDir = path + "\\resources\\" + folder_thumbnail.getVal();
            //Check
            File realThumbnailDirFile =new File(realThumbnailDir);
            if(!realThumbnailDirFile.exists()  && !realThumbnailDirFile.isDirectory()){
                System.out.println("Directory not exist. Create it.");
                System.out.println(realThumbnailDirFile);
                realThumbnailDirFile.mkdir();
            }
            do {
                List<Video> videos = videoService.getVideoByOrder(order);
                VideoState nextVideoState = videoState.getVideoStateByOrder(order+1);
                if(videos != null) {
                    for(Video video: videos) {
                        String realVideoOriPath = path + "\\resources\\" + video.getOriurl().replace("/", "\\");
                        String realThumbnailPath = realThumbnailDir + "\\" + video.getId() + ".jpg";
                        System.out.println(realThumbnailPath);
                        genarator(VideoConstant.FFMPEG_PATH, realVideoOriPath, realThumbnailPath, thumbnail_ss.getVal());
                        video.setThumbnailurl(folder_thumbnail.getVal()+"\\"+video.getId()+".jpg");
                        video.setVideostate(nextVideoState);
                        videoService.updateVideoByVideo(video);
                    }
                }
                sleep(10 * 1000);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  加上public static VideoThumbnailThread thumbnailThread;
     *  和@PostConstruct注解及init()方法即可解决非Controller中其他层注入为null的问题
     *  关于@PostConstruct：被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
     *  并且只会被服务器调用一次，类似于Servlet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，
     *  init()方法之前运行。通过这种方式启动视频缩略图截图线程
     */
    @PostConstruct
    public void init() {
        thumbnailThread = this;
        this.start();
    }

}

