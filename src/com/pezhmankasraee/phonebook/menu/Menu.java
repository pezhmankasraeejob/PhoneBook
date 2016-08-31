/**
 * 
 */
package com.pezhmankasraee.phonebook.menu;

import java.util.Scanner;

/**
 * @author pezhman
 *
 */
public final class Menu {
	/**
	 * 
	 */
	private static void showMenuStructure() {
		System.out.println();

		System.out.println("1. Show all records.");
		System.out.println("2. Insert a new contact.");
		System.out.println("3. Delete a contact.");
		System.out.println("4. Update a contact.");
		System.out.println("5. Find a contact.");
		System.out.println("0. Exit");
		System.out.println("---------------------------------");
		System.out.print("Select an item in the list above: ");
	}


	public static String startMenu(){

		String item = "0";

		boolean flag = true;

		try{
			do{
				Scanner menuSc = new Scanner(System.in);

				showMenuStructure();

				item = menuSc.nextLine();
				if (item.equals("1") || item.equals("2")
						|| item.equals("3") || item.equals("4") || 
						item.equals("5") || item.equals("0"))
					flag = false;
				else{
					System.out.println("The only selections are between 0 and 5.");
					System.out.println("Try again!");
					flag = true;
				}

			}while(flag);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return item;
	}
}
