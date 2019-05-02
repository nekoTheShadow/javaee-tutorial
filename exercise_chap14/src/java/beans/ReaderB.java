package beans;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@RequestScoped
public class ReaderB {

    @Inject
    Logger log;
    @EJB
    MailSender sender;
    @EJB
    GMailProperties properties;
    
    public void read(@Observes String body) {
        sender.send(properties.getAddress(), "お天気情報", body);
    }
}
