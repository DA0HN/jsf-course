package br.com.daohn.repositories;

import br.com.daohn.model.Student;

import java.util.List;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
public interface IStudentRepository {
  void save(Student student);
  void update(Student student);
  void delete(Student student);
  Student findById(Long id);
  List<Student> findAll();
}
