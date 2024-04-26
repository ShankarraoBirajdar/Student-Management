package com.shankar.sm.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shankar.sm")
public class StudentAppConfig implements WebMvcConfigurer {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		logger.info("Inside StudentAppConfig->configViewResolver()");
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/View/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/studentsdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/URL_TO_REACH_RESOURCES_FOLDER/**").addResourceLocations("/resources/");
	}
	

}
