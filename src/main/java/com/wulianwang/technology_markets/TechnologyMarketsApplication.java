package com.wulianwang.technology_markets;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//安装 lombok 插件，解决IDE找不到log变量报错的问题
@Slf4j
@Controller
//在这里控制开启 Swagger
@EnableSwagger2
@MapperScan("com.wulianwang.technology_markets.DataBaseController")//指定要扫描Mapper类的包的路径
@SpringBootApplication
public class TechnologyMarketsApplication {
    @RequestMapping(value = "/")
    public String printWelcome() {
        log.info("●访问后台根目录，展示首页●");
        return "index";
    }

    /*打包成war时重写方法（需继承自SpringBootServletInitializer类），打包成jar时不用重写*/
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(RenshenBaobaoBackgroundApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(TechnologyMarketsApplication.class, args);

        log.info("●=>高校成果展示与交易网站启动...●");
    }

}
