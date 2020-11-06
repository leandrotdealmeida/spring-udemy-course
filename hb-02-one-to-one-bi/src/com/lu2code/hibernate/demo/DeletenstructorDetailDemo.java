package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;
import com.lu2code.hibernate.demo.entity.Student;

public class DeletenstructorDetailDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 1;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// now let's delete the instructor detail
			System.out.println("Deleting tempIntructorDetail:" + tempInstructorDetail);
			
			// remove the associated object reference
			// break bi-direcional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			//handle connection lleak issue
			session.close();
			
			factory.close();
		}
	}

}
