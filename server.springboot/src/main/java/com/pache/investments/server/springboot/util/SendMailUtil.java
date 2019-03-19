/**
 * 
 */
package com.pache.investments.server.springboot.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pache.investments.server.springboot.exception.EmailError;

/**
 * Util class to send an email. Configuration file in
 * src/main/java/email.properties
 * 
 * @author lpache
 *
 */
public class SendMailUtil {

	private static Logger logger = LoggerFactory.getLogger(SendMailUtil.class);

	private static final String FROM_EMAIL_GMAIL_COM = "from-email@gmail.com";
	private static String username;
	private static String password;

	static {
		username = "";
		password = "";
	}

	private SendMailUtil() {
		throw new InstantiationError("Not Alowed!");
	}

	public static void sendByTLS(String destination, String subject, String body, String... ccDestinations)
			throws EmailError {
		logger.info("Start send mail TLS!");

		try {
			Properties props = loadProperties("TLS");
			Session session = createSession(username, password, props);

			MimeMessage message = new MimeMessage(session);
			message.addHeader("Content-type", "text/HTML; charset=utf-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");

			message.setFrom(new InternetAddress(FROM_EMAIL_GMAIL_COM, true));
			if(ccDestinations != null) {
				for (String ccDestination : ccDestinations) {
					message.addRecipient(RecipientType.BCC, new InternetAddress(ccDestination, true));
				}
			}
			message.setSubject(subject, "utf-8");
			message.setSentDate(new Date());

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
			message.setSubject(subject);
			message.setText(getBodyGeneric(body), "utf-8", "html");
			Transport.send(message);
			logger.info("End send mail TLS!");
		} catch (MessagingException | IOException e) {
			logger.error(e.getMessage());
			throw new EmailError(e.getMessage());
		}
	}

	private static String getBodyGeneric(String str) {
		return String.format("<div style=\"text-align: center;\"><font color=black size=\"6\">%s</font><br></div>",
				str);
	}

	private static Session createSession(final String username, final String password, Properties props) {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		return session;
	}

	private static Properties loadProperties(String protocol) throws EmailError, IOException {
		switch (protocol) {
		case "TLS":
			Properties p = new Properties();
			p.setProperty("mail.smtp.auth", "true");
			p.setProperty("mail.smtp.host", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			return p;
		default:
			throw new EmailError("Error - protocol undefined");
		}
	}

}
