//utility class to serve as a makeshift registration process and handle IO. Much of this will be replaced come GUI time, but there are a few
//that will retain their usefulness.
package LoginRegister;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;


public class Registry {

    //ugly string declaration The io and runtime exceptions follow around this method.
    static String json;
    static {
        try {
            json = ReadMasterRegistryJSON();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static ObjectMapper mapper = new ObjectMapper();
    static Map<String, UserData> userMap;

    static {
        try {
            userMap = mapper.readValue(json, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    //static Map<String, UserData> uMap = Registry.userMap;
    static Scanner scanner = new Scanner(System.in);

    //the ugliest String initialization. The ioexception follows the ReadMasterRegistryJSON() method around anywhere it is used.

    //getter for the userMap.
    public static Map<String, UserData> getUserMap() throws IOException {
        return userMap;
    }
    //Writes JSON to file. This needs to be done any time there is a new registration.
    public static void WriteJSON() throws IOException {

        new PrintWriter("main/Resources/MasterRegistry.json").close();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userMap);
        Files.write(new File("main/Resources/MasterRegistry.json").toPath(), Collections.singletonList(json), APPEND);
    }
    //Reads in string of JSON and writes it to a
    public static String ReadMasterRegistryJSON() throws IOException {
        Path fileName = Path.of("main/Resources/MasterRegistry.json");
        return Files.readString(fileName);
    }
    //This takes the userData.username and the accompanying data for that object and adds it to the userData map.
    protected static void addUserToMap(UserData uData) {
        userMap.put(uData.userName, uData);
    }
    //this method just runs gathers data to facilitate the registration process. It will be made obsolete when the factory is finished
    //because it will be designed to take input from the GUI.
    public static void registerUser() {
        System.out.println("Welcome to the DiskoTek Beta Registration");
        System.out.println("Enter desired username");
        String desiredUsername = scanner.nextLine();
        if (desiredUsername.isBlank()) {
            System.out.println("Username can't be blank, please try again");
            registerUser();
        }
        System.out.println("Enter desired email");
        String desiredEmail = scanner.nextLine();
        //TODO add email format verification
        if (desiredEmail.isBlank()) {
            System.out.println("Email can't be blank, please try again");
            registerUser();
        }
        if (uniqueUserChecker(desiredUsername))  {
            System.out.println("Username already exists in our system. Please try again, login, or reset password.");
            registerUser();
        }
        if (uniqueUserEmailChecker(desiredEmail)) {
            System.out.println("Email and username set.");
        }
        System.out.println("enter your name");
        String name = scanner.nextLine();
        System.out.println("enter your age");
        int age = Integer.parseInt(scanner.nextLine());
        String passwd = setNewUserPassword(desiredUsername);
        UserFactory.buildNewUserData(desiredUsername, name, desiredEmail, age, passwd); //String username, String name, String email, int age, String password
    }
    //This will need refactored when we start building GUI anyway so I am not concerned with it at the moment.
    private static String setNewUserPassword(String uName) {
        System.out.println("Enter your password:");
        String password1 = scanner.nextLine();
        System.out.println("Confirm password: ");
        String password2 = scanner.nextLine();
        if (password1.isEmpty() || password2.isEmpty()) {
            System.out.println("Passwords cannot be blank.");
            setNewUserPassword(uName);
        }
        if (verifyPassword(password2,password1)) {
            System.out.println("Passwords verified");
            return password1;
        } else {
            System.out.println("Passwords do not match, please try again.");
            setNewUserPassword(uName);
        }
        return password2;
    }
    //takes two strings, returns boolean value
    private static boolean verifyPassword(String p1, String p2) {
        return Objects.equals(p1, p2);
    }
    //looks in the UserData object Map for a userData object that has the key value of the username.
    //these should probably be .toLowerCase() some point in the future.
    public static boolean uniqueUserChecker(String n) {
        if (!userMap.containsKey(n)) {
            return false;
        } else {
            return true;
        }
    }
    //This takes a string and checks in the UserData object map for a key that has a userData.email value the same as the string.
    //Returns boolean value. These should also probably be .toLowerCase() also
    public static boolean uniqueUserEmailChecker(String e) {
        for (UserData uData : userMap.values()) {
            if (Objects.equals(uData.email, e)) {
                return true;
            }
        } return false;
    }
    public static void writeToClubDB(TestClub club) throws IOException {
        new PrintWriter("clubDB").close();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(club);
        Files.write(new File("clubDB.json").toPath(), Collections.singletonList(json), APPEND);
    }
    public static String readFromClubDB() throws IOException {
        Path fileName = Path.of("clubDB");
        return Files.readString(fileName);
    }
}