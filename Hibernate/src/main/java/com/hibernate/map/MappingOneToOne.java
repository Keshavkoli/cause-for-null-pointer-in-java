package com.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingOneToOne {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question means creating objects

		Question q1 = new Question();
		q1.setQuestionId(1);
		q1.setQuestion("what is java");
		System.out.println(":q1:==>" + q1);

		// creating answer object
		Answer ans = new Answer();
		ans.setAnswerId(121);
		ans.setAnswer("java is a object oreiented programming language");
		System.out.println(":ans:==>" + ans);

		// set the answer into the q1setAnswer()

		q1.setAnswer(ans);

		// to save to need session and tell factory to open the new session

		Question q2 = new Question();
		q2.setQuestionId(2);
		q2.setQuestion("what is collection framework");
		System.out.println(":q2:==>" + q2);
		// creating answer object
		Answer ans1 = new Answer();
		ans1.setAnswerId(122);
		ans1.setAnswer("API to work with objects in java");
		System.out.println(":ans1:==>" + ans1);
		
		q2.setAnswer(ans1);

		Session s = factory.openSession();
		System.out.println(":s:====>"+s);

		// if work is done then close

		// and if we want to change the data physically and permanent we use the
		// Transaction

		Transaction tx = s.beginTransaction();
		System.out.println(":tx:====>"+tx);

		// save
		s.save(q1);
		s.save(q2);

		// and tx.commit(); because we want physical changes inside the database
		tx.commit();
		s.close();
		factory.close();
	}
}
