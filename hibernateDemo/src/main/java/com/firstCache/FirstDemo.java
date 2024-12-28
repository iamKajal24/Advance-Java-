package com.firstCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Student;

public class FirstDemo {
	public static void main(String[] args) {
		System.out.println("Project Started...");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			//by default enabled
			
			Student student=session.get(Student.class, 1416);
			System.out.println(student);
			
			System.out.println("working something..");
			
			Student student1=session.get(Student.class, 1416);
			System.out.println(student1);
			
			System.out.println(session.contains(student1));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured...");
		}finally {
			session.close();
			factory.close();
		}
		
		
	}
}
