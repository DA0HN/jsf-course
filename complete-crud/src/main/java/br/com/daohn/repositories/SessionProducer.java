package br.com.daohn.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named
@ApplicationScoped
public class SessionProducer {
  @Produces
  @SessionQualifier
  public SessionFactory getSessionFactory() {
    var standardRegistry = new StandardServiceRegistryBuilder()
                                                 .configure("hibernate.cfg.xml").build();
    var metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
    return metaData.getSessionFactoryBuilder().build();
  }
}
