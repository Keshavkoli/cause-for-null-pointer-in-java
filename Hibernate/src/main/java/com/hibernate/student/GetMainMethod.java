package com.hibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetMainMethod {
	public static void main(String[] args) {
		// get(), and load()
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		// get -StudentId : we have to provide the student class name inside the
		// session.get(classname.class,and the primary key id)

//		Student student = session.get(Student.class, 2);
//		System.out.println(":student:==>" + student);

		// the get() and the load() are of same thing there is no more difference
		// between them
		// get() and load() are similar types of method
		System.out.println("--------------------------");
		Student student = session.load(Student.class, 5);
		System.out.println("------------------------");
//		System.out.println(":student:==>" + student);
//		System.out.println(student.getFirstName());
//		System.out.println("::student==>" + student);


		System.out.println("--------------------------");
		Address ad =(Address) session.get(Address.class, 1);
		System.out.println("--------------------------");
		System.out.println(ad.getStreet());
		System.out.println(":ad:==>" + ad);

		session.close();
		factory.close();
	}
}
