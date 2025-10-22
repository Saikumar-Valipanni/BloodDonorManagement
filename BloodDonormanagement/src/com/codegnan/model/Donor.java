package com.codegnan.model;

public class Donor {
	private int id;
	private String name;
	private int age;
	private String BloodGroup;

	public Donor(int id, String name, int age, String bloodGroup) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		BloodGroup = bloodGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "Donar [id=" + id + ", name=" + name + ", age=" + age + ", BloodGroup=" + BloodGroup + "]";
	}

}
