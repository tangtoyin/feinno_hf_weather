package com.ucss.elementary.tnwn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HL on 2017/12/19.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    ///地址:/swagger-ui.html


    /**
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     *
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     */
    final static String SERVICE_URL = "http://localhost/";
    List<Parameter> pars = new ArrayList<>();

    @PostConstruct
    public void init() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        //List<Parameter> pars = new ArrayList<>();
        ticketPar.name("appcode").description("应用方code").modelRef(new ModelRef("string")).parameterType("query").required(true).build();
        pars.add(ticketPar.build());
        ticketPar.name("rnd").description("随机数").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(ticketPar.build());
        ticketPar.name("ts").description("时间戳").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(ticketPar.build());
        ticketPar.name("sig").description("获取加密串sig").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(ticketPar.build());
        ticketPar.name("uat").description("登录标识").modelRef(new ModelRef("string")).required(false).parameterType("query").build();
        pars.add(ticketPar.build());
    }


    //region base-基础方法
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ELMT.tnwn").description("基础方法")
                .termsOfServiceUrl(SERVICE_URL)
                .version("1.0").build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).groupName("基础方法").select()
                .apis(RequestHandlerSelectors.basePackage("com.ucss.elementary.tnwn.controller.base"))
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }
    //endregion

    //region cms接口
    private ApiInfo cmsInfo() {
        return new ApiInfoBuilder().title("ELMT.tnwn").description("CMS")
                .termsOfServiceUrl(SERVICE_URL)
                .version("1.0").build();
    }

    @Bean
    public Docket cmsRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(cmsInfo()).groupName("CMS").select()
                .apis(RequestHandlerSelectors.basePackage("com.ucss.elementary.tnwn.controller.cms"))
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }
    //endregion

}
