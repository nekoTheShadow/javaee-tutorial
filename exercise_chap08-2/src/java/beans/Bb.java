package beans;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Named
@RequestScoped
@Data
public class Bb {
    @Size(max = 30)
    private String title;
    
    @Pattern(regexp = "^a[0-9]{4}")
    private String code;
    
    @Past
    private Date date;
    
    @Max(30000)
    private Integer amount;
    
    public String next() {
        return "output.xhtml";
    }
}
