package gpms.codex.mock.server;

public class SystemRegister{

	public void login_with_location(String username, String password, String location) throws BadInputException, LocationNotSupportedException{
		
		DatabaseInterface db = new DatabaseInterface();
		UserProfile user = db.getProfileByName(username);
		
		if(user == null){
			Throwable t = new IllegalArgumentException("Bad Input");
            throw new BadInputException("There in no such user", t);
		}
		if(!password.equals(user.getPassword())){
			Throwable t = new IllegalArgumentException("Bad Input");
            throw new BadInputException("Wrong username", t);
		}
		if(!location.equals(user.getlocation())){
			Throwable t = new IllegalArgumentException("Bad Input");
            throw new LocationNotSupportedException("Your device is not authorized", t);
		}
	}
	
	public void check_usename_availability(String username){
		
	}
	
	public void register_with_location(String username, String password, String mac_address){
		
		/*
		 * Here we must have input control
		 */
		
		DatabaseInterface db = new DatabaseInterface();
		db.createUserAccountWithLocationInfo(username, password, mac_address);
		
	}
	
	public void register_with_nfc(){
		
	}
	
	public void registe_with_images(String... imgs){
		
	}
	
	
}
