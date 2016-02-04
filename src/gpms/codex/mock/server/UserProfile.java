/*
 * UserProfile.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.mock.server;

/**
*
* UserProfile class is a class were the user's informtion are stored and maintained.
* UserProfile is used when the user is using our system, so his information can be maintained on real time.
*
* @author TeamCodex
* @version 1.1 First relocation
* @see Exception
* 
*/

public class UserProfile {

	private String username;
	private String password;
	private String location;
	
	public UserProfile(String username, String password, String location) {
		super();
		this.username = username;
		this.password = password;
		location = location;
	}
	
	public UserProfile() {
		super();
		this.username = null;
		this.password = null;
		location = null;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getlocation() {
		return location;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}
