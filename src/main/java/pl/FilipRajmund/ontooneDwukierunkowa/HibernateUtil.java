package pl.FilipRajmund.ontooneDwukierunkowa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.Map;

//konfiguracja hibernate bez springa i bez pliku xml
public class HibernateUtil {

    private static final Map<String, Object> SETTINGS = Map.ofEntries(
        Map.entry(Environment.DRIVER,"org.postgresql.Driver"),
        Map.entry(Environment.URL,"jdbc:postgresql://localhost:5432/postgres"),
        Map.entry(Environment.USER,"postgres"),
        Map.entry(Environment.PASS,"postgres"),
        Map.entry(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect"),
        Map.entry(Environment.HBM2DDL_AUTO,"none"),
        Map.entry(Environment.SHOW_SQL,true),
        Map.entry(Environment.FORMAT_SQL,true)
      //  Map.entry("hibernate.use_sql_comments","true")
    );
    private static SessionFactory sessionFactory = loadSessionFactory();

    private static SessionFactory loadSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(SETTINGS)
                    .build();


            Metadata metadata = new MetadataSources(serviceRegistry)
                  //  .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Address.class)
                    .getMetadataBuilder()
                    .build();
            return  metadata.getSessionFactoryBuilder().build();

        } catch (Throwable e) {
                throw new ExceptionInInitializerError(e);
                //jesli nie uda się utworzyć sesionFactory rzucamy wyjątkiem
        }

    }

   public static void closesSessionFactory() {
        try {
            sessionFactory.close();
        } catch (Exception ex) {
            System.err.println("Exception while closing: " + ex);
        }
    }

    public static Session getSession() {
        try {
            return sessionFactory.openSession();
        } catch (Exception ex) {
            System.err.println("Exceptpion while opening session: " + ex);
        }
        return null;
    }
}
