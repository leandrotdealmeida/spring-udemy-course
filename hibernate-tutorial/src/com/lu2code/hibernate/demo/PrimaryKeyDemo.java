package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 Students Objects
			System.out.println("Cratin 3 Students objects...");
			Student tempStudent1 = new Student("Paul", "Wall", "japa@gmail.com ");
			Student tempStudent2 = new Student("Josh", "Public", "josh@gmail.com ");
			Student tempStudent3 = new Student("Mary", "Applebaum", "mary@gmail.com ");

			// start transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Savind the Student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
