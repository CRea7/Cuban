package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Optional;

import models.User;
import utils.Serializer;
import models.Movie;
import models.Rating;

public class LikeMoviesAPI
{
	
  private Serializer serializer; 
  private Map<Long, User> userIndex = new HashMap<>();
  private Map<Long, Movie> movieIndex = new HashMap<>();
  private Map<Long, Rating> ratingIndex = new HashMap<>();
  private Map<String,User> userName = new HashMap<>();
  private Map<String, Movie> NameMovie = new HashMap<>();
  public Optional<User> currentUser;
  
  
  public LikeMoviesAPI()
	{
		
	}
  
  public LikeMoviesAPI(Serializer serializer)
 	{
 		this.serializer=serializer;
 	}
   
  // Log in system
  public boolean login(Long userID, String lname) {
	  Optional<User> user = Optional.fromNullable(userIndex.get(userID));
	  if (user.isPresent() && user.get().lname.equals(lname)){
	  currentUser = user;
	  System.out.println(currentUser.get().fname + " "+currentUser.get().lname + " logged in ...");
	  return true;
	  }
	  return false;
	  }
  
  
  public void logout() {
	  if (currentUser.isPresent()){
	  System.out.println(currentUser.get().fname + " logged out...");
	  currentUser = null;
	  }
	  }
 
  //all getters
  public User getUserName(String name)
  {
	  return userName.get(name);
  }
  
  public Movie getMovieName(String name)
  {
	 return NameMovie.get(name);  
  }
  
  public Collection<User> getUsers ()
  {
    return userIndex.values();
  }
  
  public Collection<Movie> getMovies()
  {
	return movieIndex.values();	  
  }
  
  //delete users
  public  void deleteUsers(long id) 
  {
    userIndex.remove(id);
  }
  
  public void deleteMovie(long ID)
  {
	  movieIndex.remove(ID);
  }
  
  public void RemoveAllMovies()
	{
		movieIndex.clear();
	}
  //create users, movies and ratings
  public User createUser(String fname, String lname,String age, String gender, String occupation,String zipCode,String role)
  {
    User user = new User (fname, lname, age, gender ,occupation, zipCode, role);
    userIndex.put(user.userID, user);
    return user;
  }

  public Movie createMovie(String name, String date,String link)
  {
    Movie movie = new Movie (name , date , link);
    movieIndex.put(movie.movieID, movie);
    return movie;
  }

  public void createRating(long userID , long movieID , float rating)
  {
	  Rating rating1 = null;
		Optional<User> user = Optional.fromNullable(userIndex.get(userID));
		Optional<Movie> movie = Optional.fromNullable(movieIndex.get(movieID));
		if(movie.isPresent() && user.isPresent()) {
			rating1 = new Rating(userID,movieID,rating);
			movie.get().MovieRating.put(rating1.ratingID, rating1);
			user.get().Ratings.put(rating1.ratingID,rating1);
			ratingIndex.put(rating1.ratingID, rating1);
			}
		}
  
    public User getUser(long id)
	{
		return userIndex.get(id);
	}
  
    public Collection<Movie> getMovie()
	{
		return movieIndex.values();
	}
    public Collection<Rating> getRatings()
	{	
		return ratingIndex.values();
	} 
    public Movie getMovie(long id)
	{
		return movieIndex.get(id);
	}

  public void deleteUser(long id) 
  {
     userIndex.remove(id);
  }
  
@SuppressWarnings("unchecked")
public void load() throws Exception {
	  
	  serializer.read();
		userIndex = (Map<Long,User>) serializer.pop();
		movieIndex = (Map<Long, Movie>) serializer.pop();
		ratingIndex = (Map<Long, Rating>) serializer.pop();
  }
  
  public void initialLoad()throws IOException {
	  
  String delims = "[|]";
  Scanner scanner = new Scanner(new File("./lib/users5.dat"));
  while (scanner.hasNextLine()) {
      String userDetails = scanner.nextLine();
      // parse user details string
      String[] userTokens = userDetails.split(delims);

      if (userTokens.length == 7) {
          createUser(userTokens[1], userTokens[2], userTokens[3], userTokens[4], userTokens[5], userTokens[6], "Admin");
      } else {
          scanner.close();
          throw new IOException("Invalid member length: " + userTokens.length);
      }
  }
  scanner.close();
  
  Scanner scanner2 = new Scanner(new File("./lib/ratings5.dat"));
  while (scanner2.hasNextLine()) {
      String userDetails = scanner2.nextLine();
      // parse user details string
      String[] userTokens = userDetails.split(delims);

      if (userTokens.length == 4) {
    	  createRating(Long.valueOf(userTokens[0]),Long.valueOf(userTokens[1]),Float.valueOf(userTokens[2]));
      } else {
          scanner.close();
          throw new IOException("Invalid member length: " + userTokens.length);
      }
  }
  scanner.close();
  
  
  Scanner scanner1 = new Scanner(new File("./lib/items5.dat"));
  while (scanner1.hasNextLine()) {
      String userDetails = scanner1.nextLine();
      // parse user details string
      String[] userTokens = userDetails.split(delims);

      if (userTokens.length == 23) {
          createMovie(userTokens[1], userTokens[2], userTokens[3]);
      } else {
          scanner1.close();
          throw new IOException("Invalid member length: " + userTokens.length);
      }
  }
  scanner1.close();
  
  /*XStream xstream = new XStream(new DomDriver());
  ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("datastore.xml"));
  out.writeObject(movieIndex);
  out.writeObject(userIndex);
  out.close();*/
  
}
  
  public void store() throws Exception
  {
	serializer.push(ratingIndex);
	serializer.push(movieIndex);
	serializer.push(userIndex);
	serializer.write();
  }
  
}
