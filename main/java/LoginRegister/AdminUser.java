package LoginRegister;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminUser extends DummyUser {
    static Map<String, ItemData> dMap = new HashMap<>();
    private Scanner scanny = new Scanner(System.in);
    private boolean loggedIn = true;

    public AdminUser(UserData userData) {
        super(userData);
    }

    @Override
    public void userExperience() {
        while (this.loggedIn) {
            System.out.println("Welcome Admin User " + this.getName() + " 1 register your establishment, 2 exit");
            String answer = scanny.nextLine();
            if (answer == "1") {
                clubRegistryTestInput();
            } else if (answer == "2") {
                System.out.println("Goodbye");
                this.loggedIn = false;
                System.exit(0);
            }
        }
    }

    private void clubRegistryTestInput() {
        boolean finished = false;
        //TestClub(String clubName, TestMenu itemMenu, ItemFactory itemFactory, Map<String, UserData> employees, UserData testAdminUser)
        System.out.println("Welcome to the DiskoTek Club Registration Process. /n Enter your desired business name");
        String clubName = scanny.nextLine();
        System.out.println("At this point, we will need some mechanism to verify they own the business, not sure how that works");
        System.out.println("But we can build the menu etc");
        System.out.println("Your verification code is: asdfjkl;");

    }

    @Override
    public void loggedIn() throws IOException {
        this.loggedIn = true;
        System.out.println("Welcome admin user " + getUsername());
//        Map<String, UserData> clubEmployeData = new HashMap<>();

        TestClub testClub = new TestClub();
        testClub.adminPortal(this);
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public void addEmployeeRoles() {

    }
}
