/**
 *This Class is a Singleton that represents a queue of drink order, it implements the DrinkOrderObserver,
 * and DrinkOrderSubject interfaces.
 *Observers can be added to the DrinkOrderQueue to receive updates when new orders are added to the queue.
 *
 * @author Ricky G
 * (PairProgrammed)
 *@author Jeff
 */

package LoginRegister;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DrinkOrderQueue implements DrinkOrderObserver, DrinkOrderSubject {
    // Singleton instance of DrinkOrderQueue
    private static DrinkOrderQueue instance;

    // Queue to hold drink orders
    private final Queue<DrinkOrder> orderQueue;

    // List to hold observers
    private final List<DrinkOrderObserver> observers;

    // Private constructor to prevent instantiation from outside
    private DrinkOrderQueue() {
        orderQueue = new LinkedList<>();
        observers = new ArrayList<>();
    }

    // Get the singleton instance of DrinkOrderQueue
    public static synchronized DrinkOrderQueue getInstance() {
        if (instance == null) {
            instance = new DrinkOrderQueue();
        }
        return instance;
    }

    // Add an observer to the list of observers
    public void addObserver(DrinkOrderObserver observer) {
        observers.add(observer);
    }

    // Remove an observer from the list of observers
    public void removeObserver(DrinkOrderObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers when a new order is added
    private void notifyObservers(DrinkOrder order) {
        for (DrinkOrderObserver observer : observers) {
            observer.update(order);
        }
    }

    // Add a new order to the queue and notify observers
    public void addOrder(DrinkOrder order) {
        orderQueue.add(order);
        notifyObservers(order);
    }

    // Get the next order from the queue
    public DrinkOrder getNextOrder() {
        return orderQueue.poll();
    }

    @Override
    public void update(DrinkOrder order) {

    }

    @Override
    public void setSubject(DrinkOrderSubject order) {

    }

    @Override
    public void register() {

    }

    @Override
    public void unregister() {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void getUpdate() {

    }
}
