package Applozic.com;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class sentEmail2 {

	public static void sendemailMethod() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("neelamadhaba96@gmail.com", "neela@321"));
		email.setSSLOnConnect(true);
		email.setFrom("neelamadhaba96@gmail.com");
		email.setSubject("FAQ Count report");
		email.setMsg("FAQ count is less than 20");
		email.addTo("neelamadhaba1234@gmail.com");
		email.send();
	}

}
