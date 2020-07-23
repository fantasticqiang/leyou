package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by lq on 2019/9/3.
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.leyou.common"
})
@EntityScan("com.leyou.common.pojo")
@EnableJpaRepositories(basePackages = {
        "com.leyou.common.query"
})
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
