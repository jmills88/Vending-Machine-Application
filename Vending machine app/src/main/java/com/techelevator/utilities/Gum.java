package com.techelevator.utilities;

public class Gum extends Item{
    public Gum(String name, String type, int pennyPrice, String binNumber) {
        super(name, type, pennyPrice, binNumber);
    }
    @Override
    public void use(){
        System.out.println("Chew Chew, Yum!");
    }
}
