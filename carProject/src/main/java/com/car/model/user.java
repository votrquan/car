package com.car.model;

public class user {
	int id;
String phoneNumber;
String name;
String age;

public user(int id, String phoneNumber, String name, String age)
{
	this.id = id;
	this.phoneNumber = phoneNumber;
	this.name = name;
	this.age = age;
}
public user() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
}
