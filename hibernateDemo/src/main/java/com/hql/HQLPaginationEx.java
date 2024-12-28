package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Student;
import org.hibernate.query.Query;

public class HQLPaginationEx {
	public static void main(String[] args) {
		System.out.println("Project Stared...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query<Student> query = session.createQuery("from Student", Student.class);

		// implement pegination using hibernate

		query.setFirstResult(0);
		query.setMaxResults(10);

		List<Student> list = query.list();

		for (Student st : list) {
			System.out.println(st.getId() + ":" + st.getName() + ":" + st.getCity());
		}

		session.close();
		factory.close();
	}
}
