package com.bos.payroll;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.bos.payroll.domain"})
@EnableJpaRepositories(basePackages = {"com.bos.payroll.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
