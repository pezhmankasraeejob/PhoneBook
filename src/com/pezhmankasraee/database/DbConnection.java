/**
 * 
 */
package com.pezhmankasraee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pezhman
 *
 */
public class DbConnection {
	
	private Connection conn;
	private StringBuilder url;
	private String username;
	private String password;
	
	private DbConnection() {
		super();
	}
	
	public DbConnection(String dbname, String username, String password){
		this();
		this.url = new StringBuilder("jdbc:mysql://localhost:3306/");
		this.url.append(dbname);
		this.url.append("?useSSL=false");
		
		this.username = username;
		this.password = password;
	}
	
	public Connection getDbConnection(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			this.conn = DriverManager.getConnection(url.toString(), 
					this.username, this.password);
			
		
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return this.conn;
	}
	
	public void closeConnection(){
		if(this.conn != null)
			try {
				this.conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
}
