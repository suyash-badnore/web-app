<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%!
    Properties emailProperties;
  Session mailSession;
  MimeMessage emailMessage;

  public void setMailServerProperties() {
 
    String emailPort = "587";//gmail's smtp port
 
    emailProperties = System.getProperties();
    emailProperties.put("mail.smtp.port", emailPort);
    emailProperties.put("mail.smtp.auth", "true");
    emailProperties.put("mail.smtp.starttls.enable", "true");
 
  }
 
  public void createEmailMessage() throws AddressException,
      MessagingException {
    String[] toEmails = { "phani.ratna@gmail.com" ,"brkaran2k2@yahoo.co.in"};
    String emailSubject = "Java Email";
    String emailBody = "Testing mail program";
    String filename="C:\\Documents and Settings\\sen\\Desktop\\synch.docx";
 
    mailSession = Session.getDefaultInstance(emailProperties, null);
    emailMessage = new MimeMessage(mailSession);
 
    for (int i = 0; i < toEmails.length; i++) {
      emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
    }
 
    emailMessage.setSubject(emailSubject);
    emailMessage.setContent(emailBody, "text/html");//for a html email
    //emailMessage.setText(emailBody);// for a text email
    emailMessage.setFileName(filename);
    
 
  }
 
  public void sendEmail() throws AddressException, MessagingException {
 
    String emailHost = "smtp.gmail.com";
    String fromUser = "brkaran2k2@gmail.com";//just the id alone without @gmail.com
    String fromUserEmailPassword = "bhim@123";
 
    Transport transport = mailSession.getTransport("smtp");
 
    transport.connect(emailHost, fromUser, fromUserEmailPassword);
    transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
    transport.close();
    System.out.println("Email sent successfully.");
  }
 
%>
<%
   String result;
   
   try{
  
    setMailServerProperties();
    createEmailMessage();
    sendEmail();
    result = "Sent message successfully....";
   }catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
   }
%>
<html>
<head>
<title>Send Email using JSP</title>
</head>
<body>
<center>
<h1>Send Email using JSP</h1>
</center>
<p align="center">
<% 
   out.println("Result: " + result + "\n");
%>
</p>
</body>
</html>