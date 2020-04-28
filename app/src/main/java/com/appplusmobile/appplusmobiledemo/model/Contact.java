package com.appplusmobile.appplusmobiledemo.model;

import java.io.Serializable;

public final class Contact implements Serializable {
  private final String name;
  private final String company;
  private String favorite;
  private final String smallImageURL;
  private final String largeImageURL;
  private final String email;
  private final String website;
  private final String birthdate;
  private final Phone phone;
  private final Address address;

  public Contact(
      String name,
      String company,
      String favorite,
      String smallImageURL,
      String largeImageURL,
      String email,
      String website,
      String birthdate,
      Phone phone,
      Address address) {
    this.name = name;
    this.company = company;
    this.favorite = favorite;
    this.smallImageURL = smallImageURL;
    this.largeImageURL = largeImageURL;
    this.email = email;
    this.website = website;
    this.birthdate = birthdate;
    this.phone = phone;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getCompany() {
    return company;
  }

  public String getFavorite() {
    return favorite;
  }

  public boolean isFavorite() {
    if (favorite == null) {
      return false;
    }
    return favorite.trim().equalsIgnoreCase("1")
        || favorite.trim().equalsIgnoreCase("true");
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite ? "true" : "false";
  }

  public String getSmallImageURL() {
    return smallImageURL;
  }

  public String getLargeImageURL() {
    return largeImageURL;
  }

  public String getEmail() {
    return email;
  }

  public String getWebsite() {
    return website;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public Phone getPhone() {
    return phone;
  }

  public Address getAddress() {
    return address;
  }
}
