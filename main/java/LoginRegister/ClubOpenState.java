package LoginRegister;
/*
@author Bridget
 */
public class ClubOpenState extends ClubOperation {
    // Class representing the state of the club when it is open

    // Inherited methods from ClubOperation
    @Override
    public void accessEstablishment() {
        System.out.println("Accessing establishment.");
    }

    @Override
    public void openTab() {
        System.out.println("Opening tab.");
    }

    @Override
    public void serveDrinks() {
        System.out.println("Serving drinks.");
    }

    @Override
    public void rejectEntry() {
        System.out.println("Entry rejected.");
    }

    @Override
    public void enforceRules() {
        System.out.println("Enforcing rules.");
    }

    @Override
    public void manageRoles() {
        System.out.println("Managing roles.");
    }

    @Override
    public void manageOperations() {
        System.out.println("Managing operations.");
    }

    @Override
    public void manageEmployees() {
        System.out.println("Managing employees.");
    }

    @Override
    public void reviewDataDashboard() {
        System.out.println("Reviewing data dashboard.");
    }

    @Override
    public void accessStage() {
        System.out.println("Accessing stage.");
    }

    @Override
    public void accessGreenRoom() {
        System.out.println("Accessing green room.");
    }
}
