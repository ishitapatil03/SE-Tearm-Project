package com.SportsWatchProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

// This tells Hibernate to make a table out of this class
@Table(name="team")
public class TeamsEntity {
    
   @GeneratedValue(strategy=GenerationType.AUTO) 
    @Id
    private int id;
	private String abbreviation;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String fav_team_name;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getFav_team_name() {
		return fav_team_name;
	}

	public void setFav_team_name(String fav_team_name) {
		this.fav_team_name = fav_team_name;
	}

	
    
    
}

