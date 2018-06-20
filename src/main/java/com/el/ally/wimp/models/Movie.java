package com.el.ally.wimp.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(generator = "movie_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq")

	@Column(length=300, nullable=false)
	private Long id; 
	
	@Column(length = 300, nullable = false)
	private String title;

	@Column(nullable = false)
	private Date releaseDate;

	@Column(nullable = true)
	private Long budget;

	@Column(length = 500, nullable = false)
	private String distributor;
	
	@JsonIgnoreProperties("movies")
	@ManyToMany
	private List<Actor> actors;
	
	public List<Actor>getActors()
	{
		return actors;
	}
	
	public void setActor(Actor actor)
	{
		this.actors.add(actor);
	}
	
	// getters and setters
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTtitle(String title)
	{
		this.title = title;
	}
	
	public Date getReleaseDate()
	{
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	
	public Long getBudget()
	{
		return budget;
	}
	
	public void setBudget(Long budget)
	{
		this.budget = budget;
	}
	
	public String getDistributor()
	{
		return distributor;
	}
	
	public void setDistributor(String distributor)
	{
		this.distributor = distributor;
	}
}
