package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create Student Object
			System.out.println("Cratin new Student object...");
			Student tempStudent = new Student("Dafyy", "Duck", "dafyy@gmail.com ");

			// start transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Savind the Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			
			// my new code
			
			// Find out the student´s id: primary key
			System.out.println("Saved student. Generated id:" + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();					
			// retrieve student based on the id: primary key
			System.out.println("/Getting student with id:" + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete:" + myStudent);
			
			//commit the transaction		
			session.getTransaction().commit();
			System.out.println("Done!");

		}
		finally {
			factory.close();
		}
	}

}
