package pl.FilipRajmund.manytomany;

import org.hibernate.Session;
import pl.FilipRajmund.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeRepository {

    List<EmployeeM> insertData(final List<EmployeeM> employees) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            employees.forEach(session::persist);
            session.getTransaction().commit();
            return employees;
        }
    }

    List<EmployeeM> listEmployees() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            String query = "SELECT employee FROM Employee employee";
            List<EmployeeM> employees = session.createQuery(query, EmployeeM.class).list();
            session.getTransaction().commit();
            return employees;
        }
    }

    Optional<EmployeeM> getEmployee(Integer employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            Objects.requireNonNull(session);
            return Optional.ofNullable(session.find(EmployeeM.class, employeeId));
        }
    }
    void updateEmployee(Integer employeeId, Project newProject) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            EmployeeM employeeM = session.find(EmployeeM.class, employeeId);
            employeeM.getProjects().add(newProject);
            session.getTransaction().commit();
        }
    }

    void deleteEmployee(Integer employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            //   Objects.requireNonNull(session);
            session.beginTransaction();
            session.remove(session.find(EmployeeM.class, employeeId));
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            String query = "SELECT employee FROM EmployeeM employee";
            session.createQuery(query, EmployeeM.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

}
