package im.peng.ceramic.ceramic_sell;

import im.peng.ceramic.ceramic_sell.util.JwtEncryption;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CeramicSellApplicationTests {

    @Test
    void contextLoads() {
        try {
            System.out.println(JwtEncryption.createFreshToken("12345"));
            String vxOpenId = "oEjtL5KMTaP48F8M8YPRBxL55WLU";
            String token = JwtEncryption.createToken(vxOpenId);
            String freshToken = JwtEncryption.createFreshToken(vxOpenId);
            System.out.println(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
