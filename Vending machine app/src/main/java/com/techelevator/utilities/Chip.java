package com.techelevator.utilities;

public class Chip extends Item{
    public Chip(String name, String type, int pennyPrice, String binNumber) {
        super(name, type, pennyPrice, binNumber);
    }
    @Override
    public void use(){
        System.out.println("Crunch Crunch, Yum!");
    }
}
