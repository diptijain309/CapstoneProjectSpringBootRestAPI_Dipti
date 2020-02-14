package com.jd.teams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Scrumteams")
public class ScrumTeams {
	@Id
	@GeneratedValue
	private int id;
	private String teamname;

	public ScrumTeams() {
		super();
		System.out.println("Inside ScrumTeams class");
	}

	public ScrumTeams(int id, String teamname) {
		super();
		this.id = id;
		this.teamname = teamname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	@Override
	public String toString() {
		return "ScrumTeams [id=" + id + ", teamname=" + teamname + "]";
	}

}
