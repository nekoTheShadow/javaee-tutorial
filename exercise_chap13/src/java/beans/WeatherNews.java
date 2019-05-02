package beans;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class WeatherNews {
    @EJB
    GMailProperties properties;
    
    @EJB
    MailSender mailSender;
    
    @EJB
    WeatherFeed weatherFeed;
    
//    @Schedule(hour="*", minute = "*", second = "*/30")
    @Schedule(hour = "*/6")
    public void send() {
        String address = properties.getAddress();
        String subject = "お天気情報";
        String body = weatherFeed.rss(13);
        mailSender.send(address, subject, body);
    }
}
