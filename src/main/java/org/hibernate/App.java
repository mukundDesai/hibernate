package org.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Planet pluto = new Planet();
        pluto.setPlanet_no(101);
        pluto.setName("pluto");
        pluto.setClimate("cold");

        Alien mukund = new Alien();
        mukund.setColour("purple");
        mukund.setAid(101);
        mukund.setName("mukund");
        mukund.setPlanet(pluto);

        Alien anagha = new Alien();
        anagha.setName("anagha");
        anagha.setAid(102);
        anagha.setColour("purple");
        anagha.setPlanet(pluto);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Alien.class).addAnnotatedClass(Planet.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        SessionFactory factory = configuration.buildSessionFactory(builder.build());

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(pluto);
        session.persist(mukund);
        session.persist(anagha);

        transaction.commit();

        session.close();
        factory.close();
    }
}


/*
 * use the Configuration class to load the hibernate.config file (use configure() and addAnnotatedClass() methods
 * create a service registry builder using StandardServiceRegistryBuilder class (use applySettings() method and pass config.getProperties() as parameter
 * build SessionFactory and pass builder.build() as parameter
 * open a Session
 * Create a Transaction*/

//        save() was never part of JPA. Since hibernate came before JPA they continued with it and now deprecated and will be removed in the future.
//        persist(): Persist methods are used to save newly created entities
//        merge(): should be used to update detached entity object.
//        update(): It forces the transition of Entity obj from detached to persistent state. It doesn't make unnecessary SELECT calls unlike merge()
//        Note: INSERT statements will occur only upon committing the transaction, or flushing or closing the session.