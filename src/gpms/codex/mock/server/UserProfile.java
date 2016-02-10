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
* UserProfile class is a class where the user's information are stored and maintained.
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
	}
	
	public UserProfile() {
		super();
		this.username = null;
		this.password = null;
		location = null;
	}

	/**
	 * This method is a getter for the user's username.
	 * 
	 * @return the username of the user
	 */
	
	public String getUsername() {
		return username;
	}

	/**
	 * This method is a getter for the user's password.
	 * 
	 * @return the password of the user
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * This method is a getter for the user's registered mac address.
	 * 
	 * @return the the user's registered mac address.
	 */
	
	public String getlocation() {
		return location;
	}

	/**
	 * This method is a setter for the username field
	 * 
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method is a setter for the password field
	 * 
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method is a setter for the user's registered mac address.
	 * 
	 */
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}
