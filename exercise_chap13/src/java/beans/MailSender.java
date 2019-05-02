package beans;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import lombok.Setter;
import net.tkxtools.JmSender;

@Stateless
@Setter
public class MailSender {
    
    @EJB
    GMailProperties properties;
    
    String mail_id = ""; // あなたのGoogleのメールIDを記入してください
    String mail_pw = ""; // あなたのGoogleのメールパスワードを記入してください。
    String from    = ""; // あなたのGoogleのメールアドレスを記入してください。
    String host = "smtp.gmail.com";
    int port = 587;

    @Asynchronous
    public void send(String c_mail, String subject, String body) {
        mail_id = properties.getAddress();
        mail_pw = properties.getPassword();
        from = properties.getAddress();
        
        try {
            JmSender.send(mail_id, mail_pw, host, port, c_mail, from, subject, body);
        } catch (Exception e) {
        }
    }
}
