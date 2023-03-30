package LoginRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class TestClub {
    private Map<String, UserData> employees;
    Scanner scanny = new Scanner(System.in);
    AdminUser adminUser;

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    String clubName;
    TestMenu testMenu;
    ItemFactory itemFactory;
    public TestClub(String clubName, TestMenu itemMenu, ItemFactory itemFactory, Map<String, UserData> employees, AdminUser testAdminUser) {
        this.adminUser = testAdminUser;
        this.clubName = clubName;
        this.testMenu = itemMenu;
        this.itemFactory = itemFactory;
        this.employees = employees;
    }
    public void addMenuItemTestInput() {
        ArrayList<String> params = new ArrayList<>();
        System.out.println("Enter name of item");
        String itemName = scanny.nextLine();
        System.out.println("Add a description of " + itemName);
        String itemDescription = scanny.nextLine();
        System.out.println("Enter price of item");
        Float itemPrice =Float.parseFloat(scanny.nextLine());
        System.out.println("Enter extra item paramaters one by one (enter done when finished)");
        boolean done = false;
        String input = "";
        while (!done) {
            System.out.print("Parameter:");
            input = scanny.nextLine();
            if (Objects.equals(input, "done"))
                done = true;
            params.add(input);
        }
        System.out.println("Is this a 1 Drink, or 2 Food item");
        String answer = scanny.nextLine();
        if (answer == "1") {
            ItemData itemData = this.itemFactory.buildItem(itemName, itemDescription, new ArrayList[]{params}, itemPrice, ItemData.ItemType.DRINKS);
            this.testMenu.addToMenu(itemData);
        } else if (answer == "2") {
            this.itemFactory.buildItem(itemName, itemDescription, new ArrayList[]{params}, itemPrice, ItemData.ItemType.FOOD);
        }
    }
    public void serveDrink(String drink) {
        System.out.println("Enjoy your " + drink + " keep the change ya filthy animal");
    }
    public void addItemToMenu(String item, ItemData itemData) {
        testMenu.itemMap.put(item, itemData);

    }
    public ItemData getItem(String itemName) {
        return testMenu.getItemData(itemName);
    }
    public void adminPortal(AdminUser adminUser) throws IOException {
        System.out.println("What would you like to do? Set Club Name 0, Add menu item 1, add employees 2 or 3 save changes to database or 4 exit");
        String answer = scanny.nextLine();
        if (Objects.equals(answer, "0")) {
            String newClubName = scanny.nextLine();
            this.setClubName(newClubName);
        }
        if (Objects.equals(answer, "1")) {
            addMenuItemTestInput();
        }
        if (Objects.equals(answer, "2")) {
            addEmployees();

        }
        if (Objects.equals(answer, "4")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        if (Objects.equals(answer, "3")) {
            Registry.writeToClubDB(this);
        }
        else {
            adminPortal(adminUser);
        }
    }

    private void addEmployees() throws IOException {

        System.out.println("enter user name of employee to add");
        String answer = scanny.nextLine();
        UserData testEmployee1 = Registry.getUserMap().get(answer);
        if (Objects.equals(answer, "yes")) {
            this.employees.put(testEmployee1.userName, testEmployee1);
        }
    }
}

