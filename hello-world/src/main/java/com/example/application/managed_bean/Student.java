package com.example.application.managed_bean;


import javax.inject.Named;

/**
 * Created by daohn on 29/04/2021
 * @author daohn
 * @since 29/04/2021
 */
@Named
public class Student {

  private String firstName;
  private String lastName;

  // create no-arg constructor
  public Student() {
  }

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // define getter/setter methods
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
}
