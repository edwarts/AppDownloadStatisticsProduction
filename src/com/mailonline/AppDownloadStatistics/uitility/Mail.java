package com.mailonline.AppDownloadStatistics.uitility;

import java.util.Date;  
import java.util.Properties;  
import javax.activation.DataHandler; 
import javax.activation.FileDataSource; 
import javax.mail.Address;  
import javax.mail.BodyPart; 
import javax.mail.Message;  
import javax.mail.Multipart; 
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart; 
import javax.mail.internet.MimeMessage; 
import javax.mail.internet.MimeMultipart; 
import javax.mail.internet.MimeUtility; 
  
public final class Mail {  
  
  
    // sender email 
    //private static  String SenderEmailAddr = "bo.ma@mailonline.co.uk";
    private static  String SenderEmailAddr = "reporting-donotreply@mailonline.co.uk"; 
    //sender username
    private static String SMTPUserName = "Anldmgt\\Mailonline Reporting";  
      
    // sender password 
    private static  String SMTPPassword = "passw0rd"; 
    // smtp server  
    private static final String SMTPServerName = "mailrelay.corporate.dmgt.net"; 
    // transportType 
    private static final String TransportType = "smtp"; 
    // properties   
    private static Properties props; 
      
    public Mail() { 
    }
    public Mail(String senderEmail,String smtp_username,String smtp_password) {
     SenderEmailAddr = senderEmail; 
    	 
    	    SMTPUserName = smtp_username;  
    	      
    	
    	   SMTPPassword = smtp_password; 
    } 
      
    static {  
        Mail.props = new Properties(); 
        // store the email information   
        Mail.props.put("mail.smtp.host", Mail.SMTPServerName);  
        // verify
        Mail.props.put("mail.smtp.auth", "true");
        Mail.props.put("mail.smtp.port", 25);
    } 
      
    public static boolean sendMail(String emailAddr, String mailTitle,  
            String mailConcept,String URI,String attachmentFileName) {  
        Session s = Session.getInstance(Mail.props, null); 
        s.setDebug(false);
     
        Message message = new MimeMessage(s);  
        try {  
            // set sender
            Address from = new InternetAddress(Mail.SenderEmailAddr);  
            message.setFrom(from); 
            // set single receiver 
            Address to = new InternetAddress(emailAddr);  
            message.setRecipient(Message.RecipientType.TO, to); 
            // set title
            message.setSubject(mailTitle);  
             
          
           
           
           
           
          //  Set attachment if the attachment url is not empty
          if(!"".equals(URI))
          {
        	  Multipart mm=new MimeMultipart(); 
              //set mail body 
              BodyPart mdp=new MimeBodyPart(); 
//              mdp.setContent(arg0)  
              mdp.setContent(mailConcept,"text/plain;charset=gbk"); 
              mm.addBodyPart(mdp); 
          mdp=new MimeBodyPart(); 
          FileDataSource fds=new FileDataSource(URI); 
          DataHandler dh=new DataHandler(fds); 
           
          mdp.setFileName((MimeUtility.encodeText(attachmentFileName, "gbk", "B"))); 
           
          mdp.setDataHandler(dh); 
          mm.addBodyPart(mdp); 
          }
          else
          {
          
          message.setContent(mailConcept,"text/plain;charset=gbk"); 
          }
           
            // set sending time  
            message.setSentDate(new Date());  
            // set email information  
            message.saveChanges(); 
            Transport transport = s.getTransport(Mail.TransportType); 
            
            // set user name and password
            transport.connect(Mail.SMTPServerName, Mail.SMTPUserName, Mail.SMTPPassword);
            
            // sending email
            transport.sendMessage(message, message.getAllRecipients());  
            transport.close(); 
            System.out.println("Send email, the address :" + emailAddr + " Title:" + mailTitle  + " content:" + mailConcept + "successfully!");  
            return true; 
        } catch (Exception e) {  
             System.out.println(e.getMessage());  
             System.out.println("Send email, the address :" + emailAddr + " Title:" + mailTitle + " content:" + mailConcept + "fail with reason:" + e.getMessage());  
         return false; 
        }  
    }
    public static void main(String[] args) { 
        Mail.sendMail("newtonmark1985@gmail.com", "test", "test", "",""); 
    } 
}
