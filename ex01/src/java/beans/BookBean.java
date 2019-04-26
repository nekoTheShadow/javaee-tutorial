package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class BookBean {
    private String name;
    private String author;
    private Integer price;
    
    public String next() {
        System.out.printf("☆書籍名=%s / 著者名=%s / 価格=%d%n", name, author, price);
        return "output.xhtml";
    }
}
