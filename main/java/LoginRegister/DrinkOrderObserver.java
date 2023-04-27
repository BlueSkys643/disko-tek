/**
 * This interface defines the methods that must be implemented by any class,
 * that wishes to observe changes to a DrinkOrderQueue object.
 *
 * @author Ricky G
 * (PairProgrammed)
 *@uthor Jeff
 */


package LoginRegister;

/**
 * Interface for observers of the DrinkOrderQueue
 */
public interface DrinkOrderObserver {
    /**
     * This method is called when a new DrinkOrder object is added to the queue being observed.
     */
    void update(DrinkOrder order);
    /**
     * This method is used to set the DrinkOrderSubject object that this observer will be observing.
     */
    void setSubject(DrinkOrderSubject order);
}
