package org.collinsongroup.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Networks
{
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<String> company;

  private String href;

  private String id;

  private Location location;

  private String name;

  public void setCompany(List<String> company){
    this.company = company;
  }
  public List<String> getCompany(){
    return this.company;
  }
  public void setHref(String href){
    this.href = href;
  }
  public String getHref(){
    return this.href;
  }
  public void setId(String id){
    this.id = id;
  }
  public String getId(){
    return this.id;
  }
  public void setLocation(Location location){
    this.location = location;
  }
  public Location getLocation(){
    return this.location;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
}

