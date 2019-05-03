package beans;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BkKey implements Serializable {
    private String publisher;	// 出版社コード
    private String code;	// 書籍コード
}
