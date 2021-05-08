package br.com.daohn.controllers;

import br.com.daohn.model.Student;
import br.com.daohn.services.IStudentService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named
@ViewScoped
public class StudentController implements Serializable {

  private final IStudentService service;
  private final Logger logger = Logger.getLogger(getClass().getName());
  private List<Student> students;
  private Student student = new Student();

  @Inject
  public StudentController(@Named("service") IStudentService service) {
    this.service = service;
    this.students = new ArrayList<>();
  }

  public List<Student> getStudents() {
    return students;
  }

  public void loadStudent() {
    this.students.clear();
    logger.info("Loading students");
    this.students = this.service.findAll();
  }

  public String save(Student student) {
    logger.info("Adding student: " + student);
    try {
      this.service.save(student);
    }
    catch(Exception exception) {
      logger.log(Level.SEVERE, "Error adding students", exception);
      // add error message for JSF page
      addErrorMessage(exception);
      return null;
    }
    return "list-students?faces-redirect=true";
  }

  public String delete(Student student) {
    logger.info("Delete student: " + student);
    try {
      this.service.delete(student);
    }
    catch(Exception exception) {
      logger.log(Level.SEVERE, "Error deleting student: " + student, exception);
      // add error message for JSF page
      addErrorMessage(exception);
      return null;
    }
    return "list-students?faces-redirect=true";
  }

  public String update(Student student) {
    logger.info("Delete student: " + student);
    try {
      this.service.update(student);
    }
    catch(Exception exception) {
      logger.log(Level.SEVERE, "Error deleting student: " + student, exception);
      // add error message for JSF page
      addErrorMessage(exception);
      return null;
    }
    return "list-students?faces-redirect=true";
  }

  public String findById(Long id) {

    logger.info("Loading student: " + id);

    try {
      Student aStudent = this.service.findById(id);
      this.student.setId(aStudent.getId());
      this.student.setFirstName(aStudent.getFirstName());
      this.student.setLastName(aStudent.getLastName());
      this.student.setEmail(aStudent.getEmail());
    }
    catch(Exception exception) {
      // send this to server logs
      logger.log(Level.SEVERE, "Error loading student id: " + id, exception);

      // add error message for JSF page
      addErrorMessage(exception);

      return null;
    }
    return "update-student-form.xhtml;includeViewParams=true";
  }

  private void addErrorMessage(Exception exception) {
    FacesMessage message = new FacesMessage("Error: " + exception.getMessage());
    FacesContext.getCurrentInstance().addMessage(null, message);
  }

  public Student getStudent() {
    return this.student;
  }
}
