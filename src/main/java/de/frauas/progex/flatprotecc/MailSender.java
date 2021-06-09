package de.frauas.progex.flatprotecc;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.activation.*;

public class MailSender {

    public MailSender() {
        sendMail("th2504tthh2504@gmail.com");
    }

    private void sendMail(String recipient) {
        final String host = "smtp.gmail.com";
        final String senderAddress = "FLATprotecc@gmail.com";
        final String senderPassword = "Cheesecake0";

        /*Properties properties = System.getProperties();
		
        String host = "smtp.gmail.com";
	properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	properties.put("mail.smtp.socketFactory.port", "465");
	properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        //properties.put("mail.smtp.user", "FLATprotecc@gmail.com");*/
        // creates a new session, no Authenticator (will connect() later)
        //Works but times out
        Properties properties = System.getProperties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.timeout", "10000");
        properties.put("mail.smtp.connectiontimeout", "10000");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");//587

        Session session = Session.getDefaultInstance(properties, null);
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
            MimeMessage msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(senderAddress));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject("Your OneTimePasscode");
            msg.setText("This is a simple text body\n\nLine Break Test");

            //Transport.send(msg);
            Transport t = session.getTransport("smtp");
            t.connect(host, senderAddress, senderPassword);
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
