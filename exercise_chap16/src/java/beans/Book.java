package beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book implements Serializable {
    @EmbeddedId
    private BkKey id;			// 主キー
    
    private String title;		// 題名
    private String author;		// 著者名
    
    @Temporal(TemporalType.DATE)
    private Calendar pdate;		// 作成年月日
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String text;		// 本文
}
