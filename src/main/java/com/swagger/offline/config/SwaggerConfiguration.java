package com.swagger.offline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @version V1.0
 * @Title: Swagger配置类
 * @ClassName: com.newcapec.config.swagger.Swagger2Configuration.java
 * @Description:
 * @Copyright 2016-2017  - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-12-11 8:20
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                //要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("com.swagger.offline.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @Title: 构建API基本信息
     * @methodName: buildApiInfo
     * @Description:
     * @author: 王延飞
     * @date: 2017-12-11  8:44
     */
    private ApiInfo buildApiInfo() {

        return new ApiInfoBuilder()
                .title("用户信息API文档")
                .description("这里除了查看接口功能外，还提供了调试测试功能")
                .contact("王延飞")
                .version("1.0")
                .build();

    }
}