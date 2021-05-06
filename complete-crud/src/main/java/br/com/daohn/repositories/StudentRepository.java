package br.com.daohn.repositories;

import br.com.daohn.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by daohn on 02/05/2021
 * @author daohn
 * @since 02/05/2021
 */
@Named("repository")
@ApplicationScoped
public class StudentRepository implements IStudentRepository {

  private final SessionFactory sessionFactory;

    @Inject
    public StudentRepository(@MySQLDatabase SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
    }

    @Override public void saveOrUpdate(Student student) {
      //    this.manager.getTransaction().begin();
      //    this.manager.persist(student);
      //    this.manager.getTransaction().commit();
      Session session = null;
      try {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();
      }
      catch(HibernateException exception) {
        rollbackTransaction(session, exception);
      }
      finally {
        closeSession(session);
      }
    }

    @Override public void delete(Student student) {
      Session session = null;
      try {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
      }
      catch(HibernateException exception) {
        rollbackTransaction(session, exception);
      }
      finally {
        closeSession(session);
      }
    }

    @Override public Student findById(Long id) {
      try(var session = this.sessionFactory.openSession()) {
        var query = session.createQuery(
          "SELECT student FROM Student student WHERE student.id = :id ",
          Student.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
      }
      catch(Exception exception) {
        exception.printStackTrace();
        return null;
      }
    }

  @Override public List<Student> findAll() {
    try(var session = sessionFactory.openSession()) {
      var query = session.createQuery(
        "SELECT student FROM Student student",
        Student.class
      );
      return query.getResultList();
    }
    catch(Exception exception) {
      exception.printStackTrace();
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
