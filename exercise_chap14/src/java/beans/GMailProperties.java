package beans;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import lombok.Getter;

@Getter
@Singleton
public class GMailProperties {
    private String address;
    private String password;
    
    @PostConstruct
    public void setUp() {
        try (InputStream in = GMailProperties.class.getClassLoader().getResourceAsStream("secret.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            
            this.address = properties.getProperty("gmail.address");
            this.password = properties.getProperty("gmail.password");
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
