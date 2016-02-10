/*
 * SystemRegister.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.mock.server;

/**
 * 
 * SystemRegister class is the main (mock)server class. SystemRegister is used
 * to register or login a user.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see UserProfile
 * @see DatabaseInterface
 * @see LocationNotSupportedException
 * @see BadInputException
 * 
 */

public class SystemRegister {

	/**
	 * With this method the user can login using their credentials and by using
	 * a specific and registered device.
	 * 
	 * @param username
	 * @param password
	 * @param location
	 * @throws BadInputException
	 * @throws LocationNotSupportedException
	 */

	public void loginWithLocation(String username, String password, String location)
	throws BadInputException, LocationNotSupportedException {

		DatabaseInterface db = new DatabaseInterface();
		UserProfile user = db.getProfileByName(username);

		// checks for inputs validity
		if (user == null) {
			Throwable t = new IllegalArgumentException("Bad Input");
			throw new BadInputException("There in no such user", t);
		}
		if (!password.equals(user.getPassword())) {
			Throwable t = new IllegalArgumentException("Bad Input");
			throw new BadInputException("Wrong username", t);
		}
		if (!location.equals(user.getlocation())) {
			Throwable t = new IllegalArgumentException("Bad Input");
			throw new LocationNotSupportedException(
					"Your device is not authorized", t);
		}
	}

	// to be implemented if needed
	public void checkUsenameAvailability(String username) {
			
	}

	/**
	 * With this method the user can register to the system using a username, a
	 * password and a specific mac address.
	 * 
	 * @param username
	 * @param password
	 * @param mac_address
	 */

	public boolean registerWithLocation(String username, String password,
			String mac_address) {

		/*
		 * Here we will put input control if the customer asks for that.
		 */

		DatabaseInterface db = new DatabaseInterface();
		if( db.checkUsernameExists(username)){
			//if there is already an account with the selected database return false
			return false;
		}
		
		db.createUserAccountWithLocationInfo(username, password, mac_address);
		return true;

	}

}
