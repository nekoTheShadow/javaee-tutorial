package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookDb {
    @PersistenceContext
    EntityManager entityManager;
    
    public void create(Book book) {
        entityManager.persist(book);
    }
    
    public Book update(Book book) {
        return entityManager.merge(book);
    }
    
    public Book find(String code) {
        return entityManager.find(Book.class, code);
    }
}
