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
@Table(name = "Actor")
public class Actor {
	@Id
	@GeneratedValue(generator = "actor_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "actor_id_seq", sequenceName = "actor_id_seq")

	@Column(length=300, nullable=false)
	private Long id;

	@Column(length=75, nullable=true)
	private String firstName; 
	
	@Column(length=75, nullable=true)
	private String lastName;
	
	@Column(nullable=true)
	private Long activeSinceYear;
	
	@Column(nullable=true)
	private Date birthDate;
	
	@JsonIgnoreProperties("actors")
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies;
	
	public List<Movie>getMovies()
	{
		return movies;
	}

	
	public void setMovies(Movie movie)
	{
		this.movies.add(movie);
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Award> awards;
	
	public List<Award>getAward()
	{
		return awards;
	}
	
	public void setAward(Award award)
	{
		this.awards.add(award);
	}
	
	
	// getters and setters ..

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Long getActiveSinceYear() 
	{
		return activeSinceYear;
	}

	public void setActiveSinceYear(Long activeSinceYear) 
	{
		this.activeSinceYear = activeSinceYear;
	}

	public Date getBirthDate() 
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate) 
	{
		this.birthDate = birthDate;
	}

}
