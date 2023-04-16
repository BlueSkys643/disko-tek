package LoginRegister;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Scanner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clubName",
        "adminUser",
        "employees",
        "menu"
})
public class TestClub {
    ItemFactory itemFactory;
    Scanner scanny  = new Scanner(System.in);
    private String clubName;
    private String adminUser;
    private List<Object> employees;
    private TestMenu menu;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public List<Object> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Object> employees) {
        this.employees = employees;
    }

    public TestMenu getMenu() {
        return menu;
    }

    public void setMenu(TestMenu menu) {
        this.menu = menu;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public void addMenuItemTestInput() {
        ArrayList<String> params = new ArrayList<>();
        System.out.println("Enter name of item");
        String itemName = scanny.nextLine();
        System.out.println("Add a description of " + itemName);
        String itemDescription = scanny.nextLine();
        System.out.println("Enter price of item");
        float itemPrice = Float.parseFloat(scanny.nextLine());
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
            addItemToMenu(itemName, itemData);
        } else if (answer == "2") {
            this.itemFactory.buildItem(itemName, itemDescription, new ArrayList[]{params}, itemPrice, ItemData.ItemType.FOOD);
        }
    }
    public void serveDrink(String drink) {
        System.out.println("Enjoy your " + drink + " keep the change ya filthy animal");
    }
    public void addItemToMenu(String item, ItemData itemData) {
        menu.itemMap.put(item, itemData);
        System.out.println("dbug TestClub.addItemToMenu >> testing IO");
        Registry.writeToMenus(menu.itemMap, clubName);
    }
    public ItemData getItem(String itemName) {
        return menu.getItemData(itemName);
    }
    public void adminPortal(AdminUser adminUser) throws IOException {
        this.itemFactory = new ItemFactory();
        Map<String, ItemData> menuData = new HashMap();
        TestMenu testMenu = new TestMenu(menuData);
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
            this.employees.add(testEmployee1.name);
        }
    }
}

