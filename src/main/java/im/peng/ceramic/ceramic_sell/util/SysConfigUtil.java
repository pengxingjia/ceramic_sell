package im.peng.ceramic.ceramic_sell.util;

import java.io.IOException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysConfigUtil {

    public SysConfigUtil() {
    }

    private static Properties props = new Properties();

    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("sys.properties"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }

    public static void updateProperties(String key, String value) {
        props.setProperty(key, value);
    }
}
