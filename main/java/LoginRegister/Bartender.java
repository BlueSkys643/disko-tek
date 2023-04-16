/**
 *
 * @author Ricky G
 * (PairProgrammed)
 * @uthor Jeff
 * */


package LoginRegister;

import java.io.IOException;
import java.util.Arrays;

public class Bartender extends DummyUser implements DrinkOrderObserver, DrinkOrderSubject {

    /**
     * Bartender constructor, initializes a bartender user with the provided userData.
     *
     */
    public Bartender(UserData userData) {
        super(userData);
        userData.roles = new DummyRole[]{DummyRole.BARTENDER};
    }

    // Get instance method
//    public static synchronized Bartender getInstance(UserData userData) {
//        if (instance == null) {
//            instance = new Bartender(userData);
//        }
//        return instance;
//    }

    /**
     * Provides a user experience for the bartender user.
     */
    @Override
    public void userExperience() {

    }

    // Delegate User methods to dummyUser
//    public String getUsername() {
//        return dummyUser.getUsername().toString();
//    }

    /**
     * Called when the bartender user logs in.
     *
     * @throws IOException If an input/output error occurs during the login process.
     */
    @Override
    public void loggedIn() throws IOException {

    }

    /**
     * Prepares a drink for a user.
     *
     * @param itemData The data of the drink item to be prepared.
     * @param user     The user who ordered the drink.
     */
    public void prepareDrink(ItemData itemData, DummyUser user) {
        System.out.println("Bartender is preparing the drink: " + itemData.getName());
        // Simulate preparing the drink (e.g., by waiting for some time)
        // ...
        System.out.println("Drink is ready for user: " + user.getUsername());
    }

    /**
     * Update method for the Observer pattern, called when a drink order is updated.
     *
     * @param order The updated drink order.
     */
    @Override
    public void update(DrinkOrder order) {
        // Process the drink order, for example, by preparing the drink
        String[] desc = new String[]{"asdf","asdf"};
        ItemData id = new ItemData("beer", "beer!!!!!", new String[] {Arrays.toString(desc)}, 4.50f, ItemData.ItemType.DRINKS);
        prepareDrink(id, order.getUser());
    }

    /**
     * Sets the subject for the Observer pattern.
     *
     * @param order The DrinkOrderSubject instance to set as the subject.
     */
    @Override
    public void setSubject(DrinkOrderSubject order) {

    }
    /**
     * Registers a new observer.
     */
    @Override
    public void register() {

    }
    /**
     * Unregisters an observer.
     */
    @Override
    public void unregister() {

    }
    /**
     * Notifies all registered observers of an update.
     */
    @Override
    public void notifyObservers() {

    }
    /**
     * Gets an update from the subject.
     */
    @Override
    public void getUpdate() {

    }
}
