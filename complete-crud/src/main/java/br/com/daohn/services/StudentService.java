package br.com.daohn.services;

import br.com.daohn.repositories.IStudentRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named("service")
@ApplicationScoped
public class StudentService implements IStudentService {

  private IStudentRepository repository;

  @Inject
  public StudentService(@Named("repository") IStudentRepository repository) {
    this.repository = repository;
  }


}
