package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;
import com.lu2code.hibernate.demo.entity.Review;
import com.lu2code.hibernate.demo.entity.Student;

public class AddCoursesForMayDemo {

	public static void main(String[] args) {

		// create ssesion facotry
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {			
			
			
			// start transaction
			session.beginTransaction();
			
			// get the student japa from databse
			int theStudent = 2;
			Student tempStudent = session.get(Student.class, theStudent);
			
			System.out.println("\n Loaded student: " + tempStudent);
			System.out.println("Courses: "+ tempStudent.getCourses());			
			
			// create more courses
			Course temCourse1 = new Course("Rubik's CUbe - How to Speed Cube");
			Course temCourse2 = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			temCourse1.addStudent(tempStudent);
			temCourse2.addStudent(tempStudent);
			
			// save the courses
			
			System.out.println("\n Saving The courses");
			session.save(temCourse1);
			session.save(temCourse2);

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
