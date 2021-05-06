package br.com.daohn.services;

import br.com.daohn.model.Student;
import br.com.daohn.repositories.IStudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named("service")
@ApplicationScoped
public class StudentService implements IStudentService {

  private final IStudentRepository repository;

  @Inject
  public StudentService(@Named("repository") IStudentRepository repository) {
    this.repository = repository;
  }


  @Override public void save(Student student) {
    // TODO: implementar método save
  }

  @Override public void update(Student student) {
    // TODO: implementar método update
  }

  @Override public void delete(Student student) {
    // TODO: implementar método delete
  }

  @Override public Student findById(Long id) {
    return this.repository.findById(id);
  }

  @Override public List<Student> findAll() {
    return this.repository.findAll();
  }
}
