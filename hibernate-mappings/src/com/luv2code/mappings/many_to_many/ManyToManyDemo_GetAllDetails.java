package com.luv2code.mappings.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo_GetAllDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/many_to_many/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();		
		
		session.beginTransaction();
		
		Student student=session.get(Student.class, 7);	
		
		System.out.println("Student: "+student);
		System.out.println("Student Course Details: "+student.getCourses());
		System.out.println("===========================================================================================");
		for(Course course : student.getCourses()){
			System.out.println("Course: "+course);
			System.out.println("Course Instructor: "+course.getInstructor());
			System.out.println("Course Instructor Details: "+course.getInstructor().getInstructorDetail());
			System.out.println("Course Reviews: "+course.getReviews()+"\n");
		}
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
