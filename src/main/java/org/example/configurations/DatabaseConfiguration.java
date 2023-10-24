package org.example.configurations;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/*
    Database configuration with profiles QA and DEV.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
    private static final String QA_URL = "jdbc:h2:mem:QA";
    private static final String DEV_URL = "jdbc:h2:mem:DEV";

    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(DEV_URL);
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sa");

        return dataSourceBuilder.build();
    }

    @Bean
    @Profile("qa")
    public DataSource dataSourceTest() {
        var dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(QA_URL);
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sa");

        return dataSourceBuilder.build();
    }
}
