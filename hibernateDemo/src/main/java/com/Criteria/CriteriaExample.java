package com.Criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.map.Student;


public class CriteriaExample {
	public static void main(String[] args) {
		System.out.println("Project Started...");
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

		Criteria c = session.createCriteria(Student.class);
		//filer data 
		//c.add(Restrictions.eq("city", "haridwar"));
//		c.add(Restrictions.eq("certi.course", "springboot"));
		c.add(Restrictions.like("name", "a%"));
		//c.add(Restrictions.gt("id", 2));
		
		List<Student> students=c.list();
		for(Student st:students) {
			System.out.println(st);
		}
		
		session.close();
	}
}
