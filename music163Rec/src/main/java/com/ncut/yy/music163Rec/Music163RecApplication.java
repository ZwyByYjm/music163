package com.ncut.yy.music163Rec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
public class Music163RecApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Music163RecApplication.class, args);
	}

}

