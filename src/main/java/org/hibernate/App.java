package org.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Alien alien = new Alien();
        alien.setAid(108);
        alien.setName("Amma");
        alien.setColour("Pink");

        Alien empty = new Alien();

        System.out.println(empty);

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        SessionFactory factory = configuration.buildSessionFactory(builder.build());

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();           //to ensure ACID properties apply

        session.persist(alien);

        empty = (Alien) session.get(Alien.class,104);

        System.out.println(empty);

        transaction.commit();

        session.close();
        factory.close();
    }
}


//        save() was never part of JPA. Since hibernate came before JPA they continued with it and now deprecated and will be removed in the future.
//        persist(): Persist methods are used to save newly created entities
//        merge(): should be used to update detached entity object.
//        update(): It forces the transition of Entity obj from detached to persistent state. It doesn't make unnecessary SELECT calls unlike merge()
//        Note: INSERT statements will occur only upon committing the transaction, or flushing or closing the session.