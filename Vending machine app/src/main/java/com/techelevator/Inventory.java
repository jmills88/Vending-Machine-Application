package com.techelevator;

import com.techelevator.utilities.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {
    private static final String INVENTORY_SOURCE_FILE = "vendingmachine.csv";
    private static final int DEFAULT_STOCK = 5;
    private List<Item> itemList = new ArrayList<>();
    private CoinBox coinBox;

    public List<Item> getItemList() {
        return itemList;
    }

    public Map<String, List<Item>> currentStock = new TreeMap<>();
    public Inventory(CoinBox coinBox) {
        this.coinBox = coinBox;
    }
    public Inventory(){

    }
    public void dispense(String binNumber) {
        if (!currentStock.get(binNumber).isEmpty()) {
            Item vendedItem = currentStock.get(binNumber).remove(0);
            if(vendedItem.getPennyPrice() <= coinBox.getBalance()){
                coinBox.withdraw(vendedItem.getPennyPrice());
                System.out.println("Here is your item: " + vendedItem.getName() + " from " + vendedItem.getBinNumber() + " remaining balance: " + coinBox.getBalance()/100d);
                vendedItem.use();
            } else {
                System.out.println("Please input more bills");
            }
        }else{
            System.out.println("Sold Out");
        }
    }
    public void loader() {
        File logFile = new File(INVENTORY_SOURCE_FILE);
        try (Scanner scanner = new Scanner(logFile)) {
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                String[] itemProperties = currentLine.split("\\|");
                for (int i = 0; i < itemProperties.length; i++) {
                    itemProperties[i] = itemProperties[i].trim();
                }
                Item newItem = itemFactory(itemProperties);
                itemList.add(newItem);
                List<Item> stockingList = new ArrayList<>();
                for (int i = 0; i < DEFAULT_STOCK; i++) {
                    stockingList.add(newItem);
                }
                currentStock.put(newItem.getBinNumber(), stockingList);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found: T-Virus detected");
        }catch (Exception ex){
            System.out.println("SYSTEM ERROR: T-VIRUS HAS BEEN RELEASED");
        }
    }
    public Item itemFactory(String[] itemProperties) {
        Item result = null;
            String binNumber = itemProperties[0];
            String name = itemProperties[1];
            int pennyPrice = (int) (Double.parseDouble(itemProperties[2]) * 100);
            String type = itemProperties[3];
            switch (type.toLowerCase()) {

                case "candy":
                    result = new Candy(name, type, pennyPrice, binNumber);
                    break;
                case "chip":
                    result = new Chip(name, type, pennyPrice, binNumber);
                    break;
                case "drink":
                    result = new Drink(name, type, pennyPrice, binNumber);
                    break;
                case "gum":
                    result = new Gum(name, type, pennyPrice, binNumber);
                    break;
                default:
                    break;
            }
           return result;
    }
}


