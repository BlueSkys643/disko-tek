package package1;

import java.io.IOException;

public interface User { // User interface
    void userExperience();
    String getUsername(); // signature method to get the Username: getter
    DummyRole[] getRoles(); // signature method to get the Roles: getter
    String getPassword(); // getter to get the password: signature method
    int getAge();
    String getEmail();
    String getName();
    public void loggedIn() throws IOException;
}
