/**
 * 
 */
package com.pezhmankasraee.phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pezhmankasraee.phonebook.person.Person;

/**
 * @author pezhman
 *
 */
public class DbManager {

	private Connection conn;

	private DbManager() {
		super();
	}

	public DbManager(Connection connectionObj) {
		this();
		this.conn = connectionObj;

	}

	public void showAllPhones() {
		StringBuilder sql = new StringBuilder("SELECT * ");
		sql.append("FROM db_phonebook.tbl_person");
		long counter = 0L;

		PreparedStatement preStmt = null;
		ResultSet rs;

		try {

			preStmt = this.conn.prepareStatement(sql.toString());

			rs = preStmt.executeQuery();

			System.out.println("<<< Reports:");
			System.out.println();

			while (rs.next()) {
				System.out.println(">> Record no. " + ++counter);

				shapeOutput(rs);
			}

			System.out.println("Total number of record(s): " + counter + ".");
			System.out.println("<<< End of report >>>");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preStmt != null)
				try {
					preStmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

		}

	}

	/**
	 * @param rs
	 * @throws SQLException
	 */
	private void shapeOutput(ResultSet rs) throws SQLException {
		System.out.println("Full name: " + rs.getString("f_fullname"));
		System.out.println("   Mobile: " + rs.getString("f_mobile"));
		System.out.println("    Phone: " + rs.getString("f_phone"));
		System.out.println("    Email: " + rs.getString("f_email"));
		System.out.println("  Address: " + rs.getString("f_address"));
		System.out.println("  Country: " + rs.getString("f_country"));
		System.out.println("    Notes: " + rs.getString("f_notes"));
		System.out.println();
	}

	public void insertRecord(Person person) {

		StringBuilder query = new StringBuilder("INSERT INTO ");
		query.append("db_phonebook.tbl_person ");
		query.append("(f_fullname, "
				+ "f_mobile, "
				+ "f_phone, "
				+ "f_email, "
				+ "f_address, "
				+ "f_country, "
				+ "f_notes) ");
		query.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

		PreparedStatement preStmt = null;

		try {
			preStmt = this.conn.prepareStatement(query.toString());

			preStmt.setString(1, person.getFullName());
			preStmt.setString(2, person.getMobile());
			preStmt.setString(3, person.getPhone());
			preStmt.setString(4, person.getEmail());
			preStmt.setString(5, person.getAddress());
			preStmt.setString(6, person.getCountry());
			preStmt.setString(7, person.getNotes());

			preStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preStmt != null)
				try {
					preStmt.close();
					System.out.println("<<< One recored was added to the database. >>>");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}

	public void deleteRecord(String fullname) {
		StringBuilder preOperationQuery = new StringBuilder("SELECT * FROM ");
		preOperationQuery.append("db_phonebook.tbl_person ");
		preOperationQuery.append("WHERE f_fullname = ?");

		PreparedStatement preStmt = null;
		PreparedStatement preStmtExistanceCheck = null;
		ResultSet rs = null;

		StringBuilder query = new StringBuilder("DELETE FROM ");
		query.append("db_phonebook.tbl_person ");
		query.append("WHERE f_fullname = ?");

		try {

			preStmtExistanceCheck = this.conn.prepareStatement(preOperationQuery.toString());
			preStmtExistanceCheck.setString(1, fullname);
			rs = preStmtExistanceCheck.executeQuery();

			if (rs.isBeforeFirst()) {

				preStmt = this.conn.prepareStatement(query.toString());

				preStmt.setString(1, fullname);

				preStmt.executeUpdate();

				System.out.println("<<< One record (" + fullname.toUpperCase() + ") is deleted. >>>");
			} else
				System.out.println("<<< The record (" + fullname.toUpperCase() + ") was not found. >>>");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preStmt != null)
					preStmt.close();

				if (preStmtExistanceCheck != null)
					preStmtExistanceCheck.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private ResultSet findRecord(String fullname) {
		StringBuilder query = new StringBuilder("SELECT * FROM db_phonebook.tbl_person ");
		query.append("WHERE f_fullname = ?");

		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			preStmt = this.conn.prepareStatement(query.toString());
			preStmt.setString(1, fullname);

			rs = preStmt.executeQuery();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return rs;

	}

	public void updateRecord(String fullname) {

		StringBuilder query = new StringBuilder("UPDATE db_phonebook.tbl_person ");
		query.append("SET f_mobile = ?, ");
		query.append("f_phone = ?, ");
		query.append("f_email = ?, ");
		query.append("f_address = ?, ");
		query.append("f_country = ?, ");
		query.append("f_notes = ? ");
		query.append("WHERE f_fullname = ?");

		PreparedStatement preStmt = null;
		ResultSet rs = this.findRecord(fullname);
		try {
			Scanner sc = new Scanner(System.in);
			
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					shapeOutput(rs);
				}

				Person agent = new Person(fullname);
				System.out.println("WARNING: You are going to update the record (" 
						+ fullname.toUpperCase() + ").");
				System.out.print("Enter mobile: ");
				agent.setMobile(sc.nextLine());

				System.out.print("Enter phone: ");
				agent.setPhone(sc.nextLine());

				System.out.print("Enter e-mail: ");
				agent.setEmail(sc.nextLine());

				System.out.print("Enter address: ");
				agent.setAddress(sc.nextLine());

				System.out.print("Enter country: ");
				agent.setCountry(sc.nextLine());

				System.out.print("Enter notes: ");
				agent.setNotes(sc.nextLine());

				preStmt = this.conn.prepareStatement(query.toString());
				preStmt.setString(1, agent.getMobile());
				preStmt.setString(2, agent.getPhone());
				preStmt.setString(3, agent.getEmail());
				preStmt.setString(4, agent.getAddress());
				preStmt.setString(5, agent.getCountry());
				preStmt.setString(6, agent.getNotes());
				preStmt.setString(7, fullname);

				preStmt.executeUpdate();

				System.out.println("<<< One record ("
						+ fullname.toUpperCase() +") is updated. >>>");

			} else
				System.out.println("<<< The record (" + fullname.toUpperCase() + ") was not found. >>>");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void searchRecords(String word){
		StringBuilder query = new StringBuilder("SELECT * FROM db_phonebook.tbl_person ");
		query.append("WHERE f_fullname LIKE ?");
		long counter = 0L;
		
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			preStmt = this.conn.prepareStatement(query.toString());
			preStmt.setString(1, "%" + word + "%");

			rs = preStmt.executeQuery();

			while(rs.next()){
				System.out.println(">> Record no. " + ++counter);
				this.shapeOutput(rs);
			}

			System.out.println("Total number of record(s) that maches the phrase ("
					+ word.toUpperCase() + "): " + counter + ".");
			System.out.println("<<< End of search report >>>");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	}
}
