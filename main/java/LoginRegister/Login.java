package LoginRegister;
/*
RBAC Design Pattern linking the RegSimUserData to Roles and Operations hard-coded users
&& account login auth
 */

import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    public static User loginFromGUI(String uname, String pass) {
        Map users = Registry.userMap;
        UserData userData = (UserData) users.get(uname);
        DummyUser user = testAuthenticate(userData, pass);
        return user;
    }
    public static void login(Map umap) {
        //Scanner initialized
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine(); //saves what's entered to username String variable
        System.out.print("Enter your password: ");
        String password = sc.nextLine(); //saves what's entered to String password variable
        //DummyUser array holding all the hard-coded users at this point, with roles assigned, and passwords

        try {
            //check if username or password is empty
            if (username.isEmpty() || password.isEmpty()) {
                //if either is empty, print message
                System.out.println("Username and password cannot be empty");
                return;
            }
            //try to authenticate the user with the given username and password
            UserData userData = (UserData) umap.get(username);
            DummyUser user = testAuthenticate(userData, password);
            //check if authentication was successful
            if (user != null) {
                //if it was successful, call the method to print the user's role
                printUserRole(user);
                try {
                    user.loggedIn();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                //if authentication failed, print error messages
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No input found, please try again.");
        }
    }
    //Added test auth method, the other one should work now as well, but leaving this one in place. These shouldn't need
    //to change much.
    private static DummyUser testAuthenticate(UserData user, String passwordInput) {
        //this validates the password based on userdata objects stored and calls the userfactory to
        if (Objects.equals(user.password, passwordInput)) {
            DummyUser validatedUser = UserFactory.buildUser(user);
            return validatedUser;
        } else {
            System.out.println("Username or password is incorrect");
            return null;
        }
    }

    //Method to print the usernames, roles and operations associated with those roles or each user
    private static void printUserRole(DummyUser user) {
        System.out.println("RegSimUserData: " + user.getUsername()); //print the username
        for (DummyRole role : user.getRoles()) { //loop through all the roles of that user
            System.out.println("\t\tRole: " + role.getRoleName()); //print the role name
            for (ClubOperation operation : role.getOperations()) {  //loop through the operations associated with each role
                System.out.println("\t\t\tOperation: " + operation.name()); //print the operation name
            }
        }
    }
    //added entry point for demonstration purposes

}

