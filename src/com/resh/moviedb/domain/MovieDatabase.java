package com.resh.moviedb.domain;

import java.util.HashMap;
import java.util.Map;

public class MovieDatabase {

	private Map<String,Movie> movies;
	
	public MovieDatabase() {
		this.movies = new HashMap<String,Movie>();
	}
	
	public void store(Movie movie) {
		movies.put(movie.getTitle(), movie);
	}
	
	public Movie retrieve(String title) {
		
		if(movies.containsKey(title))
			return movies.get(title);
		else
			return null;
	}

}
