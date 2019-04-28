package beans;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class Bb {
    
    @Getter
    private Map<Integer, Integer> yearItems;
    
    @Getter
    private Map<String, String> regionItems;
    
    @Getter
    private SelectItem[] interestItems = {
        new SelectItem("政治", "政治"),
        new SelectItem("社会", "社会"),
        new SelectItem("経済", "経済"),
        new SelectItem("歴史", "歴史"),
        new SelectItem("文化", "文化"),
        new SelectItem("芸能", "芸能"),
        new SelectItem("スポーツ", "スポーツ")
    };
    
    @Getter
    private SelectItem[] sexItems  = {
        new SelectItem(1, "男性"),
        new SelectItem(2, "女性"),
    };


    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private Integer year;	
    
    @Getter
    @Setter
    private Integer sex;	
    
    @Getter
    @Setter
    private String region;	
    
    @Getter
    @Setter
    private String[] interest;
    
    @Getter
    @Setter
    private boolean magazine;	

    {
        yearItems = new LinkedHashMap<>();
        IntStream.range(1940, 2000).forEach(i -> yearItems.put(i, i));
        
        regionItems = new LinkedHashMap<>();
        regionItems.put("北海道", "北海道");
        regionItems.put("東北", "東北");
        regionItems.put("関東", "関東");
        regionItems.put("中部", "中部");
        regionItems.put("関西", "関西");
        regionItems.put("中国", "中国");
        regionItems.put("四国", "四国");
        regionItems.put("九州・沖縄", "九州・沖縄");
        
        region = "関東";
        magazine = false;
    }

    public String getStringSex() {
        return sex.equals("1") ? "男性" : "女性";
    }

    public String getStringInterests() {
        return String.join(" ", interest);
    }

    public String getStringMagazine() {
        return magazine ? "受け取る" : "受け取らない";
    }
    
    public String next() {
        return "output.xhtml";
    }
}
