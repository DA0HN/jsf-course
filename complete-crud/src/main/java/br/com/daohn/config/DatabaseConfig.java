package br.com.daohn.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */

public class DatabaseConfig {

  @Produces
  public EntityManager getEntityManager() {
    return Persistence.createEntityManagerFactory("student").createEntityManager();
  }

}
