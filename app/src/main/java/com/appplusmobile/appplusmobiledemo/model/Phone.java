package com.appplusmobile.appplusmobiledemo.model;

import java.io.Serializable;

public final class Phone implements Serializable {
  private final String work;
  private final String home;
  private final String mobile;

  public Phone(String work, String home, String mobile) {
    this.work = work;
    this.home = home;
    this.mobile = mobile;
  }

  public String getWork() {
    return work;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }
}
