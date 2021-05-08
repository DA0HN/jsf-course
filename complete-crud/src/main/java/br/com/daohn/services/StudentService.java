package br.com.daohn.services;

import br.com.daohn.model.Student;
import br.com.daohn.repositories.IStudentRepository;

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
@Named("service")
@SessionScoped
public class StudentService implements IStudentService, Serializable {

  private final IStudentRepository repository;

  @Inject
  public StudentService(@Named("repository") IStudentRepository repository) {
    this.repository = repository;
  }


  @Override public void save(Student student) {
    this.repository.saveOrUpdate(student);
  }

  @Override public void update(Student student) {
    this.repository.saveOrUpdate(student);
  }

  @Override public void delete(Student student) {
    this.repository.delete(student);
  }

  @Override public Student findById(Long id) {
    return this.repository.findById(id);
  }

  @Override public List<Student> findAll() {
    return this.repository.findAll();
  }
}
