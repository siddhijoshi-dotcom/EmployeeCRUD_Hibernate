package Service;

import app.HibernateUtil;
import entity.EmployeeEntity;
import org.hibernate.*;
import java.sql.Date;
import java.util.List;

public class EmployeeService {
    private final SessionFactory sessionFactory = EntityManagerFactory.getSessionFactory();

    public void createEmployee(String fn, String ln, String em, Date hd) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            EmployeeEntity e = new EmployeeEntity();
            e.setFirstName(fn);
            e.setLastName(ln);
            e.setEmail(em);
            e.setHireDate(hd);
            session.persist(e);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        }
    }

    public EmployeeEntity findEmployee(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(EmployeeEntity.class, id);
        }
    }

    public List<EmployeeEntity> findAllEmployees() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from EmployeeEntity", EmployeeEntity.class).list();
        }
    }

    public void updateEmployee(int id, String fn, String ln, String em, Date hd) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            EmployeeEntity e = session.get(EmployeeEntity.class, id);
            if (e != null) {
                e.setFirstName(fn);
                e.setLastName(ln);
                e.setEmail(em);
                e.setHireDate(hd);
                session.merge(e);
                tx.commit();
            }
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            EmployeeEntity e = session.get(EmployeeEntity.class, id);
            if (e != null) {
                session.remove(e);
                tx.commit();
            }
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        }
    }

    public void shutdown() {
        EntityManagerFactory.shutdown();
    }
}
