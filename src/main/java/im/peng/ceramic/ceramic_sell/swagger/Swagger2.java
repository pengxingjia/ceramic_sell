package im.peng.ceramic.ceramic_sell.swagger;


import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger接口页面展示工具
 *
 * @author qiaofeng
 */

@Configuration
@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket docket() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("身份令牌")
            .modelRef(new ModelRef("string")).parameterType("header")
            .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("im.peng.ceramic.ceramic_sell.controller"))
            .build()
            .globalOperationParameters(pars)
            .apiInfo(apiInfo());
    }

    //构建api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            //页面标题
            .title("瓷砖销售平台 API")
            //创建人
            .contact(new Contact("qiaofeng", "", "18223696520"))
            //版本号
            .version("1.0")
            //描述
            .description("api")
            .build();
    }

}