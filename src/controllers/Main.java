package controllers;

import java.io.File;
import java.io.IOException;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main implements ShellDependent {
	private static LikeMoviesAPI LikeAPI;
	private Shell theShell;
	private static final String Admin = "Admin";
	public void cliSetShell(Shell theShell) {
		this.theShell = theShell;
		}

	public Main(LikeMoviesAPI LikeAPI)
	{
	 Main.LikeAPI = LikeAPI;
	}
	
	@Command(description = "use to Log in")
	public void logIn(@Param(name = "id") Long UserID, @Param(name = "lname") String lname)
	throws IOException {
		if (LikeAPI.login(UserID, lname)&& LikeAPI.currentUser.isPresent()) {
			User user = LikeAPI.currentUser.get();
			System.out.println("You are logged in as " + user.fname);
			/*Optional<Boolean> role = Optional.fromNullable(user.role.equals(Admin));*/
			if (user.role != null && user.role.equals(Admin)) {
			AdminMenu adminMenu = new AdminMenu(LikeAPI, user.lname);
			ShellFactory.createSubshell(user.fname, theShell, "Admin", adminMenu).commandLoop();
			} else {
			DefaultMenu defaultMenu = new DefaultMenu(LikeAPI, user);
			ShellFactory.createSubshell(user.fname, theShell, "Default", defaultMenu).commandLoop();
			}
			} else
			System.out.println("Unknown user.");
			}
	
	
	public static void main(String args []) throws Exception{
		Main main = new Main(LikeAPI);
		File datastore = new File("datastore.xml");
		Serializer serializer = new XMLSerializer(datastore);
		
		LikeAPI = new LikeMoviesAPI(serializer);
		
		if(datastore.isFile())
		{
			LikeAPI.load();
		}
		LikeAPI.initialLoad();
		ShellFactory.createConsoleShell("LikeMovies", "use ?list to get started", main).commandLoop();
		LikeAPI.store();
	}
}
	
	