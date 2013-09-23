

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {

	private static final String SMTP_HOST = "smtp.mail.yahoo.com";
	private static final String FROM = "veera_bvm@yahoo.com";
	private static final String TESTNG_RESULT_FILE = "test-output/emailable-report.html"; 
	private static final String[] To_Recipients={"veeramani.b@cognizant.com"};
	/**
	 * 
	 * Send email to a recipient 
	 * 
	 * @param subject
	 * @param from
	 * @param toRecipients
	 * @param contentFileName
	 * @param attachmentFileLocation
	 * @param attachmentFileNameInMail
	 */

	@SuppressWarnings("unused")
	private static void sendMail(String subject, String from,
			String[] toRecipients, String contentFileName,
			String attachmentFileLocation, String attachmentFileNameInMail) {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		Session session = Session.getDefaultInstance(props);
		BufferedReader reader = null;
		try {
			MimeMessage emailMessage = new MimeMessage(session);
			emailMessage.setFrom(new InternetAddress(from));
			Address[] addresses = new InternetAddress[toRecipients.length];
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			for (int recipientCount = 0; recipientCount < toRecipients.length; recipientCount++) {
				addresses[recipientCount] = new InternetAddress(
						toRecipients[recipientCount]);
			}
			emailMessage.setRecipients(Message.RecipientType.TO, addresses);
			emailMessage.setSubject(subject);

			if (contentFileName != null) {
				reader = new BufferedReader(new FileReader(contentFileName));
				String line;
				String message = "";

				while ((line = reader.readLine()) != null) {
					message += line;
				}
				MimeBodyPart part = new MimeBodyPart();
				part.setContent(message, "text/html; charset=utf-8");
				multipart.addBodyPart(part);
			}

			DataSource source;
			try {
				new FileReader(attachmentFileLocation);
				source = new FileDataSource(attachmentFileLocation);
			} catch (IOException err) {
				source = null;
			}

			if (source != null) {
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(attachmentFileNameInMail);
				multipart.addBodyPart(messageBodyPart);
			}
			emailMessage.setContent(multipart);
			Transport.send(emailMessage);
		}

		catch (Exception err) {
			throw new RuntimeException("An error occurred while sending email", err);
		}

		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// do nothing here
				}
			}
		}

	}
	
	public static void main(String arg[]) {
		sendMail("Test Report", FROM, To_Recipients, TESTNG_RESULT_FILE, "test-output", "test-output\\emailable_report.html");
	}
}
	
