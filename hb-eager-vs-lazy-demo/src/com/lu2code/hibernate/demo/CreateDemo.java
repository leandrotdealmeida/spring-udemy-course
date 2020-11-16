package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;
import com.lu2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// delete the instructors
			if (tempInstructor != null) {
				System.out.println("Deleting: "+ tempInstructor);
				
				//Note: will also delete associate details object because of CascadeType.ALL
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
