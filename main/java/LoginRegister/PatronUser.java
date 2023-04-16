package LoginRegister;

public class PatronUser extends DummyUser{
    public PatronUser(UserData userData) {
        super((UserData) userData);
    }

    @Override
    public void userExperience() {
    }

    public void loggedIn() {
        System.out.println("debug in PatronUser.loggedIn() User " + this.getUsername() + " is logged in. From here we update the observers.");
    }
}
