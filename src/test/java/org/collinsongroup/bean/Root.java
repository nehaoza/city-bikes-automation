package org.collinsongroup.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
  private List<Networks> networks;

  public void setNetworks(List<Networks> networks) {
    this.networks = networks;
  }

  public List<Networks> getNetworks() {
    return this.networks;
  }
}
