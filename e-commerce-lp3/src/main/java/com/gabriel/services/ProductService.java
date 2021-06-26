package com.gabriel.services;

import com.gabriel.domain.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author daohn
 * @since 21/06/2021
 */
@ApplicationScoped
@Named("service")
public class ProductService implements Serializable, IProductService {

  private final SessionFactory sessionFactory;

  @Inject
  public ProductService(@SessionQualifier SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override public void save(Product product) {
    Session session = null;
    try {
      session = sessionFactory.openSession();

      session.beginTransaction();

      session.saveOrUpdate(product);

      session.getTransaction().commit();

    }
    catch(HibernateException h) {
      this.rollbackTransaction(session, h);
    }
    finally {
      this.closeSession(session);
    }
  }

  @Override public List<Product> findAll() {
    try(Session session = sessionFactory.openSession()) {

      Query<Product> query = session.createQuery("SELECT produto FROM Product produto", Product.class);

      return query.getResultList();
    }
    catch(Exception e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  private void rollbackTransaction(Session session, HibernateException exception) {
    if(session != null && session.getTransaction().isActive()) {
      session.getTransaction().rollback();
    }
    throw exception;
  }

  private void closeSession(Session session) {
    if(session != null && session.isOpen()) {
      session.close();
    }
  }
}
