package pl.FilipRajmund.ontooneDwukierunkowa;

import org.hibernate.Session;
//import pl.FilipRajmund.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//definiowanie CRUD przy pomocy Hibernate
public class CustomerRepository {

    Customer insertCustomer(final Customer customer){
        try (Session session = HibernateUtil.getSession()) {
                        if (Objects.isNull(session)){
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
            return customer;
        }
    }


    List<Customer> listCustomers() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            String query = "SELECT cust FROM Customer cust";
            List<Customer> customers = session.createQuery(query, Customer.class).list();
            session.getTransaction().commit();
            return customers;
        }
    }

    Optional<Customer> getCustomer(final Integer customerId) {
        try (Session session = HibernateUtil.getSession()) {
            Objects.requireNonNull(session);
          return  Optional.ofNullable(session.find(Customer.class, customerId));
        }
    }


    void updateCustomer(Integer customerId, Address newAddress) {
        try (Session session = HibernateUtil.getSession()) {
            Objects.requireNonNull(session);
            session.beginTransaction();
            Customer customer = session.find(Customer.class, customerId);
            customer.setAddress(newAddress);
            session.getTransaction().commit();
        }
    }

    void deleteCustomer(Integer customerID) {
        try (Session session = HibernateUtil.getSession()) {
            Objects.requireNonNull(session);
            session.beginTransaction();
            session.remove(session.find(Customer.class, customerID));
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesion is null");
            }
            session.beginTransaction();
            String query = "SELECT cust FROM Customer cust";
            session.createQuery(query, Customer.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
}
