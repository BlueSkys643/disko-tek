package LoginRegister;

import java.util.Map;

public class TestMenu {
    static Map<String, ItemData> itemMap;

    public TestMenu(Map<String, ItemData> iMap) {
        this.itemMap = iMap;
    }
    public static ItemData getItemData(String itemName) {
        return itemMap.get(itemName);
    }

    protected void addToMenu(ItemData itemData) {
        System.out.println("Adding item to menu: "+ itemData.toString());
        this.itemMap.put(itemData.name, itemData);
    }

}
