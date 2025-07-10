package com.odine.marketplace.odine_marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class OdineMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdineMarketplaceApplication.class, args);
	}

}
