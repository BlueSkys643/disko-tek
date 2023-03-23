package ConfirmationEmail;

import java.util.Scanner;

//this main exists purely to test the email functionality and will not be implemented in final product
public class Main {
    public static void main(String[] args) {

        //prompt user for email
        Scanner s = new Scanner(System.in);
        System.out.println("Enter email: ");
        String email = s.nextLine();

        EmailFacade.confirmEmail(email);
    }
}
