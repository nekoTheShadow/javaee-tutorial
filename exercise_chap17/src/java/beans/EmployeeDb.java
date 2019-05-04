package beans;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDb {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Employee employee) {
        Commute commute = employee.getCommute();
        if (entityManager.contains(commute)) {
            entityManager.refresh(commute);
        }
        entityManager.persist(employee);
    }
}
