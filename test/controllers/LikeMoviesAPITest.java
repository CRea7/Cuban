package controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class LikeMoviesAPITest {
	
	private LikeMoviesAPI LikeAPI = new LikeMoviesAPI();

	@Test
	public void testAddUser() {
		assertEquals(0, LikeAPI.getUsers().size());
		LikeAPI.createUser("Conor", "Rea", "20", "M", "Student", "12345", "Default");
		assertEquals(1, LikeAPI.getUsers().size());
	}
	
	@Test
	public void testAddMovie() {
		assertEquals(0, LikeAPI.getMovie().size());
		LikeAPI.createMovie("Thor", "6/10/2017", "www.imdb.com/thor");
		assertEquals(1, LikeAPI.getMovie().size());
	}
	
}
