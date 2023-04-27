/**
 *
 * @author Jeff
 * @author Ricky G
 *(PairProgrammed)
 */

package LoginRegister;

import java.io.IOException;
/**
 * Represents a bartender user in the system, with additional functionality specific to their role.
 */
public class BartenderUser extends DummyUser {
    public BartenderUser(UserData userData) {
        super(userData);
    }
    /**
     * Runs the user experience for this bartender user.
     */
    @Override
    public void userExperience() {
        // TODO: implement bartender-specific user experience
    }
    /**
     * Performs any necessary actions when the user logs in.
     * This method is called automatically by the system after the user has entered their login credentials.
     *
     * @throws IOException if there is an error reading or writing data
     */

    @Override
    public void loggedIn() throws IOException {
        // TODO: perform any necessary actions for a bartender user after they log in
    }
}