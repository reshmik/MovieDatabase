package com.resh.moviedb.domain;

public class Movie {

	private String title;
	private String releaseDate;
	private String genres;
	private String poster;
	
	public Movie(String title, String releaseDate, String genres, String poster) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.genres = genres;
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
