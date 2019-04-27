import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestEnviromentVariables {

    @Test
    void testSystemEnviromentVariables() {
        Map<String,String> sysEnvMap = System.getenv();
        for (String s : sysEnvMap.keySet()) {
            System.out.println("Key : " + s);
            System.out.println("Value : " + sysEnvMap.get(s));
            System.out.println("################");
        }
    }

}
