package gpms.codex.mock.server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInterface {

	static final String DBNAME = "second_factor_db";
	
	protected UserProfile getProfileByName(String username){
		
		try {
			Class.forName("org.h2.Driver");
		
        Connection conn
          = DriverManager.getConnection("jdbc:h2:~/" + DBNAME, "sa", "sa"); // (2)
        
        PreparedStatement prepStmt = conn.prepareStatement("SELECT Password,mac_address" +
        		" FROM USERACCOUNT WHERE userName = ?");
        prepStmt.setString(1, username);
        ResultSet rs = prepStmt.executeQuery();
        UserProfile user = new UserProfile();
        if(rs.next()){
        	user.setPassword(rs.getString(1));
        	user.setLocation(rs.getString(2));
        }
        
        prepStmt.close();
        conn.close();
        
        return user;
        

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	protected void initialize_database(){
		
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/" + DBNAME, "sa", "sa");
		
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS USERACCOUNT(id int IDENTITY(1,1) primary key, userName varchar(255), password varchar(255)," +
					" mac_address varchar(255))");
			
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void createUserAccountWithLocationInfo(String username, String password, String mac_address){
		
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/" + DBNAME, "sa", "sa");
		
			PreparedStatement prepStmt = null;
			
			String insertUser = "INSERT INTO USERACCOUNT( userName, password, mac_address ) VALUES(?,?,?)";
			 prepStmt = conn.prepareStatement(insertUser);
			 prepStmt.setString(1, username);
			 prepStmt.setString(2, password);
			 prepStmt.setString(3, mac_address);
			 prepStmt.executeUpdate();
			 prepStmt.close();
			 
			 conn.close();
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] asd){
		DatabaseInterface asdd = new DatabaseInterface();
		asdd.initialize_database();
	}
}
