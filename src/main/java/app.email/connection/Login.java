package app.email.connection;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.*;

/**
 * 
 */
public class Login {

    private Properties properties;
    private Session session;
    private boolean isLoggedIn;

    {
        properties = new Properties();
    }

    public Login() {

    }
    public void loginToAccount(String smtpaddress, String smtpPort, String emailaddress, String password) {
        properties.put("mail.smtp.host", smtpaddress);
        properties.put("mail.smtp.port",smtpPort);
        //properties.put("mail.smtp.auth", smtpAuth)
        //properties.put("mail.smtp.starttls.enable",smtpstarttlsenable)
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailaddress, password);
            }
        };
        session = Session.getInstance(properties,auth);
        System.out.println("Auth successful");
    }

    public Session getSession() {
        return session;
    }
}