package com.luv2code.mappings.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo_Create {

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
		
		Course course1=new Course("Mechanics");
		Course course2=new Course("Thermodynamics");
		Course course3=new Course("Industrial");
		
		Student student=new Student("saranya","nakka","bsnakka@gmail.com");
		Student student1=new Student("krishna","palanki","krishnapalanki@gmail.com");		
		
		Review review1=new Review("Good Course");
		Review review2=new Review("Outstanding");
		Review review3=new Review("Bad course material");

		Instructor tempInstructor=new Instructor("pavan","palanki","pavan@gamail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("pavan@youtube.com","Love to code");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		tempInstructor.addCourse(course1);
		tempInstructor.addCourse(course2);
		tempInstructor.addCourse(course3);
		
		course1.addReview(review1);
		course2.addReview(review2);
		course2.addReview(review1);
		course3.addReview(review3);	
		
		session.beginTransaction();
		
		session.save(tempInstructor);
		session.save(tempInstructorDetail);				
		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(review1);
		session.save(review2);
		session.save(review3);		
		session.save(student);
		session.save(student1);		
		course1.addStudent(student);
		course2.addStudent(student1);
		course3.addStudent(student);		
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
