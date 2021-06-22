package com.sales.services;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

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
