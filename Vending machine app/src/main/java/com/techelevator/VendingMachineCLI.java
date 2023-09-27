package com.techelevator;

import com.techelevator.utilities.Item;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {
	private static final String BANNER = "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE_MENU = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "EXIT";

	private	static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Add Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_ITEM = "Select Item";
	private static final String PURCHASE_NEW_OPTION_RETURN_TO_MAIN = "Finish Sale";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE_MENU, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_SELECT_ITEM, PURCHASE_NEW_OPTION_RETURN_TO_MAIN};

	private Logger mainLog = new Logger();
	private Scanner userInput;

	public static void main(String[] args) {
		VendingMachineCLI vendingMachineCLI = new VendingMachineCLI();
		vendingMachineCLI.userInput = new Scanner(System.in);
		vendingMachineCLI.run();
	}
	public void run() {
		CoinBox coinBox = new CoinBox();
		Inventory inventory = new Inventory(coinBox);
		inventory.loader();
		System.out.println(BANNER + "              WELCOME TO UMBRELLACORP VENDING\n" + "              WARNING: POSSIBLE SIDE EFFECTS" + BANNER);

		boolean runMenu = true;
		String[] activeMenu = MAIN_MENU_OPTIONS;

		while(runMenu){
			displayMenuOptions(activeMenu);
			System.out.println("\nPlease make a selection: ");
			String userSelection = userInput.nextLine();
			try{
				Integer userSelectionIndex = Integer.parseInt(userSelection)-1;
				String menuSelection = activeMenu[userSelectionIndex];
				System.out.println("You selected: " + menuSelection);

				switch(menuSelection) {
					case MAIN_MENU_OPTION_DISPLAY_ITEMS:
						System.out.println("WE HAVE A VARIETY OF ITEMS");
						for (Item inventoryItem : inventory.getItemList()) {
							System.out.println(inventoryItem.toString());
						}
						break;
					case MAIN_MENU_OPTION_PURCHASE_MENU:
						System.out.println("Money provided: " + coinBox.getBalance()/100d);
						activeMenu = PURCHASE_MENU_OPTIONS;
						break;
					case MAIN_MENU_OPTION_EXIT:
						double startingBalance = coinBox.getBalance()/100d;
						coinBox.makeChange();
						mainLog.write("GIVE CHANGE: " + startingBalance + " " + coinBox.getBalance()/100d);
						runMenu = false;
						break;
					case PURCHASE_MENU_OPTION_DEPOSIT_MONEY:
						System.out.println("Machine only accepts cash only, no change");
						int depositAmount = Integer.parseInt(userInput.nextLine());
						coinBox.acceptDeposit(depositAmount);
						mainLog.write("FEED MONEY: " + depositAmount + " " + coinBox.getBalance()/100d);
						System.out.println("Successfully deposited money");
						break;
					case PURCHASE_MENU_OPTION_SELECT_ITEM:
						System.out.println("WE HAVE A VARIETY OF ITEMS");
						for (Item inventoryItem : inventory.getItemList()) {
							System.out.println(inventoryItem.toString());
						}
						System.out.println("Please input your item code: ");
						String desiredCode = userInput.nextLine();
						Map<String, List<Item>> mapName = inventory.currentStock;
						if (mapName.containsKey(desiredCode)) {
							inventory.dispense(desiredCode);
							Item inventoryItem = mapName.get(desiredCode).get(0);
							mainLog.write(inventoryItem.getName() + " " + inventoryItem.getBinNumber() + " " + inventoryItem.getPennyPrice()/100d + " " + coinBox.getBalance()/100d);
						} else {
							System.out.println("Please enter a valid selection");
						}
						activeMenu = PURCHASE_MENU_OPTIONS;
						break;
					case PURCHASE_NEW_OPTION_RETURN_TO_MAIN:
						activeMenu = MAIN_MENU_OPTIONS;
						break;
					default:
						System.out.println("INVALID SELECTION");
						break;
				}
			}catch(NumberFormatException nfe){
				System.out.println("Please only enter menu options numbers");
			} catch (Exception e) {
				System.out.println("ERROR INVALID SELECTION: T-VIRUS HAS BEEN RELEASED");
			}
		}
	}
	public void displayMenuOptions(String[] menu){
		System.out.println(BANNER);
		for(int i = 0; i < menu.length; i++){
			System.out.println("(" + (i+1) + ") " + menu[i]);
		}
		System.out.println(BANNER);
	}

//after every 24 hours get total price from reading from log file and write it to the new sales report

}




















