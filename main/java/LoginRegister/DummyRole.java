package LoginRegister;

//enum for the list of roles implements the Role interface
public enum DummyRole implements Role {
    //named constants defined with the roleName and the associated ClubOperations
    PATRON("patron", new ClubOperation[]{
            ClubOperation.accessEstablishment,
            ClubOperation.openTab}),
    BARTENDER("bartender", new ClubOperation[]{
            ClubOperation.serveDrinks,
            ClubOperation.rejectEntry,
            ClubOperation.accessEstablishment,
            ClubOperation.openTab}),
    TALENT("talent", new ClubOperation[]{
            ClubOperation.accessStage,
            ClubOperation.accessGreenRoom,
            ClubOperation.accessEstablishment,
            ClubOperation.openTab}),
    SECURITY("security", new ClubOperation[]{
            ClubOperation.enforceRules,
            ClubOperation.rejectEntry,
            ClubOperation.accessEstablishment,
            ClubOperation.openTab}),
    ADMINISTRATOR("administrator", new ClubOperation[]{
            ClubOperation.manageRoles,
            ClubOperation.manageOperations,
            ClubOperation.accessEstablishment,
            ClubOperation.openTab}),
    MANAGER("manager", new ClubOperation[]{
            ClubOperation.manageEmployees,
            ClubOperation.reviewDataDashboard,
            ClubOperation.accessEstablishment,
            ClubOperation.openTab});

    //Fields that hold the roleName and the ClubOperations
    private final String roleName;
    private final ClubOperation[] operations;


    //Constructor to initialize the roleName and operations variables
    DummyRole(String roleName, ClubOperation[] operations) {
        this.roleName = roleName;
        this.operations = operations;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public ClubOperation[] getOperations() {
        return operations;
    }
}
