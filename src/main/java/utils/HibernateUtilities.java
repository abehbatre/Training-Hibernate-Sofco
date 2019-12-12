package utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
    private static SessionFactory sessionFactory;
    private static Logger logger = Logger.getLogger(HibernateUtilities.class);

    private static SessionFactory buildSessionFactory() {
        // Create the SessionFactory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-annotation.cfg.xml");
        logger.info("Hibernate Configuration loaded");
        ServiceRegistry serviceRegistry = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        logger.info("Hibernate serviceRegistry created");
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
