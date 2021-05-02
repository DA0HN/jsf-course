package com.example.application;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named
@SessionScoped
public class TourBean implements Serializable {

  private String kindOfTour;


  public TourBean() {
  }

  public String startTheTour() {
    return kindOfTour != null && kindOfTour.equalsIgnoreCase("city") ? "city-tour" : "country-tour";
  }


  public String getKindOfTour() {
    return kindOfTour;
  }

  public void setKindOfTour(String kindOfTour) {
    this.kindOfTour = kindOfTour;
  }
}
