package app.email.connection;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    private MimeMessage msg;
    private Properties properties;
    private Session session;
    public static boolean isLoggedIn = false;
    {
        properties = new Properties();
    }

    public EmailSender() {
    }

    public void sendEmail(Session session, String nickName, String senderAddress, String toEmail,String subject, String body) {
        if(nickName == null) nickName = "UnknownUser";

        msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setRecipients(Message.RecipientType.TO,(Address[]) InternetAddress.parse(toEmail,false));
            msg.setSubject(subject,"UTF-8");
            msg.setFrom(new InternetAddress(senderAddress, nickName));
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.out.println("Email sended");
            isLoggedIn = true;
        } catch (Exception e) {
            e.printStackTrace();
            isLoggedIn = false;
        }


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

    }

    public Session getSession() {
        return session;
    }
}