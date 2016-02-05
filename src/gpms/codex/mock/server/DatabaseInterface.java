/*
 * DatabaseInterface.java 1.1 2016/02/03
 * 
 * Copyright (c) 2015 University of York.
 * All rights reserved. 
 *
 */

package gpms.codex.mock.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * DatabaseInterface class is a class that handles all the connections with the
 * database. DatabaseInterface is used to register or obtain user's accounts.
 * 
 * @author TeamCodex
 * @version 1.1 First relocation
 * @see H2.database
 * 
 */

public class DatabaseInterface {

	static final String DBNAME = "second_factor_db";
	static final String DBPATH = "jdbc:h2:~/" + DBNAME;

	protected UserProfile getProfileByName(String username) {

		try {
			Class.forName("org.h2.Driver");

			Connection conn = DriverManager.getConnection(DBPATH, "sa", "sa"); // (2)

			PreparedStatement prepStmt = conn
					.prepareStatement("SELECT Password,mac_address"
							+ " FROM USERACCOUNT WHERE userName = ?");
			prepStmt.setString(1, username);
			ResultSet rs = prepStmt.executeQuery();
			UserProfile user = new UserProfile();
			if (rs.next()) {
				user.setPassword(rs.getString(1));
				user.setLocation(rs.getString(2));
			}

			prepStmt.close();
			conn.close();

			return user;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * This method initialise the database raws and should be called only once
	 * and before we start using the system. Please notice that this method is
	 * unique and there are no similar initialisation methods to our system.
	 * 
	 */

	protected void initialize_database() {

		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(DBPATH, "sa", "sa");

			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS USERACCOUNT(id int IDENTITY(1,1) primary key, userName varchar(255), password varchar(255),"
					+ " mac_address varchar(255))");

			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is called when we want to register a new user and bond his
	 * account with a specific device-mac address.
	 * 
	 * @param username
	 * @param password
	 * @param mac_address
	 */

	protected void createUserAccountWithLocationInfo(String username,
			String password, String mac_address) {

		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(DBPATH, "sa", "sa");

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
			e.printStackTrace();
		}

	}

	/**
	 * This is a main class that needs to be run only the first time we use the
	 * system to initialise the batabase's raws.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		DatabaseInterface asdd = new DatabaseInterface();
		asdd.initialize_database();
	}
}
