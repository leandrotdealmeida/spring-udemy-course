package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;
import com.lu2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// Create objects
			/*
			 * Instructor tempInstructor = new Instructor("Leandro", "Japa",
			 * "leandrotrovilho@gmail.com");
			 * 
			 * InstructorDetail instructorDetail = new
			 * InstructorDetail("leandrotrovilho@gmail.com", "Code Programing");
			 */

			Instructor tempInstructor = new Instructor("Juha2", "Layna3", "juhao@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Code Develop");

			// associate the objects
			tempInstructor.setInstructorDetail(instructorDetail);

			// start transaction
			session.beginTransaction();

			// save the instructor
			// Note: this will also save the details object
			// because of CascadeType.all
			System.out.println("Saving instructor " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
