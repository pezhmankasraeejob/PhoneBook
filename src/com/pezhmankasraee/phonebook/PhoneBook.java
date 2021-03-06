/**
 * 
 */
package com.pezhmankasraee.phonebook;

import java.io.Console;
import java.util.Scanner;

import com.pezhmankasraee.database.DbConnection;
import com.pezhmankasraee.phonebook.menu.Menu;
import com.pezhmankasraee.phonebook.person.*;
/**
 * @author pezhman
 *
 */
public class PhoneBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String user = null;
		String pass = null;
		String dbname = null; 

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the username: ");
		user = sc.nextLine();

		Console inPass = System.console();

		System.out.print("Enter the password: ");
		pass = new String(inPass.readPassword());


		System.out.print("Enter the database name: ");
		dbname = sc.nextLine();

		DbConnection dbConn; 
		dbConn = new DbConnection(dbname, user, pass);

		DbManager dbMan;
		dbMan = new DbManager(dbConn.getDbConnection());



		String item;
		do{
			item = Menu.startMenu();

			switch (item) {
			case "0":
				System.out.println("Good bye");
				break;

			case "1":
				dbMan.showAllPhones();
				break;
			case "2":
				enterDataForInsert(dbMan);
				break;

			case "3":
				enterDeleteRecord(dbMan);
				break;

			case "4":
				enterUpdateRecord(dbMan);
				break;

			case "5":
				enterSearchRecord(dbMan);
				break;

			default:
				System.out.println("Default");
				break;
			}
		}while(!item.equals("0"));


		//dbMan.showAllPhones();

		dbConn.closeConnection();

	}



	/**
	 * @param dbMan
	 */
	private static void enterSearchRecord(DbManager dbMan) {
		String fullname = null;
		
		try{
			Scanner findSc = new Scanner(System.in);
			
			System.out.print("Enter fullname: ");
			fullname = findSc.nextLine();
			
			dbMan.searchRecords(fullname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	/**
	 * @param dbMan
	 */
	private static void enterUpdateRecord(DbManager dbMan) {
		String fullname = null;
		
		try {
			Scanner updSc = new Scanner(System.in);
			
			System.out.print("Enter fullname: ");
			fullname = updSc.nextLine();
			
			dbMan.updateRecord(fullname);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	/**
	 * @param dbMan
	 */
	private static void enterDeleteRecord(DbManager dbMan) {
		String fullname = null;
		try{
			Scanner delSc = new Scanner(System.in);
			
			System.out.print("Enter fullname: ");
			fullname = delSc.nextLine();
			
			
			dbMan.deleteRecord(fullname);
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}



	/**
	 * @param sc
	 * @param dbMan
	 */
	private static void enterDataForInsert(DbManager dbMan) {
		try{
			Scanner data = new Scanner(System.in);

			System.out.print("Enter the contact's fullname: ");
			Person contact = new Person(data.nextLine());

			System.out.print("Enter the contact's mobile: ");
			contact.setMobile(data.nextLine());

			System.out.print("Enter the contact's phone: ");
			contact.setPhone(data.nextLine());

			System.out.print("Enter the contact's email: ");
			contact.setEmail(data.nextLine());

			System.out.print("Enter the contact's address: ");
			contact.setAddress(data.nextLine());

			System.out.print("Enter the contact's country: ");
			contact.setCountry(data.nextLine());

			System.out.print("Enter the contact's notes: ");
			contact.setNotes(data.nextLine());

			dbMan.insertRecord(contact);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}