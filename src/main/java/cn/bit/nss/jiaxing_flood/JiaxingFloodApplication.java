package cn.bit.nss.jiaxing_flood;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bit.nss.jiaxing_flood.mapper")
public class JiaxingFloodApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaxingFloodApplication.class, args);
    }

}
