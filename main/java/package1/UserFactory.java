/**
 * DiskoTek.UserFactory is where we come to build our UserData and our User objects.
 * buildNewUser takes all the ingredients we need to make a fresh user from the input via CLI or GUI and glues them together it to the registry
 * DiskoTek.buildValidatedUser will soon be legacy code, but for now it holds as a proof of concept the login strategy. The User is not instantiated
 * until after username and password have been confirmed.
 *
 */
package package1;
import java.io.IOException;
public class UserFactory implements FactoryInterface {
    //TODO we need builder methods for each type of user. I will work on this soon, but wanted to get this pushed ASAP so 5crumTeam can do it's thing.


    public static void buildNewUserData(String desiredUsername, String name, String desiredEmail, int age, String passwd) {
        DummyRole[] roles = new DummyRole[]{DummyRole.PATRON};
        UserData uData = new UserData();
        uData.userName = desiredUsername;
        uData.name = name;
        uData.email = desiredEmail;
        uData.roles = roles;
        uData.age = age;
        uData.isAdmin = false;
        uData.password = passwd;
        Registry.addUserToMap(uData); //Adds userData to userMap
        System.out.println("debug UserFactory.buildNewUser --- user registration complete, adding UserData object to map and writing to disk");
        try {
            Registry.WriteJSON(); //Writes userMap to registry file.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //I am leaving it here in case I need future sanity checks. This works at this point.
    public static DummyUser buildValidatedUser(UserData userData) {
        return new PatronUser(userData);
    }

    @Override
    public DummyUser buildPatronUser(UserData uData) {
        return null;
    }


    public static AdminUser buildAdminUser(UserData uData) {
        return new AdminUser(uData);
    }
    public static DummyUser buildUser(UserData user) {
        if (user.isAdmin) {
            return buildAdminUser(user);
        }
        else {
            return buildValidatedUser(user);
        }
    }
}
