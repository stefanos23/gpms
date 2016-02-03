package gpms.codex.mock.server;

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
