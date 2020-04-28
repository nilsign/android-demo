package com.appplusmobile.appplusmobiledemo.model;

import java.io.Serializable;

public final class Address implements Serializable {
  private final String street;
  private final String city;
  private final String state;
  private final String country;
  private final String zip;
  private final double latitude;
  private final double longitude;

  public Address(
      String street,
      String city,
      String state,
      String country,
      String zip,
      double latitude,
      double longitude) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.country = country;
    this.zip = zip;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public String getZip() {
    return zip;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }
}
