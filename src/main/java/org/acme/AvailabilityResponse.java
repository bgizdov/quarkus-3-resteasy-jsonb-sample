package org.acme;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AvailabilityResponse {
  private String typeChambre;

  public void setTypeChambre(String xxx) {
    typeChambre = xxx;
  }

  public String getTypeChambre() {
    return typeChambre;
  }
}
