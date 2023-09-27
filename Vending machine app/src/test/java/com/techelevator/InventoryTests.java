package com.techelevator;

import com.techelevator.utilities.Candy;
import com.techelevator.utilities.Item;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTests {
@Test
    public void test_itemFactory_inputString_returnSameStringProperties(){
    //assign
    Inventory test = new Inventory();
    Item expected = new Candy("WonkaBar", "Candy", 250, "A1");
    String[] testString = {"A1", "WonkaBar", "2.50", "Candy"};


    //act
    Item result = test.itemFactory(testString);




    //assert
    Assert.assertEquals(expected.getName(), result.getName());
    Assert.assertEquals(expected.getBinNumber(), result.getBinNumber());
    Assert.assertEquals(expected.getType(), result.getType());
    Assert.assertEquals(expected.getPennyPrice(), result.getPennyPrice());
}
    @Test
    public void test_itemFactory_inputString_returnNull(){
        //assign
        Inventory test = new Inventory();
        Item expected = null;
        String[] testString = {"A2", "WonkaBar", "2.50"};


        //act
        Item result = test.itemFactory(testString);




        //assert
        Assert.assertEquals(expected, result.getName());
        Assert.assertEquals(expected, result.getBinNumber());
        Assert.assertEquals(expected, result.getType());
        Assert.assertEquals(expected, result.getPennyPrice());
    }
}


