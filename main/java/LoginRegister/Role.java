package LoginRegister;

public interface Role{ //Role interface
    String getRoleName();//signature method to get name of the role: getter
    ClubOperation[] getOperations();//signature method to get the list of operations that role can do: getter
}