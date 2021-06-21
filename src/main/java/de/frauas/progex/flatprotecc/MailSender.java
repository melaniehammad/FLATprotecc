package main.java.de.frauas.progex.flatprotecc;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    protected Session mailSession;
    
    public MailSender(){}
    
    public void sendValidationCode(String recepient, int code){
        final String username = "FLATprotecc@gmail.com";
        final String password = "Cheesecake0";
        
        login(username, password);
        send(recepient, Integer.toString(code));
    }

    private void login(String username, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        this.mailSession = Session.getDefaultInstance(props, auth);
        System.out.println("Logged In.");
    }

    private void send(String receiverAddresses, String code)
            throws MessagingException, IllegalStateException, UnsupportedEncodingException {
        if (mailSession == null) {
            throw new IllegalStateException("Du musst dich zuerst einloggen (login()-Methode)");
        }

        final String replyAddress = "noreply.FLATprotecc@gmail.com";
        final String senderName = "FLATprotecc";
        final String subject = "Your Validation Code";
        final String messageBody = "Your Validation Code is: " + code;

        MimeMessage msg = new MimeMessage(mailSession);
        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");

        msg.setFrom(new InternetAddress(replyAddress, senderName));
        msg.setReplyTo(InternetAddress.parse(replyAddress, false));
        msg.setSubject(subject, "UTF-8");
        msg.setText(messageBody, "UTF-8");
        msg.setSentDate(new Date());

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverAddresses, false));

        System.out.println("Versende E-Mail...");
        Transport.send(msg);
        System.out.println("E-Mail versendet.");
    }

}
