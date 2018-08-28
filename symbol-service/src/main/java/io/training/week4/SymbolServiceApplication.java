package io.training.week4;

import io.training.week4.repository.SymbolRepository;
import io.training.week4.service.SymbolService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableDiscoveryClient
public class SymbolServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SymbolServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner addSymbols(SymbolRepository symbolRepository, SymbolService symbolService) {
    return args -> symbolRepository.saveAll(symbolService.populate());
  }
}
