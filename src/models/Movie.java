package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Movie {
	static long   counter = 0l;
	public long   movieID = 0l;
	public String name;
	public String date;
	public String link;
	public float rating1;
	public float ratingID;
	
	public Map<Long, Rating> MovieRating = new HashMap<>();
	
	
	
	public Movie(String name, String date, String link)
	{
		this.movieID = counter++;
		this.name = name;
		this.date = date;
		this.link = link;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(movieID)
                				   .addValue(name)
                				   .addValue(date)
                				   .addValue(link)
                				   .toString();
	}
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.movieID, this.name, this.date, this.link);  
	  }
}
