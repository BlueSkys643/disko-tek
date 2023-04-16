package LoginRegister;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemFactory {
    public static ItemData buildItem(String itemName, String description, ArrayList[] parameters, float price, ItemData.ItemType type) {
        switch (type) {
            case FOOD:
                ItemData itemData = buildFoodItem(itemName, description, parameters, price);
                return itemData;
            case DRINKS:
                itemData = buildNewDrink(itemName, description, parameters, price);
                return itemData;
        } return null;
    }
    public static ItemData buildNewDrink(String itemName, String description, ArrayList[] parameters, float price) {
        ItemData itemData = new ItemData(itemName, description, new String[] {Arrays.toString(parameters)}, price, ItemData.ItemType.DRINKS);
        return itemData;
    }
    //TODO drinks first, food later am I right =)
    private static ItemData buildFoodItem(String itemName, String description, ArrayList[] parameters, float price) {
        ItemData itemData = new ItemData(itemName, description, new String[] {Arrays.toString(parameters)}, price, ItemData.ItemType.FOOD);
        return itemData;
    }
}


