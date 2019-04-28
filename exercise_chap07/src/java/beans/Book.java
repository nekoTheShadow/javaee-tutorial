package beans;

import java.util.Objects;
import lombok.Data;

@Data
public class Book {

    private String title;
    private String author;
    private String publisher;
    private String date;
    private boolean editable;

    public Book(String[] s) {
        // nullでなければ引数の配列要素を代入し、nullなら空文字列を代入する
        this.title =  s[0] != null ? s[0] : "";
        this.author = s[1] != null ? s[1] : "";
        this.publisher = s[2] != null ? s[2] : "";
        this.date = s[3] != null ? s[3] : "";
    }
}
