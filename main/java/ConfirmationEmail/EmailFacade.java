package ConfirmationEmail;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;
import Final.Main;

public class EmailFacade {
    public static void confirmEmail (String email) {
        int code = (int) (999999 * Math.random());
        //System.out.println(code);

        //send code to user
        try {
            Gson g = new Gson();
            Scanner fs = new Scanner(Paths.get(Objects.requireNonNull(
                    Main.class.getClassLoader().getResource("EmailConfig.json")).toURI()),
                    StandardCharsets.UTF_8);
            EmailConfig c = g.fromJson(fs.useDelimiter("\\A").next(), EmailConfig.class);

            // Recipient's email ID needs to be mentioned.
            String to = email;
            // Sender's email ID needs to be mentioned
            String from = "noreply.diskotek@gmail.com";
            // Subject and Body
            String subject = "Diskotek Email Confirmation";
            String body = "Your diskotek email confirmation code is " + code;
            SendEmail client = new SendEmail(
                    c.getMailHost(), c.getMailPort(), c.getUserName(), c.getPassword(),
                    c.getEncryptionType(), c.getDoAuth());
            client.send(to, from, subject, body);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //prompt user for code
        System.out.println("Please enter the code you were sent:");
        Scanner s = new Scanner(System.in);
        int tester = s.nextInt();

        //confirmation accepted
        if (tester == code) {
            System.out.println("Congratulations on your new Diskotek account!");
        } else {
            System.out.println("Sorry but the code you entered does not match the one we sent you.");
        }

    }

    public static void SendEmail (String email, String subject, String body) {
        try {
            Gson g = new Gson();
            System.out.println("1");
            Scanner fs = new Scanner(Paths.get(Objects.requireNonNull(
                    Main.class.getClassLoader().getResource("EmailConfig.json")).toURI()),
                    StandardCharsets.UTF_8);
            System.out.println("2");
            EmailConfig c = g.fromJson(fs.useDelimiter("\\A").next(), EmailConfig.class);
            System.out.println("3");

            // Recipient's email ID needs to be mentioned.
            // Sender's email ID needs to be mentioned
            String from = "noreply.diskotek@gmail.com";
            SendEmail client = new SendEmail(
                    c.getMailHost(), c.getMailPort(), c.getUserName(), c.getPassword(),
                    c.getEncryptionType(), c.getDoAuth());
            client.send(email, from, subject, body);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
