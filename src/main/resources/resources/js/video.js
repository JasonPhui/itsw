/**
 * @author JasonPhui
 * 2018/12/23
 */
$(function() {
    $('#evaluation').click(function () {
        var url = '/video/index/evaluation';
        $.ajax({
            url: url,
            type: 'get',
            data: { a:'123'
            },
            success: function (data) {
                $('#video-detail').html(data);
            }
        })
    });
});

