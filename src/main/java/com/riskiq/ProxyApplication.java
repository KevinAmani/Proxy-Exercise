package com.riskiq;

import com.riskiq.config.ProxyConfig;
import com.riskiq.repository.OwnerRepository;
import com.riskiq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.common.io.Resources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProxyApplication {

	private ProxyConfig proxyConfig;

	@Autowired
	public void setProxyConfig(ProxyConfig proxyConfig) {
		this.proxyConfig = proxyConfig;
	}

	@Bean
	UserRepository userRepository() {
		return new UserRepository(Resources.getResource(proxyConfig.getUserFile()));
	}

	@Bean
	OwnerRepository ownerRepository() {
		return new OwnerRepository(Resources.getResource(proxyConfig.getUserFile()));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
}
