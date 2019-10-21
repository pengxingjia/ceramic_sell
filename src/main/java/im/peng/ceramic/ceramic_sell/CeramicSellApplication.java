package im.peng.ceramic.ceramic_sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("im.peng.ceramic.ceramic_sell.dao")
public class CeramicSellApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeramicSellApplication.class, args);
    }

}
