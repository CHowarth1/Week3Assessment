import java.util.List;
import java.util.Scanner;

import controller.ShipListHelper;
import model.ShipList;

/**
 * @author Christopher Howarth - chowarth1
 * CIS175 - Fall 2021
 * Feb 12, 2023
 */
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static ShipListHelper slh = new ShipListHelper();
	
	private static void addAShip() {
		System.out.print("Enter a ship name: ");
		String shipName = in.nextLine();
		System.out.print("Enter a ship model: ");
		String shipModel = in.nextLine();
		System.out.print("Enter a ship pilot: ");
		String pilot = in.nextLine();
		
		ShipList toAdd = new ShipList(shipName, shipModel, pilot);
		slh.insertShip(toAdd);
		
	}
	
	private static void deleteAShip() {
		System.out.print("Enter the ship to delete: ");
		String shipName = in.nextLine();
		System.out.print("Enter the ship model to delete: ");
		String shipModel = in.nextLine();
		System.out.print("Enter the pilot to delete: ");
		String pilot = in.nextLine();
		
		ShipList toDelete = new ShipList(shipName, shipModel, pilot);
		slh.deleteShip(toDelete);
		
	}
	
	private static void editAShip() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Ship Name");
		System.out.println("2 : Search by Ship Model");
		System.out.println("3 : Search by Pilot");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ShipList> foundShips;
		if (searchBy == 1) {
			System.out.print("Enter the Ship name: ");
			String shipName = in.nextLine();
			foundShips = slh.searchForShipByShipName(shipName);
			
		} else if (searchBy == 2){
			System.out.print("Enter the Ship model: ");
			String shipModel = in.nextLine();
			foundShips = slh.searchForShipByShipModel(shipModel);
			
		} else {
			System.out.print("Enter the Pilot name: ");
			String pilot = in.nextLine();
			foundShips = slh.searchForShipByPilot(pilot);
		}
		
		if (!foundShips.isEmpty()) {
			System.out.println("Found Results.");
			for (ShipList l : foundShips) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			
			ShipList toEdit = slh.searchForShipById(idToEdit);
			System.out.println("retrieved " + toEdit.getShipName());
			System.out.println("1 : Update Ship Name");
			System.out.println("2 : Update Ship Model");
			System.out.println("3 : Update Ship Pilot");
			int update = in.nextInt();
			in.nextLine();
			
			if (update == 1) {
				System.out.print("New Ship Name: ");
				String newShipName = in.nextLine();
				toEdit.setStarshipName(newShipName);
			} else if (update == 2) {
				System.out.print("New Ship Model: ");
				String newShipModel = in.nextLine();
				toEdit.setShipModel(newShipModel);
			} else {
				System.out.print("New Ship Pilot: ");
				String newShipPilot = in.nextLine();
				toEdit.setPilot(newShipPilot);
			}
			
			slh.updateShip(toEdit);
			
		} else {
			System.out.println("---- No results found");
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the Axion ship tracking system! ---");
		while (goAgain) {
			System.out.println("* Select an item:");
			System.out.println("* 1 -- Add a Star Ship");
			System.out.println("* 2 -- Edit a Star Ship");
			System.out.println("* 3 -- Delete a Star Ship");
			System.out.println("* 4 -- View list of Star Ships");
			System.out.println("* 5 -- Exit the tracking program");
			System.out.println("* Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			
			if (selection == 1) {
				addAShip();
			} else if (selection == 2) {
				editAShip();
			} else if (selection == 3) {
				deleteAShip();
			} else if (selection == 4) {
				viewTheShips();
			} else {
				slh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewTheShips() {
		// TODO Auto-generated method stub
		List<ShipList> allShips = slh.showAllShips();
		for(ShipList singleItem : allShips) {
			System.out.println(singleItem.returnShipDetails());
		}

	}

}
