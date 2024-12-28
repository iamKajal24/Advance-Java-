package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StartDemo {
    public static void main(String[] args) {
        /*
         * Practical of Hibernate object States:
         * Transient
         * Persistent
         * Detached
         * Removed
         */
        System.out.println("Project Started...");

        // Build SessionFactory with proper configuration
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Creating Student object
        Student student = new Student();
        student.setId(1569);
        student.setName("RAHUL");
        student.setCity("DEHRADUN");
        student.setCerti(new Certificate("SPRINGBOOT", "3 months"));

        // Student: Transient state
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            
            // Save student object
            session.save(student);
            // Student: Persistent state (associated with session and database)
            
            tx.commit();
            session.close();
            
            //student:Detached
            //student.setName("SACHIN");
            //System.out.println(student);
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Closing the factory
        factory.close();
    }
}
