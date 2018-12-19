package com.ph.itsw.video.entity;

/**
 * @author JasonPhui
 * 2018/12/12
 */
public class Configure implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private String val;
    private String remark;

    // Constructors

    /** default constructor */
    public Configure() {
    }

    /** full constructor */
    public Configure(String name, String val, String remark) {
        this.name = name;
        this.val = val;
        this.remark = remark;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
