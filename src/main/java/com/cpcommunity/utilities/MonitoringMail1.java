package com.cpcommunity.utilities;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;






import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;








public class MonitoringMail1 {

	public void Sendmail() {
	
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
          body.setContent("<h1>Hello Java Mail \n ABC123</h1>","text/html");
//          message.setDataHandler(new DataHandler(new HTMLDataSource("<h1>Hello Java Mail \\n ABC123</h1>")));
          BodyPart attachment = new MimeBodyPart();
           Date date = new Date();  
           SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");  
           String strDate = formatter.format(date);    
           String fileName = "Extent_" + strDate.toString().replace(" ", "_") + ".html";
           System.out.println(System.getProperty("user.dir")+"\\reports\\"+fileName);
           DataSource source = new FileDataSource(System.getProperty("user.dir")+"\\reports\\"+fileName);
           attachment.setDataHandler(new DataHandler(source));
           
           attachment.setFileName("Extent_14_February_2020.html");
           
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
	
	
	
	static class HTMLDataSource implements DataSource {

        private String html;

        public HTMLDataSource(String htmlString) {
            html = htmlString;
        }

        
        public InputStream getInputStream() throws IOException {
            if (html == null) throw new IOException("html message is null!");
            return new ByteArrayInputStream(html.getBytes());
        }

        
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("This DataHandler cannot write HTML");
        }

        
        public String getContentType() {
            return "text/html";
        }

        
        public String getName() {
            return "HTMLDataSource";
        }
	
	
	}
	
	
}
