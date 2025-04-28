package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	String name;
	String address;
	String mobile;
	String email;
	String username;
	String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String name, String address, String mobile, String email, String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
}
