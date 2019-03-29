package com.stackroute.muzixapp.model;

import javax.persistence.*;

@Entity
public class Track {

	@Id     //primary key
	@GeneratedValue(strategy = GenerationType.AUTO)   //auto increment
	private int id;
	@Column
	private String name;
	@Column
	private String comment;

	public Track() {
		super();
	}

	public Track(int id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}