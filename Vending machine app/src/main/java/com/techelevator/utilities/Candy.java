package com.techelevator.utilities;

public class Candy extends Item{
    public Candy(String name, String type, int pennyPrice, String binNumber) {
        super(name, type, pennyPrice, binNumber);
    }
    @Override
    public void use(){
        System.out.println("Munch Munch, Yum!");
    }
}
