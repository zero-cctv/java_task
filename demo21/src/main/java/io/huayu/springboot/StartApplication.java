package io.huayu.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.huayu.springboot.framework.util.PrintApplicationInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author weiqian
 * @since 2020-03-23
 */
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableAdminServer
@MapperScan({"io.huayu.springboot.**.mapper" })
@ServletComponentScan

@SpringBootApplication(scanBasePackages = {"io.huayu.springboot","com.example"})
public class StartApplication {

    public static void main(String[] args) {
        // 启动
        ConfigurableApplicationContext context = SpringApplication.run(StartApplication.class, args);
        // 打印项目信息
        PrintApplicationInfo.print(context);
    }

}
