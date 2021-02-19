package com.demo.service;

import java.util.Properties;
import java.util.Random;

import com.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage; 

public class SendEmail
{
	public String getRandom() {
		Random rnd=new Random();
		int number=rnd.nextInt(999999);
		return String.format("%06d", number);
	}
	
	public boolean sendEmail(User u) {
		boolean test = false;
		
		String toEmail=u.getEmail();
		String fromEmail="swikritiranjan2710@gmail.com";
		String password="Swik@123";
		
		try {
			Properties pr=new Properties();
			
			pr.setProperty("mail.smtp.host", "smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "587");
			
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true");
			
			
			
			
			
			//get session
			Session session=Session.getInstance(pr,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail,password);
			}
				
			});
			
			Message mess=new MimeMessage(session);
			
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(u.getEmail()));
			
			mess.setFrom(new InternetAddress(fromEmail));
			
			mess.setSubject("user mail verification");
			
			mess.setText("registration successfully..please verify your account "+u.getCode());
			
			Transport.send(mess);
			test=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return test;
	}

	
	
}
