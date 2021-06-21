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

public class StartMailSender {

	public static void main(String[] args) {

		final String username = "FLATprotecc@gmail.com";
		final String password = "Cheesecake0";

		MailSender sender = new MailSender();
		sender.login(username, password);

		try {

			sender.send("ana@erlenkoetter.net",
					"Überall dieselbe alte Leier.\r\n\r\nDas Layout ist fertig, der Text lÃ¤sst auf sich warten. "
							+ "Damit das Layout nun nicht nackt im Raume steht und sich klein und leer vorkommt, "
							+ "springe ich ein: der Blindtext. Genau zu diesem Zwecke erschaffen, immer im Schatten "
							+ "meines großen Bruders »Lorem Ipsum«, freue ich mich jedes Mal, wenn Sie ein paar Zeilen "
							+ "lesen. Denn esse est percipi - Sein ist wahrgenommen werden.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static class MailSender {

		protected Session mailSession;

		public void login(final String username, final String password) {
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

			mailSession = Session.getDefaultInstance(props, auth);
			System.out.println("Logged in.");
		}

		public void send(String receiverAddresses, String message)
				throws MessagingException, IllegalStateException, UnsupportedEncodingException {
			if (mailSession == null) {
				throw new IllegalStateException("Not logged in. Use login()-method");
			}
                        
                        final String senderMail = "noreply-flatprotecc@gmail.com";
                        final String senderName = "FLATprotecc";
                        final String subject = "Your One-Time Password";
                        
                        

			MimeMessage msg = new MimeMessage(mailSession);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(senderMail, senderName));
			msg.setReplyTo(InternetAddress.parse(senderMail, false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(message, "UTF-8");
			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverAddresses, false));

			System.out.println("Versende E-Mail...");
			Transport.send(msg);
			System.out.println("E-Mail versendet.");
		}

	}

}