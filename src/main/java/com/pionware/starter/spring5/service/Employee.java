package com.pionware.starter.spring5.model;

import java.util.Date;

public class Employee {
	
	private String firstName;
	private String lastName;
	private Date birthdate;
	private Integer age;
	private Double salary;
	private String position;
	private Department dept;
	private Integer deptId;
	
	public Employee(){
		System.out.println("an employee is created.");
		System.out.println(this.toString());
	}

	public Employee(String firstName, String lastName, Date birthdate, Integer age, Double salary, String position,
			Department dept) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.age = age;
		this.salary = salary;
		this.position = position;
		this.dept = dept;
		System.out.println("an employee is created.");
		System.out.println(this.toString());
	}

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", age="
				+ age + ", salary=" + salary + ", position=" + position + ", dept=" + dept + ", deptId=" + deptId + "]";
	}


	

}
