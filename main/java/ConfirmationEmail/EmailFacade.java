package ConfirmationEmail;

import com.google.gson.Gson;

import java.io.ObjectInputFilter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

public class EmailFacade {
    public static void confirmEmail (String email) {
        int code = (int) (999999 * Math.random());
        //System.out.println(code);

        //send code to user
        System.out.println("checkpoint 1");
        try {
            System.out.println("checkpoint 2");
            Gson g = new Gson();
            System.out.println("checkpoint 3");
            Scanner fs = new Scanner(Paths.get(Objects.requireNonNull(
                    Main.class.getClassLoader().getResource("ConfirmationEmail/EmailConfig.json")).toURI()),
                    StandardCharsets.UTF_8);
            System.out.println("checkpoint 4");
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
}
