package com.grs.excel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_details")
public class ExcelDTO {

	@Id
	@Column(name = "movie_id")
	private int movieId;
	private int year;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "director_name")
	private String directorName;
	private String language;
	private String platform;
	private long budget;
	private long collection;
	private int rating;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year2) {
		this.year = year2;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public long getCollection() {
		return collection;
	}

	public void setCollection(long collection) {
		this.collection = collection;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ExcelDTO [movieId=" + movieId + ", year=" + year + ", movieName=" + movieName + ", directorName="
				+ directorName + ", language=" + language + ", platform=" + platform + ", budget=" + budget
				+ ", collection=" + collection + ", rating=" + rating + "]";
	}

}
