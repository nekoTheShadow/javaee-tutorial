package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @ManyToOne
    private Commute commute;

    public Employee(String name, Commute commute) {
        this.name = name;
        this.commute = commute;
    }

}
