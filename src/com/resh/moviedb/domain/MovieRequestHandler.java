package com.resh.moviedb.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieRequestHandler {
	
	private String urlString = "http://www.omdbapi.com/?i=&t={title}";
	
	public MovieRequestHandler() { }
	
	private String getUrlStringWithTitle(String title) {
		return urlString.replace("{title}", title.replace(" ", "+"));
	}
	
	public Movie handleRequest(String title) {
		  URL url;
	      HttpURLConnection conn;
	      BufferedReader rd;
	      String line;
	      String result = "";
	      Movie movies = null;
	      try {
	         url = new URL(getUrlStringWithTitle(title));
	         conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod("GET");
	         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         while ((line = rd.readLine()) != null) {
	            result += line;
	         }
	         rd.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      JSONObject myjson;
		try {
			myjson = new JSONObject(result);
			movies = new Movie(myjson.get("Title").toString(),myjson.get("Released").toString(),myjson.get("Genre").toString(),myjson.get("Poster").toString() ); 

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return movies;
	}
	
//	public static void main(String[] s) {
//		Movie m = (new MovieRequestHandler()).handleRequest("p.s. i love you");
//		
//		System.out.println(m.getTitle());
//		System.out.println(m.getReleaseDate());
//		System.out.println(m.getGenres());
//		System.out.println(m.getPoster());
//	}
}