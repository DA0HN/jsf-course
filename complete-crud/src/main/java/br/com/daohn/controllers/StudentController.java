package br.com.daohn.controllers;

import br.com.daohn.model.Student;
import br.com.daohn.services.IStudentService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named
@SessionScoped
public class StudentController implements Serializable {

  private final IStudentService service;

  private List<Student> students;

  @Inject
  public StudentController(@Named("service") IStudentService service) {
    this.service = service;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void loadStudent() {
    this.students = this.service.findAll();
  }
}
