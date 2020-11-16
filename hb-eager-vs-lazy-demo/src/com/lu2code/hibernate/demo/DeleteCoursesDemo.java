package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get a course
			int theId = 10;
			Course temCourse = session.get(Course.class, theId);

			// delete course
			System.out.println("Deleting courses" + temCourse);

			session.delete(temCourse);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
