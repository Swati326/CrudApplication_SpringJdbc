package org.swati.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"org.swati.service","org.swati.repository"})
public class Config {

	
	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("swati");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo1");
		return dataSource;
				
	}
	@Bean(name="template")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template=new JdbcTemplate(getDataSource());
		return template;
	}
}
