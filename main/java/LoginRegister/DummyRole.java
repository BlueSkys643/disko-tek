package LoginRegister;
/*
@author Bridget
changing the enum array to an array of objects, this class did NOT like what I changed in the ClubOperation
 */
public enum DummyRole implements Role {
    PATRON("patron", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    }),
    BARTENDER("bartender", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void serveDrinks() {
                    System.out.println("Serving drinks.");
                }

                @Override
                public void rejectEntry() {
                    System.out.println("Rejecting entry.");
                }

                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    }),
    TALENT("talent", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void accessStage() {
                    System.out.println("Accessing stage.");
                }

                @Override
                public void accessGreenRoom() {
                    System.out.println("Accessing green room.");
                }

                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    }),
    SECURITY("security", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void enforceRules() {
                    System.out.println("Enforcing rules.");
                }

                @Override
                public void rejectEntry() {
                    System.out.println("Rejecting entry.");
                }

                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    }),
    ADMINISTRATOR("administrator", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void manageRoles() {
                    System.out.println("Managing roles.");
                }

                @Override
                public void manageOperations() {
                    System.out.println("Managing operations.");
                }

                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    }),
    MANAGER("manager", new ClubOperation[]{
            new ClubOperation() {
                @Override
                public void manageEmployees() {
                    System.out.println("Managing employees.");
                }

                @Override
                public void reviewDataDashboard() {
                    System.out.println("Reviewing data dashboard.");
                }

                @Override
                public void accessEstablishment() {
                    System.out.println("Accessing establishment.");
                }

                @Override
                public void openTab() {
                    System.out.println("Opening tab.");
                }
            }
    });


    //Fields that hold the roleName and the ClubOperations
    private String roleName;
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

    public void performOperation(String operationName) {
        for (ClubOperation operation : operations) {
            switch (operationName) {
                case "accessEstablishment":
                    operation.accessEstablishment();
                    break;
                case "openTab":
                    operation.openTab();
                    break;
                case "serveDrinks":
                    operation.serveDrinks();
                    break;
                case "rejectEntry":
                    operation.rejectEntry();
                    break;
                case "accessStage":
                    operation.accessStage();
                    break;
                case "accessGreenRoom":
                    operation.accessGreenRoom();
                    break;
                case "enforceRules":
                    operation.enforceRules();
                    break;
                case "manageRoles":
                    operation.manageRoles();
                    break;
                case "manageOperations":
                    operation.manageOperations();
                    break;
                case "manageEmployees":
                    operation.manageEmployees();
                    break;
                case "reviewDataDashboard":
                    operation.reviewDataDashboard();
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
    }
}
