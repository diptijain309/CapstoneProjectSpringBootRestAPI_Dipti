package com.jd.teams.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employeesdata")
public class Employee {
	
	@Id
	@Column(name = "username", nullable = false)
	private String username;
	private String fname;
	private String lname;
	private String role;
	private String product;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private ScrumTeams scrumteamname;

	public Employee() {
		super();
		System.out.println("Inside Employee class");
	}

	public Employee(String username, String fname, String lname, String role, String product,
			ScrumTeams scrumteamname) {
		super();
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.product = product;
		this.scrumteamname = scrumteamname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public ScrumTeams getScrumteamname() {
		return scrumteamname;
	}

	public void setScrumteamname(ScrumTeams scrumteamname) {
		this.scrumteamname = scrumteamname;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", fname=" + fname + ", lname=" + lname + ", role=" + role
				+ ", product=" + product + ", scrumteamname=" + scrumteamname + "]";
	}

	
	
}
