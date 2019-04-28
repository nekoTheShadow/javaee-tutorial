    package util;

import beans.Book;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class BookUtil {

    /**
     * ファイルデータからBookオブジェクトのListを作成して返す
     *
     * @param fpath CSV形式の書籍データファイル（書名、作者、出版社、出版年月）のパス<br/>
     * アプリケーションルートから相対パスで指定する（/resources/date/book.csv）
     * @return	ls Bookオブジェクトを要素として持つList
     */

    public static List<Book> getList(String fpath) {
        Logger log = Logger.getLogger(BookUtil.class.getName());
        String path = getRealPath(fpath);
        try {
            return Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                        .map(line -> line.split(","))
                        .filter(s -> s.length == 4)
                        .map(Book::new)
                        .collect(Collectors.toList());
        } catch (IOException ex) {
            log.severe("★ファイルが見つからない:" + fpath);
        }
        return Collections.emptyList();
    }

    // I/Oで使用するパスを求める

    public static String getRealPath(String path) {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return ctx.getRealPath(path);
    }
}
