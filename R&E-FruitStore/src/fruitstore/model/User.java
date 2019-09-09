package fruitstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import fruitstore.utility.db.DBCommands;
import fruitstore.utility.db.Database;
import fruitstore.utility.security.MD5Encrypt;

public class User implements DBCommands{
	ServletContext application;
	private String firstName, lastName, email, userName, password, phoneNumber = null;
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		if(phoneNumber.isBlank())
			this.phoneNumber = phoneNumber;
	}
	
	public User(String firstName, String lastName, String email, String userName,
			String password, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		if(phoneNumber.isBlank())
			this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean checkDuplicateUsername(String temp_userName) {
		boolean hasDuplicate = true;
		ResultSet result = null;
		Connection connection = Database.getConnection();
		
		if(connection != null) {
			//System.out.println("Connection is successful!");
			
			try {
				PreparedStatement pstmt = connection.prepareStatement(CHECK_UNAME);
				pstmt.setString(1, temp_userName);
				
				result = pstmt.executeQuery();
				if(!result.next())
					return !hasDuplicate;
				else
					return hasDuplicate;
			} catch(SQLException sqle) {
				sqle.getMessage();
			}
		} else {
			System.err.println("Unable to connect to server!");
		}
		return hasDuplicate;
	}
	
	public boolean checkDuplicateEmail(String temp_email) {
		boolean hasDuplicate = true;
		ResultSet result = null;
		Connection connection = Database.getConnection();
		
		if(connection != null) {
			//System.out.println("Connection is successful!");
			
			try {
				PreparedStatement pstmt = connection.prepareStatement(CHECK_EMAIL);
				pstmt.setString(1, temp_email);
				
				result = pstmt.executeQuery();
				if(!result.next())
					return !hasDuplicate;
				else
					return hasDuplicate;
			} catch(SQLException sqle) {
				sqle.getMessage();
			}
		} else {
			System.err.println("Unable to connect to server!");
		}
		return hasDuplicate;
	}
	
	public void addUser() {
		boolean isRegistered = false;
		Connection connection = Database.getConnection();
		
		if(connection != null) {
			//System.out.println("Connection is successful!");
			
			try {
				PreparedStatement pstmtInfo = connection.prepareStatement(ADD_USER_INFO),
						pstmtLogin = connection.prepareStatement(ADD_USER);
				pstmtInfo.setString(1, getUserName());
				pstmtInfo.setString(2, getFirstName());
				pstmtInfo.setString(3, getLastName());
				pstmtInfo.setString(4, getPhoneNumber());
				pstmtInfo.setString(5, getEmail());
				
				pstmtLogin.setString(1, getUserName());
				pstmtLogin.setString(2, MD5Encrypt.MD5(getPassword()));
				
				if(pstmtInfo.executeUpdate() == 1 && pstmtLogin.executeUpdate() == 1)
					isRegistered = !isRegistered;
				
				if(isRegistered)
					System.out.println("Successfully registered!");
				else
					System.out.println("Failed to register! Unable to connect to server.");
			} catch(SQLException sqle) {
				sqle.getMessage();
			}
		} else {
			System.err.println("Unable to connect to server!");
		}
	}
	
	
}
