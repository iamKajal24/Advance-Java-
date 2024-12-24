package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
	public static void main(String[] args) {
		System.out.println("Project started...");

		// Hibernate configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session ss = sessionFactory.openSession();
		Transaction tx = ss.beginTransaction();

//		 Creating a question
        Questioning ques = new Questioning();
        ques.setQues_id(343);
        ques.setQuestions("What is Java?");

        // Creating multiple answers
        Answering ans1 = new Answering();
        ans1.setAnsId(242);
        ans1.setAnswer("Java is a programming language.");
        ans1.setQuestion(ques); // Linking to question

        Answering ans2 = new Answering();
        ans2.setAnsId(243);
        ans2.setAnswer("With the help of Java, we can create software.");
        ans2.setQuestion(ques);

        Answering ans3 = new Answering();
        ans3.setAnsId(244);
        ans3.setAnswer("Java has different types of frameworks.");
        ans3.setQuestion(ques);
//
        // Adding answers to a list
        List<Answering> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);
        answers.add(ans3);
        ques.setAnswers(answers); 

		try {
			// Saving the question (cascades answers due to cascade configuration)
			 ss.save(ques);
//			 ss.save(answers);

			// fetching the data
//			Questioning questioning = (Questioning) ss.get(Questioning.class, 343);
//			System.out.println(questioning.getQuestions());
//
//			for (Answering ans : questioning.getAnswers()) {
//				System.out.println(ans.getAnswer());
//			}
			
			tx.commit();
			System.out.println("Data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred...");
		} finally {
			ss.close();
			sessionFactory.close();
		}
	}
}
