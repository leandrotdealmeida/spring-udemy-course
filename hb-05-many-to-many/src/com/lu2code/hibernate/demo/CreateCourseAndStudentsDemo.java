package com.lu2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;
import com.lu2code.hibernate.demo.entity.Review;
import com.lu2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one Million Points");
			
			
			//save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("\nSaved the course ..." + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("Leandro", "Almeida", "leandro@email.com");
			Student tempStudent2 = new Student("Japa", "Japa Japa", "japa@email.com");
			
			// add studentd to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the student
			System.out.println("\n Saving students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("\n Saved students: " + tempCourse.getStudents());

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
