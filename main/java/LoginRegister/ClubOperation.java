package LoginRegister;
/*
@author Bridget
 */
public abstract class ClubOperation {

    public enum ClubOperationEnum {
        accessEstablishment,
        openTab,
        serveDrinks,
        rejectEntry,
        enforceRules,
        manageRoles,
        manageOperations,
        manageEmployees,
        reviewDataDashboard,
        accessStage,
        accessGreenRoom
    }

    // Define methods for the operations
    public void accessEstablishment() {
        System.out.println("Accessing establishment.");
    }

    public void openTab() {
        System.out.println("Opening tab.");
    }

    public void serveDrinks() {
        System.out.println("Serving drinks.");
    }

    public void rejectEntry() {
        System.out.println("Rejecting entry.");
    }

    public void enforceRules() {
        System.out.println("Enforcing rules.");
    }

    public void manageRoles() {
        System.out.println("Managing roles.");
    }

    public void manageOperations() {
        System.out.println("Managing operations.");
    }

    public void manageEmployees() {
        System.out.println("Managing employees.");
    }

    public void reviewDataDashboard() {
        System.out.println("Reviewing data dashboard.");
    }

    public void accessStage() {
        System.out.println("Accessing stage.");
    }

    public void accessGreenRoom() {
        System.out.println("Accessing green room.");
    }

    // A method to get the enum value
    public ClubOperationEnum getEnum() {
        return ClubOperationEnum.valueOf(this.toString());
    }
}