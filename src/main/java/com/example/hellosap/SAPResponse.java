package com.example.hellosap;

public class SAPResponse {
  String echoText;
  String respText;

  public String getEchoText() {
    return this.echoText;
  }

  public String getRespText() {
    return this.respText;
  }

  public void setEchoText(String echoText) {
    this.echoText = echoText;
  }

  public void setRespText(String respText) {
    this.respText = respText;
  }

  public SAPResponse() {
  }
}
