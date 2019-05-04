package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommuteDb {
    @PersistenceContext
    EntityManager entityManager;
        
    public List<Commute> findAll() {
        return entityManager.createQuery("SELECT e FROM Commute e").getResultList();
    }
    
    public void persist(Commute commute) {
        entityManager.persist(commute);
    }
}
