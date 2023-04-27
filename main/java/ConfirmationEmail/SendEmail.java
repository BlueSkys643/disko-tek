package ConfirmationEmail;

import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendEmail {
    //grab the imports
    //set up the project structure
    //write the email code
    private boolean debug = false;
    private final Properties properties;
    private final boolean doAuth;
    private final Authenticator authenticator;

    public SendEmail(String host, String port) {
        this(host, port, null, null, null, false);
    }
    public SendEmail(String host, String port, String encryptProp) {
        this(host, port, null, null, encryptProp, false);
    }
    public SendEmail(String host, String port, String userName, String password, String encryptProp, boolean doAuth) {
        // Set instance variables.
        this.doAuth = doAuth;

        // Get system properties
        properties = System.getProperties();
        // Setup mail server
        if(this.doAuth) properties.put("mail.smtp.auth", "true");
        if(encryptProp != null) properties.put(encryptProp, "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
    }

    public boolean send(String to, String from, String subject, String mailBody) {
        // Get the Session object, and pass username and password if doAuth is true
        Session session;
        session = (this.doAuth) ?
                Session.getInstance(properties, this.authenticator) : Session.getInstance(properties);

        // Used to debug SMTP issues
        session.setDebug(this.debug);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(mailBody);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return false;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

}
