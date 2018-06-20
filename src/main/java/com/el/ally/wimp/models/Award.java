package com.el.ally.wimp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name = "Award")
	public class Award {
		@Id
		@GeneratedValue(generator = "actor_id_seq", strategy = GenerationType.AUTO)
		@SequenceGenerator(name = "actor_id_seq", sequenceName = "actor_id_seq")

		@Column(length=300, nullable=false)
		private Long id;
		
		@Column(length=500, nullable=false)
		private String title;
		
		@Column(length=200, nullable=false)
		private String organization;
		
		@Column()
		private int year;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getOrganization() {
			return organization;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		// getters & setters
		
		
	
}
