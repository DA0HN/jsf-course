package com.sales.services;

import com.sales.entities.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named("produtoService")
public class ProdutoService implements Serializable, IProdutoService {

  private final SessionFactory sessionFactory;

  @Inject
  public ProdutoService(@SessionQualifier SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override public void salvar(Produto produto) {
    Session session = null;
    try {
      session = sessionFactory.openSession();

      session.beginTransaction();

      session.saveOrUpdate(produto);

      session.getTransaction().commit();

    }
    catch(HibernateException h) {
      this.rollbackTransaction(session, h);
    }
    finally {
      this.closeSession(session);
    }
  }

  @Override public List<Produto> buscarTodos() {
    try(Session session = sessionFactory.openSession()) {

      Query<Produto> query = session.createQuery("SELECT produto FROM Produto produto", Produto.class);

      return query.getResultList();
    }
    catch(Exception e) {
      e.printStackTrace();

      return null;
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
