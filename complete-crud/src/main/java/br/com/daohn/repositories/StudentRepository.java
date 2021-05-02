package br.com.daohn.repositories;

import br.com.daohn.model.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named("repository")
@ApplicationScoped
public class StudentRepository implements IStudentRepository {

  private EntityManager manager;

  @Inject
  public StudentRepository(EntityManager manager) {
    this.manager = manager;
  }

  @Override public void save(Student student) {
  }

  @Override public void update(Student student) {

  }

  @Override public void delete(Student student) {

  }

  @Override public Student findById(Long id) {
    return null;
  }

  @Override public List<Student> findAll() {
    return null;
  }
}
