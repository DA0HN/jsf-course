package com.example.application;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by daohn on 01/05/2021
 * @author daohn
 * @since 01/05/2021
 */
@Named
@SessionScoped
public class Student implements Serializable {

  private String firstName;
  private String lastName;
  private String email;

  private String freePasses;
  private String postalCode;

  private String courseCode;

  public Student() {
  }

  public void validateTheCourseCode(FacesContext context, UIComponent component, Object value) throws ValidatorException {

    // if "value" does not pass validation based on your business rules then throw an exception
    if(!((String) value).startsWith("DAO")) {
      // Adds error message
      var message = new FacesMessage("O código do curso precisa iniciar com 'DAO'");

      throw new ValidatorException(message);
    }
    // if "value" passes validation, then this method ends gracefully

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFreePasses() {
    return freePasses;
  }

  public void setFreePasses(String freePasses) {
    this.freePasses = freePasses;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }
}
