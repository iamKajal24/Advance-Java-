package com.learn1;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException  {
		System.out.println("Project Started!");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
//         Session session = sessionFactory.openSession();
//         Transaction transaction=session.beginTransaction();
//		System.out.println(sessionFactory);
//		System.out.println(sessionFactory.isClosed());

		// create studdent
		StudentStudent st = new StudentStudent();
		st.setId(105);
		st.setName("RAHUL");
		st.setCity("CANADA");
		System.out.println(st);
		
		//creating object of address class
		Address add = new Address();
		add.setStreet("Street1");
		add.setCity("DELHI");
		add.setOpen(true);
		add.setAddeDate(new Date());
		add.setX(123.4545);
		
		//Reading Image
		FileInputStream fis = new FileInputStream("src/main/java/com/learn1/img.jpg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		add.setImage(data);
		
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.save(st);
			session.save(add);
			transaction.commit();
			System.out.println("done...");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}
}
