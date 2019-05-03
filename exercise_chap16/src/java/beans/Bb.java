package beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;
import util.FileUtil;

@Data
@Named
@RequestScoped
public class Bb implements Serializable {

    private BkKey id;			// 主キー（複合キー）
    private String title;		// 題名
    private String author;		// 著者名
    private Calendar pdate;		// 作成年月日
    private String text;		// 本文

    @EJB
    BookDb db;	// データベース処理を行うEJBをインジェクトする

    // ライフサイクル・コールバックメソッドによる起動時の初期化
    @PostConstruct
    public void init() {
        BkKey key = new BkKey("aozora", "1");
        Book book = db.find(key);
        
        if (book == null) {
            Calendar c = Calendar.getInstance();
            c.clear();
            c.set(2004, 2, 14);
            
            book = new Book(key, "杜子春", "芥川龍之介", c, FileUtil.getText("/resources/data/toshishun.txt"));
            create(book);
        }
        
        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        pdate = book.getPdate();
        text = book.getText();
    }

    // 編集結果を保存（更新処理）して画面を再表示する
    public String save() {
        Book book = new Book(id, title, author, pdate, text);
        update(book);
        return null;
    }

    // 新規登録（例外処理を含む）
    public void create(Book book) {
        try {
            db.create(book);
        } catch (Exception e) {
        }
    }

    // 更新処理（例外処理を含む）
    public void update(Book book) {
        try {
            db.update(book);
        } catch (Exception e) {
        }

    }
}
