package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// データベース処理を行うEJB
// 例外処理はバッキングビーンで行う
@Stateless
public class BookDb {

    @PersistenceContext
    EntityManager em;

    public void create(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void delete(Book book) {
        em.remove(em.merge(book));  // mergしてから削除する
    }

    public Book find(BkKey key) {
        return em.find(Book.class, key);
    }

    public List<Book> getAll() {
        return em.createQuery("SELECT c FROM Book c").getResultList();
    }

}
