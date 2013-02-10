package com.resh.moviedb.domain;

public class MovieDatabaseProxy {

	private MovieDatabase movies;
	private MovieRequestHandler request;
	
	public MovieDatabaseProxy() {
		movies = new MovieDatabase();
		request = new MovieRequestHandler();
	}

	public Movie retrieveAndStore(String title) {
		
		if(movies.retrieve(title) == null) {
			Movie movie = request.handleRequest(title);
			movies.store(movie);
			return movie;
		} else {
			return movies.retrieve(title);
		}
	}
}
