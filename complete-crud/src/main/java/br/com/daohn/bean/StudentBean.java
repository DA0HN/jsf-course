package br.com.daohn.bean;

import br.com.daohn.services.IStudentService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named
@SessionScoped
public class StudentBean implements Serializable {

  private IStudentService service;

  @Inject
  public StudentBean(@Named("service") IStudentService service) {
    this.service = service;
  }
}
