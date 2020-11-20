package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {			
			
			// start transaction
			session.beginTransaction();
			
			// option : HIvernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "WHERE i.id=:theInstructorId",
					Instructor.class);
			
			
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instrucotr: " + tempInstructor);
			

			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// get course for the instructor

			System.out.println("luv2code:Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
