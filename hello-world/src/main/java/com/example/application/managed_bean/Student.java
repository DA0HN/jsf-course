package com.example.application.managed_bean;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by daohn on 29/04/2021
 * @author daohn
 * @since 29/04/2021
 */
@Named
@SessionScoped
public class Student implements Serializable {

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

  @PostConstruct
  public void init() {
    System.out.println("Student Bean has been created!");
  }
}
