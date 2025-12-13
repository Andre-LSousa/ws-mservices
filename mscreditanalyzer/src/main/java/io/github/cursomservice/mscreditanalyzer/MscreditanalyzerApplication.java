package io.github.cursomservice.mscreditanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscreditanalyzerApplication {
	public static void main(String[] args) {
        SpringApplication.run(MscreditanalyzerApplication.class, args);
	}

}
