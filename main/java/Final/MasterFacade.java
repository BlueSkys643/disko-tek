package Final;

import ConfirmationEmail.EmailFacade;
import LoginRegister.Login;
import LoginRegister.Registry;

public class MasterFacade {
    public static void sendEmail (String e, String s, String b) {
        EmailFacade.SendEmail(e,s,b);
    }
    public static void confirmEmail (String email) {
        EmailFacade.confirmEmail(email);
    }
    public static void logIn () {
        Login.login(Registry.userMap);
    }
    public static void registry () {
        Registry.registerUser();
    }
}
