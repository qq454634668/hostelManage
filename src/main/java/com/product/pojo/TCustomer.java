package com.product.pojo;

/**
 * 客户端用户表
 */
public class TCustomer {
    /**
     * t_customer
     */
    private int c_id;    //客户编号
    private String c_userid;    //登录用户名
    private String c_name;    //客户名称
    private String c_lxrxm;    //联系人姓名
    private String c_lxfs;    //联系方式
    private String c_dz;    //地址
    private String c_cjsj;    //创建时间
    private String c_khlx;    //客户类型（1：公立，2私立）
    private int company_id;    //所属公司id
    private String c_passwd;    //登录密码

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_userid() {
        return c_userid;
    }

    public void setC_userid(String c_userid) {
        this.c_userid = c_userid;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_lxrxm() {
        return c_lxrxm;
    }

    public void setC_lxrxm(String c_lxrxm) {
        this.c_lxrxm = c_lxrxm;
    }

    public String getC_lxfs() {
        return c_lxfs;
    }

    public void setC_lxfs(String c_lxfs) {
        this.c_lxfs = c_lxfs;
    }

    public String getC_dz() {
        return c_dz;
    }

    public void setC_dz(String c_dz) {
        this.c_dz = c_dz;
    }

    public String getC_cjsj() {
        return c_cjsj;
    }

    public void setC_cjsj(String c_cjsj) {
        this.c_cjsj = c_cjsj;
    }

    public String getC_khlx() {
        return c_khlx;
    }

    public void setC_khlx(String c_khlx) {
        this.c_khlx = c_khlx;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getC_passwd() {
        return c_passwd;
    }

    public void setC_passwd(String c_passwd) {
        this.c_passwd = c_passwd;
    }
}
