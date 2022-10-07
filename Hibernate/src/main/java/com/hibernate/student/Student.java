package com.hibernate.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;
	private String firstName;
	private String lastName;
	private String className;
	private String rollNo;
	private int age;
	private Certificate certi;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", className=" + className + ", rollNo=" + rollNo + ", age=" + age + ", certi=" + certi + "]";
	}

	public Student(String firstName, String lastName, String className, String rollNo, int age) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.className = className;
		this.rollNo = rollNo;
		this.age = age;
	}

	public Student() {
		super();
	}

	public Certificate getCerti() {
		return certi;
	}

	public void setCerti(Certificate certi) {
		this.certi = certi;
	}

	public Student(Certificate certi) {
		super();
		this.certi = certi;
	}

}
