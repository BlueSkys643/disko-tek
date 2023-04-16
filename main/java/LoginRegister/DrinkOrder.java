/**
 * Represents a drink order in the system, with information about the drink and the user who placed the order.
 * This class implements the DrinkOrderSubject interface to allow for observers to be notified of updates to the order.
 *
 *
 * @author Ricky G
 * (PairProgrammed)
 *@uthor Jeff
*/

package LoginRegister;

/**
 * Represents a drink order in the system, with information about the drink and the user who placed the order.
 * This class implements the DrinkOrderSubject interface to allow for observers to be notified of updates to the order.
 */

public class DrinkOrder implements DrinkOrderSubject {
    private String drinkName;

    public DummyUser getUser() {
        return user;
    }

    private DummyUser user;

    public DrinkOrder(String drinkName, User user) {
        this.drinkName = drinkName;
        this.user = (DummyUser) user;
    }
    /**
     * Returns the name of the drink associated with this order.
     */
    public String getName() {
        return drinkName;
    }
    /**
     * Registers an observer to receive updates about the order.
     */
    @Override
    public void register() {

    }
    /**
     * Unregisters an observer so it no longer receives updates about the order.
     */
    @Override
    public void unregister() {

    }
    /**
     * Notifies all registered observers that the order has been updated.
     */
    @Override
    public void notifyObservers() {

    }
    /**
     * Returns the latest update to the order.
     */
    @Override
    public void getUpdate() {

    }

    // Add getters and setters for drinkName and user, if needed
}

