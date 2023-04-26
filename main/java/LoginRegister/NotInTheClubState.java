package LoginRegister;
/*
@author Bridget
 */
public class NotInTheClubState extends UserState {
    // Class representing the state of a user when they are not in the club

    @Override
    public void accessClub() {
        System.out.println("User is entering the club.");
    }

    @Override
    public void leaveClub() {
        System.out.println("User is not in the club.");
    }
}

//Need a Tab class and something in the TestClub to keep track of tabs of all users who are UpInDaClub