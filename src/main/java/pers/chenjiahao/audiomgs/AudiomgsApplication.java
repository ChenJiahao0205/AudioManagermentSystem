package pers.chenjiahao.audiomgs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("pers.chenjiahao.audiomgs.mapper")
@SpringBootApplication
public class AudiomgsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AudiomgsApplication.class, args);
    }

}
