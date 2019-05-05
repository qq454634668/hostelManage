package com.product.pojo;
import com.product.pojo.UserStudent;

public class TaskDetailed {

  private int id;
  private String rwbh;
  private UserStudent userStudent;
  private String rksj;
  private String zt;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getRwbh() {
    return rwbh;
  }

  public void setRwbh(String rwbh) {
    this.rwbh = rwbh;
  }



  public String getRksj() {
    return rksj;
  }

  public void setRksj(String rksj) {
    this.rksj = rksj;
  }


  public String getZt() {
    return zt;
  }

  public void setZt(String zt) {
    this.zt = zt;
  }

  public UserStudent getUserStudent() {
    return userStudent;
  }

  public void setUserStudent(UserStudent userStudent) {
    this.userStudent = userStudent;
  }
}
