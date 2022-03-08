package com.grs.socialmedia.dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="social_media")
@NamedQuery(name = "fetchByRevenue", query = "select sm from SocialMediaDTO as sm where sm.revenue=:rvn")
@NamedQueries(value = { @NamedQuery(name = "fetchAll", query = "select sm from SocialMediaDTO as sm"),
						@NamedQuery(name = "fetchAppName", query = "select sm.name from SocialMediaDTO as sm"),
						@NamedQuery(name = "updateRatingByName", query = "update SocialMediaDTO sm set sm.ratings=:rating where sm.name=:appName")})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SocialMediaDTO {
	
	@Id
	private int id;
	private String name;
	private float revenue;
	private double version;
	private double ratings;
	
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
	public float getRevenue() {
		return revenue;
	}
	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "SocialMediaDTO [id=" + id + ", name=" + name + ", revenue=" + revenue + ", version=" + version
				+ ", ratings=" + ratings + "]";
	}

}
