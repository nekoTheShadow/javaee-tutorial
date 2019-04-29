package beans;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class Bb {
    private String title;
    private String code;
    private Date date;
    private Integer amount;
    
    public String next() {
        return "output.xhtml";
    }
}
