package com.learn1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class StudentStudent {
	@Id
	@Column
	private int id;
    @Column
	private String name;
    @Column
	private String city;
    
    private Certificate certifi;
    

	public StudentStudent(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public StudentStudent() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Certificate getCertifi() {
		return certifi;
	}

	public void setCertifi(Certificate certifi) {
		this.certifi = certifi;
	}

	@Override
	public String toString() {
		return "StudentStudent [id=" + id + ", name=" + name + ", city=" + city + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getCity()=" + getCity() + "]";
	}

}
