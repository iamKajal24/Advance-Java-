package com.Cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Student;
import com.map1.Answering;
import com.map1.Questioning;

public class CascadingExam {
	public static void main(String[] args) {
		System.out.println("Project Started...");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		try {
			Questioning ques = new Questioning();
	        ques.setQues_id(343);
	        ques.setQuestions("What is Java?");
	        
	        Answering ans1 = new Answering();
	        ans1.setAnsId(242);
	        ans1.setAnswer("Java is a programming language.");
	        ans1.setQuestion(ques); // Linking to questi
	        
	        Answering ans2 = new Answering();
	        ans2.setAnsId(243);
	        ans2.setAnswer("With the help of Java, we can create software.");
	        ans2.setQuestion(ques);
	        
		    List<Student> list=new ArrayList();
		    list.add(ans1);
		    list.add(ans2);
		    
		    session.save(ques);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error oucurred...");
		} finally {
			session.close();
			factory.close();
		}
	}
}
