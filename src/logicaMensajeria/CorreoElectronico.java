package logicaMensajeria;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreoElectronico {
	
	
	  private String nombreCorreoElectronico;
	  
	  public CorreoElectronico() {}
	  
	  public void enviarCorreoElectronico(String pcorreoElectronico, String ptexto)
	  {
	  
	  String to = pcorreoElectronico; String from = "POO.PP.Plan@gmail.com"; String
	  host = "smtp.gmail.com";
	  
	  Properties properties = System.getProperties();
	  
	  properties.put("mail.smtp.host", host); properties.put("mail.smtp.port",
	  "465"); properties.put("mail.smtp.ssl.enable", "true");
	  properties.put("mail.smtp.auth", "true");
	  
	  Session session = Session.getInstance(properties, new
	  javax.mail.Authenticator() {
	  
	  protected PasswordAuthentication getPasswordAuthentication() {
	  
	  return new PasswordAuthentication("POO.PP.Plan@gmail.com",
	  "VPGqYAdn647vWX6");
	  
	  }
	  
	  });
	  
	  session.setDebug(true);
	  
	  try {
	  
	  MimeMessage message = new MimeMessage(session);
	  
	  message.setFrom(new InternetAddress(from));
	  
	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	  
	  message.setSubject("Informacion Hospital TEC");
	  
	  message.setText(ptexto);
	  
	  Transport.send(message); System.out.println("Sent message successfully....");
	  } catch (MessagingException mex) { mex.printStackTrace(); }
	  
	  }
	 

}
