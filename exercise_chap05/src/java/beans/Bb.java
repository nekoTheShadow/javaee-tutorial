package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;

@Named
@RequestScoped
@Data
public class Bb {
    private String name;
    private Double weight;
    private Double height;
    private String note;

    public String next() {
        return "output.xhtml";
    }

    public double getBmi() {
        return weight / (height * height);
    }

    public String getBmiMessage() {
        double bmi = getBmi();
        if (bmi < 20) {
            return "やせすぎ";
        } else if (bmi < 24) {
            return "普通";
        } else if (bmi < 26.5) {
            return "太り気味";
        } else {
            return "太りすぎ";
        }
    }
}
