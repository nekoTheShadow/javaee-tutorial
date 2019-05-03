package beans;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class Bb {
    @Getter
    @Setter
    @Size(min=5, max=5)
    private String code;

    @Getter
    @Setter    
    @Size(min=1, max=5)
    private String title;

    @Getter
    @Setter    
    @Size(min=1, max=5)
    private String author;

    @Getter
    @Setter    
    @NotNull
    private Integer price;
    
    @EJB
    BookDb bookDb;
    
    @Inject
    transient Logger logger;
    
    public String next() {
        create();
        return null;
    }
    
    public void create() {
        boolean exists = true;
        Book book = bookDb.find(code);
        if (book == null) {
            book = new Book();
            exists = false;
        }
        
        book.setCode(code);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        if (exists) {
            bookDb.update(book);
        } else {
            bookDb.create(book);
        }
    }
}
