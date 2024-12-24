package com.learn1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// Hibernate get and load example
		System.out.println("project statred...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// Create SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// Open session
		Session session = sessionFactory.openSession();

		try {
			// Fetching student data with ID 105
			StudentStudent student = (StudentStudent) session.get(StudentStudent.class, 104);
            System.out.println(student);
//            StudentStudent student1 = (StudentStudent) session.get(StudentStudent.class, 104);
//            System.out.println(student1);
//            StudentStudent student1 = (StudentStudent) session.get(StudentStudent.class, 106);
//            System.out.println(student1);
          
            Address address = (Address) session.load(Address.class, 2);
            System.out.println(address.getStreet()+": "+address.getAddeDate());
//            Address address1 = (Address) session.load(Address.class, 2);
//            System.out.println(address1.getStreet()+": "+address1.getAddeDate());
//            Address address1 = (Address) session.load(Address.class, 5);
//            System.out.println(address1.getStreet()+": "+address1.getAddeDate());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Closing resources
			session.close();
			sessionFactory.close();
		}
	}
}
