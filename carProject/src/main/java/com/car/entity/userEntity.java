package com.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class userEntity {
	@Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "phone", nullable = false)
    private String phone;
	
	@Column(name = "age", nullable = false)
    private String age;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
