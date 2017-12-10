package models;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserTest {

	
		User test = new User ("conor", "rea", "20","m" , "Student", "12345", "Default");
		
		@Test
		  public void testCreate()
		  {
		    assertEquals ("conor",  test.fname); 
		    assertEquals ("rea",    test.lname);
		    assertEquals ("20",     test.age);
		    assertEquals ("m",      test.gender);
		    assertEquals ("Student",test.occupation);
		    assertEquals ("12345",  test.zipCode);
		    assertEquals ("Default",test.role);
		  }

		  @Test
		  public void testToString()
		  {
		    assertEquals ("User{" + test.userID + ", conor, rea, 20, m, Student, 12345, Default}", test.toString());
		  }
}
