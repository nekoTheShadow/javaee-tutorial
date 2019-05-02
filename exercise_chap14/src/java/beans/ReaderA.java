package beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@RequestScoped
public class ReaderA {

    @Inject
    transient Logger log;
    
    public void read(@Observes String body) {
        log.log(Level.INFO, body);
    }
}
