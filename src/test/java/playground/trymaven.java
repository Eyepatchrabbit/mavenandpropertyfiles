package playground;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by alexanderboffin on 10/02/17.
 */
public class trymaven {
    @Test
    public void main() throws IOException {
        java.io.InputStream is = this.getClass().getResourceAsStream("my.properties");
        java.util.Properties p = new Properties();
        p.load(is);
        String name = p.getProperty("name");
        String version = p.getProperty("version");
        String foo = p.getProperty("foo");
    }

}
