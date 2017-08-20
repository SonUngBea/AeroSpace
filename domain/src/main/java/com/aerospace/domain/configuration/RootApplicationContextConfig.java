package com.aerospace.domain.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Configuration
@ComponentScan(basePackages = "com.aerospace.domain")
@EnableTransactionManagement
@EnableJpaRepositories("com.aerospace.domain")
public class RootApplicationContextConfig {

	private static final String LOCAL_MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/ojtproject";
	private static final String AWS_MYSQL_URL = "jdbc:mysql://13.124.150.31:3306/ojtproject?zeroDateTimeBehavior=convertToNull";
	private static final String PERSISTENCE_UNIT_NAME = "arnold";

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUsername("ojt_venice");
		dataSource.setPassword("venice");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(LOCAL_MYSQL_URL);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(this.dataSource());
		emf.setPackagesToScan("com.aerospace.domain");
		emf.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		PlatformTransactionManager bean = new JpaTransactionManager(emf);
		return bean;
	}

}