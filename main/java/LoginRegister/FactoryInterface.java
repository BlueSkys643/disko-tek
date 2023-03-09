package LoginRegister;

/**
 *Interface for Factory.
 */

public interface FactoryInterface {
    static void buildUser(String desiredUsername, String name, String desiredEmail, int age, String passwd){}
    DummyUser buildPatronUser(UserData uData);

}