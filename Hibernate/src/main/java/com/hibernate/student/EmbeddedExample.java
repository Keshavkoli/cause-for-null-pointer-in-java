package com.hibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student stu1 = new Student();
		stu1.getFirstName();
		stu1.getLastName();
		System.out.println(":stu1:==>" + stu1);

		Certificate cert = new Certificate();
		cert.setCourse("Andriod");
		cert.setDuration("2 Months");
		System.out.println(":cert:==>" + cert);
		stu1.setCerti(cert);

		// below are the important steps 
		Session s = factory.openSession();
		// if we have to see the manual changes in database we can use the Transaction tsx
		Transaction tsx = s.beginTransaction();

		// save Object
		s.save(stu1);

		tsx.commit();
		s.close();
		factory.close();
	}
}
