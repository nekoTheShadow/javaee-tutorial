package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class Bb {
    
    @Inject
    Bin bin;

    private int val;
    private String s;
    /* ここにBinをインジェクトする */

    public String next() {
        s = bin.toBin(val);
        return null;
    }
}
