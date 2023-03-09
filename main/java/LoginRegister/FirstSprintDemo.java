package LoginRegister;

import java.util.Objects;
import java.util.Scanner;

public class FirstSprintDemo {
    public static void demo() {
        Scanner scanny = new Scanner(System.in);
        System.out.println("1 demo login - 2 demo user registration - 3 demo Club Registration 4 exit");
        String answer = scanny.nextLine();
        if (Objects.equals(answer, "1")) {
            Login.login(Registry.userMap);
        } else if (Objects.equals(answer, "2")){
            Registry.registerUser();
        } else if (Objects.equals(answer, "4")) {
            System.out.println("Goodbye");
            System.exit(0);
        } else {
            demo();
        }
    }
}
