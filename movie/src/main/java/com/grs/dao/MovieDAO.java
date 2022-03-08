package com.grs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.grs.model.Movie;

public class MovieDAO {

	public Movie getMovie(int id) throws ClassNotFoundException {
	Connection connection = null;
	Statement statement = null;
	String query = "select * from movies where movie_id ="+id;
	Movie movie = new Movie();

	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");
		statement = connection.createStatement();
		ResultSet set = statement.executeQuery(query);
		if(set.next()) {
			movie.setMovieId(set.getInt("movie_id"));
			movie.setMovieName(set.getString("movie_name"));
			movie.setDirectorName(set.getString("director_name"));
			movie.setLanguage(set.getString("language"));
		}
		System.out.println(movie);
		System.out.println("movie saved successfully");
	}catch(SQLException e)
	{
		e.printStackTrace();

	}finally
	{
		try {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	return movie;

	}	
}
