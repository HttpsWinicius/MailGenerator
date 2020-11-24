/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailgenerator;
import java.util.Scanner;


/**
 *
 * @author Marco
 */
public class MailGenerator {

    /**
     Habilitar Acesso a app menos seguro
     Conta Gmail > Configurações > Segurança > Acesso a app menos seguro
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        String assunto;
        String msg;
        String email;
        
        System.out.printf("Informe o assunto:\n");
        assunto = ler.next();
        ler.nextLine(); 
        
        System.out.printf("Informe a menssagem:\n");
        msg = ler.next();
        ler.nextLine();
        
        System.out.printf("Informe o email:\n");
        email = ler.next();
        ler.nextLine(); 
        
        System.out.println("Assunto: \n" + assunto + "\nMenssagem: \n" + msg + "\nEmail: \n" + email);
        
        int numero = 3;
        
        System.out.printf("1 - Sim \n" + "2 - Não \n" + "Enviar email ? \n");
        numero = ler.nextInt();
        
        switch (numero){ 
            case 1: 
                    Email.enviarEmail(assunto, msg, email);
                break;
            case 2: 
                System.out.println("Envio de e-mail cancelado com sucesso !");
                break;
        }
        
    }

}
