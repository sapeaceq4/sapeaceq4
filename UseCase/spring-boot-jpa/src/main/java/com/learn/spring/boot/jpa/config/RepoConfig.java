package com.learn.spring.boot.jpa.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.learn.spring.boot.jpa.model"})
@EnableJpaRepositories(basePackages = {"com.learn.spring.boot.jpa.repo"})
@EnableTransactionManagement
public class RepoConfig {

}
