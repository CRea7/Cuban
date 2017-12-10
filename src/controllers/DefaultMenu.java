package controllers;

import java.util.Collection;

import asg.cliche.Command;
import asg.cliche.Param;
import models.Movie;
import models.Rating;
import models.User;

public class DefaultMenu {
	private String name;
	private User user;
	private LikeMoviesAPI LikeAPI;
	
	public DefaultMenu(LikeMoviesAPI LikeAPI, User user) {
		this.LikeAPI = LikeAPI;
		this.setName(user.fname);
		this.user=user;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//return a name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Command
	public void listUsers() throws Exception {
		Collection<User> users = LikeAPI.getUsers();
		System.out.println(users);
	}
	
	@Command(description="serach for a user")
	public User getUser(@Param(name="User Id")long id)
	{
		return LikeAPI.getUser(id);
	}
	
	@Command
	public void getMovieList() {
		Collection<Movie> movie = LikeAPI.getMovies();
		System.out.println(movie);
	}
	
	@Command(description="Get a single Movie")
	public Movie getMovie(@Param(name="MovieID")long MovieID)
	{
		return LikeAPI.getMovie(MovieID);
	}
	
	@Command(description="list All Ratings")
	public void listRatings()
	{
		Collection<Rating> ratings = LikeAPI.getRatings();
		System.out.println(ratings);
	}
	
	@Command(description="Create a new rating")
	public void addRating(@Param(name="User id")long UserID,@Param(name="Movies Id")long MovieID,@Param(name="Rating Value")float rating) 
	{
		LikeAPI.createRating(UserID, MovieID , rating);
	}
	
	
}
