package org.collinsongroup.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location
{
  private String city;

  private String country;

  private double latitude;

  private double longitude;

  public void setCity(String city){
    this.city = city;
  }
  public String getCity(){
    return this.city;
  }
  public void setCountry(String country){
    this.country = country;
  }
  public String getCountry(){
    return this.country;
  }
  public void setLatitude(double latitude){
    this.latitude = latitude;
  }
  public double getLatitude(){
    return this.latitude;
  }
  public void setLongitude(double longitude){
    this.longitude = longitude;
  }
  public double getLongitude(){
    return this.longitude;
  }
}