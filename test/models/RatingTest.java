package models;

import static org.junit.Assert.*;
import org.junit.Test;


public class RatingTest {

	
		Rating test = new Rating (1L, 1L, 4.0f);
		
		@Test
		  public void testCreate()
		  {
		    assertSame (test.userID, 1l);   
		    assertSame (test.movieID, 1l);
		  }
	

		  @Test
		  public void testToString()
		  {
		    assertEquals (test.toString(),"Rating{1, 1, 0, 4.0}");
		  }
}
