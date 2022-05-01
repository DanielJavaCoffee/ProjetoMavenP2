package projetoMaven.model;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MensageiroEmail {
	
	public static <T> void enviarMensagemAoCliente (String assunto, String email, T t)  {

        Properties props = new Properties();

        props.put("mail.smtp.user", "projeto2021ifpb@gmail.com"); // remetente
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.EnableSSL.enable","true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("projeto2021ifpb@gmail.com", "Da76agH!"); // remetente e senha
                    }
                }); //remetente

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("projeto2021ifpb@gmail.com")); // remetente

            Address[] toUser = InternetAddress.parse(email); // destinatario

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
            message.setText((String) t);
            Transport.send(message);

        } catch (MessagingException e) {

            System.out.print("Ocorreu um erro, tente novamente!");
        }
    }
}
