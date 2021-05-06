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

  private final EntityManager manager;

  @Inject
  public StudentRepository(EntityManager manager) {
    this.manager = manager;
  }

  @Override public void save(Student student) {
    this.manager.getTransaction().begin();
    this.manager.persist(student);
    this.manager.getTransaction().commit();
  }

  @Override public void update(Student student) {
    this.manager.getTransaction().begin();
    this.manager.merge(student);
    this.manager.getTransaction().commit();
  }

  @Override public void delete(Student student) {
    this.manager.getTransaction().begin();
    this.manager.remove(student);
    this.manager.getTransaction().commit();
  }

  @Override public Student findById(Long id) {
    var query = this.manager.createQuery(
      "SELECT student FROM Student student WHERE student.id = :id ",
      Student.class
    );
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  @Override public List<Student> findAll() {
    var query = this.manager.createQuery(
      "SELECT student FROM Student student",
      Student.class
    );
    return query.getResultList();
  }
}
