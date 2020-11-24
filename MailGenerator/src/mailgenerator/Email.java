/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailgenerator;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private static MailGenerator instance = new MailGenerator();
    private static Properties props = new Properties();
    public static MailGenerator getInstance(){
        return instance;
    }

    public Email() {}

    public static Properties getProps() {
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        return props;
    }

    public static void enviarEmail(String titulo, String corpo, String destinatario){
        Session session = Session.getDefaultInstance(getProps(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        String seuEmail = "SEUEMAIL"; //INSIRA SEU EMAIL PARA AUTENTICAÇÃO
                        String suaSenha = "SUASENHA"; //INSIRA SUA SENHA PARA AUTENTICAÇÃO
                        return new PasswordAuthentication(seuEmail + "@gmail.com" ,
                                suaSenha); 
                    }
                });

        session.setDebug(true);

        try {

            //IMPORTANTE É NECESSARIO HABILITAR  ACESSO A APP MENOS SEGURO NO GMAIL = > 
            //Gerenciar sua Conta do Google > Segurança > Acesso a app menos seguro > Ativar acesso
            Message message = new MimeMessage(session);
            String seuEmail = "SEUEMAIL"; //INSIRA SEU EMAIL PARA REMETENTE
            message.setFrom(new InternetAddress(seuEmail + "@gmail.com"));

            Address[] toUser = InternetAddress 
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(titulo);
            message.setText(corpo);
            Transport.send(message);

            System.out.println("Enviado!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}