package com.luca.pacioli.web.app;

import com.luca.pacioli.web.app.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFramework5Application implements CommandLineRunner {

	@Autowired
	@Qualifier("uploadFileServiceImpl")
	private UploadFileService uploadFileService;



	public static void main(String[] args) {
		SpringApplication.run(SpringFramework5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
	}

}
