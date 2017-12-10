package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User {
	static long   counter = 0l;
	public long   userID = 0l;
	public String fname;
	public String lname;
	public String age;
	public String gender;
	public String occupation;
	public String zipCode;
	public String role;
	public float rating1;
	public float rating;
	
	public Map<Long, Rating> Ratings = new HashMap<>();
	
	public User(String fname, String lname, String age, String gender, String occupation, String zipCode,String role)
	{
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
		this.userID = counter++;
		this.role = role;
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(userID)
                				   .addValue(fname)
                				   .addValue(lname)
                				   .addValue(age)
                				   .addValue(gender)
                				   .addValue(occupation)
                				   .addValue(zipCode)
                				   .addValue(role)
                				   .toString();
	}
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.lname, this.fname, this.age, this.gender,this.occupation, this.zipCode,this.role);  
	  }
}
