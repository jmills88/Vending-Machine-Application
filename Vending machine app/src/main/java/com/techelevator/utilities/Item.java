package com.techelevator.utilities;

public abstract class Item {
    private final String name;
    private final String type;
    private final int pennyPrice;
    private final String binNumber;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPennyPrice() {
        return pennyPrice;
    }
    public String getBinNumber() {
        return binNumber;
    }
    public Item(String name, String type, int pennyPrice, String binNumber) {
        this.name = name;
        this.type = type;
        this.pennyPrice = pennyPrice;
        this.binNumber = binNumber;
    }
    public abstract void use();

    public String toString() {
        return String.format("[%1$2s] %2$-20s$%3$6.2f  ", binNumber, name, pennyPrice / 100d);
    }
}
