package com.map2;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {

		System.out.println("Poject started...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Emp e1= new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(50);
		e1.setName("RamLal");
		
		e2.setEid(45);
		e2.setName("ShyamLalPrasad");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(121);
		p1.setProjectName("school management system");
		
		p2.setPid(142);
		p2.setProjectName("Todolist");
		
		List<Emp> employee= new ArrayList<Emp>();
		List<Project> projects = new ArrayList<Project>();
		
		employee.add(e1);
		employee.add(e2);
		
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		p1.setEmps(employee);
		
		try {
			
			session.save(e1);
			session.save(e2);
			session.save(p1);
			session.save(p2);
           tx.commit();
           System.out.println("data successfully stored");
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("error occured...");
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
