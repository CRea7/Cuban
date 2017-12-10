package models;

import static com.google.common.base.MoreObjects.toStringHelper;


public class Rating {
	static long   counter = 0l;
	public long   userID = 0l;
	public long   movieID = 0l;
	public long   ratingID = 0l;
	public float  rating;
	
	public Rating()
	{
		
	}
	public Rating(long userID, long movieID, float rating)
	{
		this.rating = rating;
		this.movieID = movieID;
		this.userID = userID;
		this.ratingID = counter++;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(userID)
                				   .addValue(movieID)
                				   .addValue(ratingID)
                				   .addValue(rating)
                				   .toString();
	}

}