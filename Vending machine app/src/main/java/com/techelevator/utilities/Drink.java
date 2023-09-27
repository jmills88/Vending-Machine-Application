package com.techelevator.utilities;

public class Drink extends Item{
    public Drink(String name, String type, int pennyPrice, String binNumber) {
        super(name, type, pennyPrice, binNumber);
    }
    @Override
    public void use(){
        System.out.println("Glug Glug, Yum!");
    }
}
