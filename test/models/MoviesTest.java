package models;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoviesTest {

	
		Movie test = new Movie ("Thor", "October 25 2017","http://www.imdb.com/title/tt3501632/releaseinfo");
		
		@Test
		  public void testCreate()
		  {
		    assertEquals ("Thor",  test.name); 
		    assertEquals ("October 25 2017",  test.date);
		    assertEquals ("http://www.imdb.com/title/tt3501632/releaseinfo", test.link);
		  }
	
		  @Test
		  public void testToString()
		  {
		    assertEquals ("Movie{" + test.movieID + ", Thor, October 25 2017, http://www.imdb.com/title/tt3501632/releaseinfo}", test.toString());
		  }
}
