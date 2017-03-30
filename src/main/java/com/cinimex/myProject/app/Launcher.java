package com.cinimex.myProject.app;

import com.cinimex.myProject.MainConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(MainConf.class);
    }
}
