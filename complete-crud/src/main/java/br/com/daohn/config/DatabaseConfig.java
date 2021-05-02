package br.com.daohn.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@ApplicationScoped
public class DatabaseConfig {
  @Produces
  @PersistenceContext(unitName = "student")
  private EntityManager entityManager;

}
