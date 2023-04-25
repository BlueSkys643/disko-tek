package LoginRegister;
/*
@author Bridget
 */
public class UpInDaClubState extends UserState {
    // Class representing the state of a user when they are in the club

    @Override
    public void accessClub() {
        System.out.println("User is already in the club.");
    }

    @Override
    public void leaveClub() {
        System.out.println("User is leaving the club.");
    }
}
