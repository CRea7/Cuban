package controllers;

import java.util.ArrayList;
import java.util.Collection;

import models.Rating;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import models.Movie;
import models.User;

public class AdminMenu implements ShellDependent {
	
			private String name;
			private LikeMoviesAPI LikeAPI;
			
			public AdminMenu(LikeMoviesAPI LikeAPI, String name) {
				this.LikeAPI = LikeAPI;
				this.setName(name);
			}
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			//create user movie and rating
			@Command(description="Create a new user")
			public void addUser(@Param(name="first name") String firstName, @Param(name="last name") String lastName, 
		            @Param(name="age")      String age,     @Param(name="gender")  String gender,   @Param(name="occupation") String occupation,
		            @Param(name="zipCode")   String zipCode, @Param(name="role") String role)
			{
				
				LikeAPI.createUser(firstName,lastName,age,gender,occupation,zipCode,role);
			}
			
			@Command(description="Create a new movie")
			public void addMovie(@Param(name="Name") String name, @Param(name="date") String date, @Param(name="link") String link){
				LikeAPI.createMovie(name, date, link);
			}
			
			@Command(description="Create a new rating")
			public void addRating(@Param(name="User id")long UserID,@Param(name="Movies Id")long MovieID,@Param(name="Rating Value")float rating) 
			{
				LikeAPI.createRating(UserID, MovieID , rating);
			}

			
			@Command(description="removes a user")
			public void removeUser(long UserID){
				LikeAPI.deleteUsers(UserID);
			}
			
			@Command(description="Remove a Movie")
			public void removeMovie(long movieID)
			{
				LikeAPI.deleteMovie(movieID);
			}
			
			@Command(description="Remove all movies")
			public void removeAllMovies()
			{
				LikeAPI.RemoveAllMovies();
			}
			
			@Command(description="lists users")
			public void listUsers() throws Exception {
				Collection<User> users = LikeAPI.getUsers();
				System.out.println(users);
			}
			
			@Command(description="serach for a user")
			public User getUser(@Param(name="User Id")long id)
			{
				return LikeAPI.getUser(id);
			}
			
			@Command(description="List all movies")
			public void getMovieList() {
				Collection<Movie> movie = LikeAPI.getMovies();
				System.out.println(movie);
			}
			
			@Command(description="list All Ratings")
			public void listRatings()
			{
				Collection<Rating> ratings = LikeAPI.getRatings();
				System.out.println(ratings);
			}
			
			@Command(description = "get user by name")
			public void getUserByName(String name) {
		
				ArrayList<User> userSearch = new ArrayList<User>();
				userSearch.addAll(LikeAPI.getUsers());
				for(int t = 0; t < userSearch.size(); t++) {
					if(userSearch.get(t).fname.toLowerCase().contains(name.toLowerCase())) {
					System.out.println(userSearch.get(t));
				}
				}
			}
			
			@Command(description = "get movie by name")
			public void getMovieName(String name) {
		
				ArrayList<Movie> movieSearch = new ArrayList<Movie>();
				movieSearch.addAll(LikeAPI.getMovie());
				for(int t = 0; t < movieSearch.size(); t++) {
					if(movieSearch.get(t).name.toLowerCase().contains(name.toLowerCase())) {
					System.out.println(movieSearch.get(t));
				}
				}
			}
			
			@Command(description="search for a Movie")
			public Movie getMovie(@Param(name="MovieID")long MovieID)
			{
				return LikeAPI.getMovie(MovieID);
			}

			@Override
			public void cliSetShell(Shell arg0) {
				// TODO Auto-generated method stub
				
			}
}
