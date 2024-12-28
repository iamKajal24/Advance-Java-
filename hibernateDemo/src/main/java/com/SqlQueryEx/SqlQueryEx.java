package com.SqlQueryEx;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.map.Student;

public class SqlQueryEx {

	public static void main(String[] args) {
		// Creating the SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Opening a session
		try (Session session = factory.openSession()) {
			// Native SQL Query
			String query = "SELECT * FROM Student"; // Ensure "Student" matches your database table name
			NativeQuery<Object[]> nq = session.createSQLQuery(query);

			// Executing the query and fetching the results
			List<Object[]> list = nq.list();

			// Iterating through the list and printing student details
			for (Object[] student : list) {
				// Accessing the columns using indices
//                String name = (String) student[1];  // Assuming the 2nd column is 'name'
//                String city = (String) student[2]; // Assuming the 3rd column is 'city'
//                String certi = (String) student[3]; // Assuming the 4th column is 'certi'

				// System.out.println(name + ":" + city + ":" + certi);
				// or
				// System.out.println(Arrays.deepToString(student));
				// or
				System.out.println(student[2] + ":" + student[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred while executing the SQL query.");
		} finally {
			// Closing the factory
			factory.close();
		}
	}
}
