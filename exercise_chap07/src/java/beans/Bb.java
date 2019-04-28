package beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import util.BookUtil;

@Named
@SessionScoped
@Data
public class Bb implements Serializable {

    private List<Book> books = BookUtil.getList("/resources/data/Book.csv");
    
    public String next() {
        // 実際にはここでデータベースなどに保存する
        return null;
    }

    public String edit(Book book) {
        book.setEditable(true);
        return null;
    }
}
