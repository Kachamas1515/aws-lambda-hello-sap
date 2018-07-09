package com.example.hellosap;

public class SAPConn {
  String host;
  String sysnum;
  String client;
  String user;
  String password;

  public SAPConn(){
  }

  public SAPConn(String host,String sysnum,String client,String user,String password){
    this.host = host;
    this.sysnum = sysnum;
    this.client = client;
    this.user = user;
    this.password = password;
  }

  public String getHost() {
    return this.host;
  }
  public String getSysnum() {
    return this.sysnum;
  }
  public String getClient() {
    return this.client;
  }
  public String getUser() {
    return this.user;
  }
  public String getPassword() {
    return this.password;
  }

  public void setHost(String host) {
    this.host = host;
  }
  public void setSysnum(String sysnum) {
    this.sysnum = sysnum;
  }
  public void setClient(String client) {
    this.client = client;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
