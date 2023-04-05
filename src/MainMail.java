import javax.mail.internet.*; 
import java.util.Properties;  
import javax.mail.*;  

class Mail {
  public static void send(String from,String pwd,String to,String sub,String msg){
    //Properties
    Properties p = new Properties();
    p.put("mail.smtp.host", "smtp.gmail.com");
    p.put("mail.smtp.socketFactory.port", "465");
    p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.port", "465");
    //Session
    Session s = Session.getDefaultInstance(p,
      new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(from, pwd);
      }
    });
    //compose message
    try {
      MimeMessage m = new MimeMessage(s);
      m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
      m.setSubject(sub);
      m.setText(msg);
      //send the message
      Transport.send(m);
      System.out.println("Message sent successfully");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
public class MainMail {
 public static void main(String[] args) {
   //from, password, to, subject, message
   Mail.send(
    "samsungservicecentre2@gmail.com",
    "csc_project",
    "guptaabhay0809@gmail.com",
    "Bienvenu sur StackHowTo",
    "test mail!"
  );
 }
}