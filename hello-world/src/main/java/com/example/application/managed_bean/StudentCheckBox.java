package com.example.application.managed_bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by daohn on 01/05/2021
 * @author daohn
 * @since 01/05/2021
 */
@Named
@SessionScoped
public class StudentCheckBox implements Serializable {


  private String firstName;
  private String lastName;
  private String[] programmingLanguages;

  public StudentCheckBox() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String[] getProgrammingLanguages() {
    return programmingLanguages;
  }

  public void setProgrammingLanguages(String[] programmingLanguages) {
    this.programmingLanguages = programmingLanguages;
  }
}
