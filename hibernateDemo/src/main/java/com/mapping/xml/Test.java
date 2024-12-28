package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        System.out.println("Project started...");

        // Create SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open a session
        Session session = factory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        try {
            // Create a new Person object
            Person person = new Person(23, "Ram", "Delhi", "53546");

            // Save the person object to the database
            session.save(person);

            // Commit the transaction
            tx.commit();

            System.out.println("Person saved successfully!");
        } catch (Exception e) {
            // Rollback transaction in case of error
            
            e.printStackTrace();
        } finally {
            // Close the session and factory
            session.close();
            factory.close();
        }
    }
}
