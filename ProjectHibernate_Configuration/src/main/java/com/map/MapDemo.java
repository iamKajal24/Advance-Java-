package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
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
	        
	       // Creating question
	        Question q1= new Question();
	        q1.setQuestionId(1212);
	        q1.setQuestion("what is java ?");
	        
	        // creating answer
	        Answer an = new Answer();
	        an.setAnswerId(343);
	        an.setAnswer("Java is a programming Language");
	        an.setQuestion(q1);
	        
	     // Assigning certificate to student
	       q1.setAns(an);
	        
	        // Creating question
	        Question q2= new Question();
	        q2.setQuestionId(242);
	        q2.setQuestion("what is a collection framework ?");
	        
	        // creating answer
	        Answer an1 = new Answer();
	        an1.setAnswerId(344);
	        an1.setAnswer("API to work with Group of object");
	        an.setQuestion(q2);
	        
	     // Assigning certificate to student
	        q2.setAns(an);

	        
	        try {
	            // Saving objects
	        	session.save(q1);
	            session.save(an);
	            
	            session.save(q2);
	            session.save(an1);

	            // Committing transaction
	            tx.commit();
	            
	            //fetching
	            
	            Question newqQuestion =(Question) session.get(Question.class,343);
	            System.out.println(newqQuestion.getQuestion());
	            System.out.println(newqQuestion.getAns());

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
