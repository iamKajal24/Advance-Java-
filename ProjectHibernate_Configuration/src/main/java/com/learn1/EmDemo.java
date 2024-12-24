package com.learn1;

import javax.persistence.Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// @Embeddable ka use karte hai toh -> ek class ki field ko dusre class ki field ke saath use kar sakte hai

public class EmDemo {
    public static void main(String[] args) {
        // Hibernate get and load example
        System.out.println("Project started...");

        // Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Create SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        // Creating first Student object
        StudentStudent st1 = new StudentStudent();
        st1.setId(1213);
        st1.setName("ARYAN");
        st1.setCity("DELHI");

        // Creating certificate for first student
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("PYTHON DEVELOPER");
        certificate1.setDuration("3 Months");
        
        // Assigning certificate to student
        st1.setCertifi(certificate1);

        // Creating second Student object
        StudentStudent st2 = new StudentStudent();
        st2.setId(15134);
        st2.setName("RICHA");
        st2.setCity("HALDWANI");

        // Creating certificate for second student
        Certificate certificate2 = new Certificate();
        certificate2.setCourse("HIBERNATE");
        certificate2.setDuration("1.5 Months");
        
     // Assigning certificate to student
        st2.setCertifi(certificate2);

        try {
            // Saving objects
            session.save(st1);
            session.save(st2);

            // Committing transaction
            tx.commit();

            System.out.println("Data saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            session.close();
            sessionFactory.close();
        }
    }
}
