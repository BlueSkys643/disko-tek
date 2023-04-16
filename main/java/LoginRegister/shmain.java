/**
 *
 *@author Jeff AKA "The Wizard"
 */

package LoginRegister;

public class shmain {
    public static void main(String[] args) {
        Registry.readMenuJSON();
        System.out.println(Registry.menuMap.get("Club5crum").get("beer").name);
        TestMenu tm = new TestMenu(Registry.menuMap.get("Club5crum"));
        System.out.println(tm.itemMap.get("beer").getName());
        Bartender ricky = new Bartender(Registry.userMap.get("sky"));
        PatronUser jeff = new PatronUser(Registry.userMap.get("sky"));
        ricky.prepareDrink(tm.itemMap.get("beer"), jeff);

//        ItemData idata = new ItemData("beer", "delicious beer", new String[]{"big ass beer", "with ice", "other params"}, 6.25F, ItemData.ItemType.DRINKS);
//        ItemData idata2 = new ItemData("whiskey", "gut rotting whiskey", new String[]{"on the rocks", "straight", "double"}, 5.50F, ItemData.ItemType.DRINKS);
//        Map<String, ItemData> menuItems= new HashMap<>();
//        menuItems.put(idata.getName(), idata);
//        menuItems.put(idata2.getName(),idata2);
//        TestMenu testMenu = new TestMenu(menuItems);
//        Registry.writeToMenus(testMenu.itemMap, "testClub");
//        ItemData idata3 = new ItemData("beer", "delicious beer", new String[]{"big ass beer", "with ice", "other params"}, 6.25F, ItemData.ItemType.DRINKS);
//        ItemData idata4 = new ItemData("whiskey", "gut rotting whiskey", new String[]{"on the rocks", "straight", "double"}, 5.50F, ItemData.ItemType.DRINKS);
//        Map<String, ItemData> menuItems2= new HashMap<>();
//        menuItems2.put(idata.getName(), idata3);
//        menuItems2.put(idata2.getName(),idata4);
//        TestMenu testMenu2 = new TestMenu(menuItems2);
//        Registry.writeToMenus(testMenu2.itemMap, "The Oasis");
        //FirstSprintDemo.demo();
    }
}
