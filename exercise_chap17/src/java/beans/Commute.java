package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commute implements Serializable {

    @Id
    @Enumerated(EnumType.STRING)
    private Transportation tid;
    
    @Column
    private Integer allowance;
    
    @OneToMany(mappedBy = "commute", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
