package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.map.Student;

public class HQLExample {
    public static void main(String[] args) {
        // Creating the SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        // Using try-with-resources to manage the session
        try (Session session = factory.openSession()) {
            // HQL query to fetch all Student entities with specific city and name
            String hql = "from Student as s where s.city = :x and s.name = :n";
            Query<Student> q = session.createQuery(hql, Student.class);
            q.setParameter("x", "Haridwar");
            q.setParameter("n", "Riya");
            
            // Fetching the results as a list
            List<Student> list = q.list();
            
            // Iterating through the list and printing student details
            for (Student student : list) {
                System.out.println(student.getName() + " : " + student.getCity() + " : " + student.getCerti());
            }
            
            System.out.println("*******************************************************************");
            
            // Start a transaction for update or delete operations
            Transaction tx = session.beginTransaction();
            
            // Uncomment to execute DELETE Query
            // Query<?> deleteQuery = session.createQuery("delete from Student as s where s.name = :x");
            // deleteQuery.setParameter("x", "Riya");
            // int deleteResult = deleteQuery.executeUpdate();
            // System.out.println("Deleted...");
            // System.out.println("Rows affected: " + deleteResult);
            
            // Update Query
            Query<?> updateQuery = session.createQuery("update Student set city = :c where name = :n");
            updateQuery.setParameter("c", "Delhi");
            updateQuery.setParameter("n", "Kajal Pandit");
            int updateResult = updateQuery.executeUpdate();
            System.out.println("Updated...");
            System.out.println("Rows affected: " + updateResult);
            
            tx.commit();
            
            // How to execute Join Query
            Query<?> joinQuery = session.createQuery(
                "select q.questionId, q.Questioning from Questioning as q inner join q.Answering as a"
            );
            List<Object[]> joinResult = (List<Object[]>) joinQuery.getResultList();
            for (Object[] row : joinResult) {
                System.out.println("Question ID: " + row[0] + ", Question Text: " + row[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while executing the HQL query.");
        } finally {
            // Closing the factory
            factory.close();
        }
    }
}
