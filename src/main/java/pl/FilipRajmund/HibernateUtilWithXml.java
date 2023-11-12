package pl.FilipRajmund;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//konfiguracja Hibernate Bez Springa z plikiem XML
public class HibernateUtilWithXml {

    private static SessionFactory sessionFactory = null;

    static {
        try {
            loadSessionFactory();
        } catch (Exception ex) {
            System.err.println("Exception while initializing: " + ex);
        }
    }

    private static void loadSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("META-INF/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    static void closesSessionFactory() {
        try {
            sessionFactory.close();
        } catch (Exception ex) {
            System.err.println("Exception while closing: " + ex);
        }
    }

    static Session getSession() {
        try {
            return sessionFactory.openSession();
        } catch (Exception ex) {
            System.err.println("Exceptpion while opening session: " + ex);
        }
        return null;
    }
}
