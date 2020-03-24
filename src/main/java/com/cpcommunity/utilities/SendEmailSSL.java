package com.cpcommunity.utilities;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

public class SendEmailSSL {

	public static void main(String[] args) {
		

	        final String username = "andrew74444@gmail.com";
	        final String password = "1237asdf";

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "465");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.socketFactory.port", "465");
	        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.addHeader("X-Priority", "1");
	            message.setFrom(new InternetAddress("andrew74444@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("sasiakula33@gmail.com, vinod1.pamten@gmail.com")
	            );
	            message.setSubject("Testing Gmail SSL");
	            message.setText("Dear Mail Crawler,"
	                    + "\n\n Please do not spam my email!");
	            BodyPart body = new MimeBodyPart();

	            // body.setText(messageBody);
	            body.setContent("messageBody","text/html");
	            
	            BodyPart attachment = new MimeBodyPart();
	             DataSource source = new FileDataSource("D:/Workspace/SampleProject/reports/Extent_Thu_Nov_21_19_55_30_IST_2019.html");
	             attachment.setDataHandler(new DataHandler(source));
	             attachment.setFileName("Extent_Thu_Nov_21_19_55_30_IST_2019.html");
	             MimeMultipart multipart = new MimeMultipart();
	             multipart.addBodyPart(body);
	             multipart.addBodyPart(attachment);
	             message.setContent(multipart);

	            
	            
	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    

	}

}
