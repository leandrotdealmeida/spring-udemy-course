package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			
//		    int studentId = 1;	
//			
//			// now get a new session and start transaction
//			session = factory.getCurrentSession();
//			session.beginTransaction();		
//			
//			// retrieve student based on the id: primary key
//			System.out.println("/Deleting student with id:" + studentId);
//			
//			Student myStudent = session.get(Student.class, studentId);
//			System.out.println("Delete Student...");
//			
//			session.delete(myStudent);
//			
//			System.out.println("Delete Student...");
//			
//			
//			//commit the transaction		
//			session.getTransaction().commit();
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Delete student for name
			System.out.println("Delete student for name");
			
			session.createQuery("delete from Student where first_name = 'Mary'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");

		}
		finally {
			factory.close();
		}
	}

}
