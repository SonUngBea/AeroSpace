package com.aerospace.domain.configuration;

import com.aerospace.domain.repository.Domain;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Configuration
@ComponentScan(basePackages = "com.aerospace.domain")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.aerospace.domain")
public class RootApplicationContextConfig {

	@Autowired
	private ResourcePatternResolver resourcePatternResolver;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUsername("ojt_venice");
		dataSource.setPassword("venice");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://13.124.150.31:3306/ojtproject?zeroDateTimeBehavior=convertToNull");

		return dataSource;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPackagesToScan("com.aerospace.domain");

		return emf;
	}

	@Bean
	@DependsOn(value = "entityManagerFactory")
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager bean = new JpaTransactionManager(emf);

		return bean;
	}
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:com/domain/repository/*.xml"));
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		return sqlSessionFactoryBean;
//	}
//
//	@Bean
//	public PlatformTransactionManager platformTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

}