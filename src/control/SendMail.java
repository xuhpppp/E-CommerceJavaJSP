package control;

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

public class SendMail {
	public static void send(String toEmail) throws MessagingException, UnsupportedEncodingException {
		final String fromEmail = "doanthephuc.ST@gmail.com";
		final String password = "hsbq umkg mcwg eopb";
		
		final String subject = "Thanksletter from EShop";
        final String body = "<h2>Thank you</h2>" + "<img src='https://wpthemesgrid.com/themes/eshop/images/logo.png'>" + "<br>" + "<div>Thank you for being a customer of our EShop, wish you the best shopping moment.</div>" + "<div>EShop Team, regard.</div>";
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Authenticator auth = new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication(fromEmail, password);
        	}
        };
        
        Session session = Session.getInstance(props, auth);
        
        MimeMessage msg = new MimeMessage(session);
        
        msg.addHeader("content-type", "text/HTML; charset=UTF-8");
        msg.addHeader("format", "flowed");
        msg.addHeader("Content-Transfer-Encoding", "8bit");
        
        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
        
        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
        
        msg.setSubject(subject, "UTF-8");
        
        msg.setContent(body, "text/html");
        
        msg.setSentDate(new Date());
        
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        
        Transport.send(msg);
        
        System.out.println("Gui mail thanh cong");
	}
}
