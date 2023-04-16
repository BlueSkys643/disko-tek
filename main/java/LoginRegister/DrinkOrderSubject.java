/**
 *
 * @author Ricky G
 * (PairProgrammed)
 *@author Jeff
 */

package LoginRegister;
/**
 * Interface for subjects being observed by DrinkOrderObservers.
 */
public interface DrinkOrderSubject {
    /**
     * Registers a new observer to observe this subject.
     */
    void register();
    /**
     * Unregisters an observer from observing this subject.
     */
    void unregister();
    /**
     * Notifies all registered observers that the subject has been updated.
     */
    void notifyObservers();
    /**
     * Gets the latest update from the subject for the observer.
     */
    void getUpdate();
}
