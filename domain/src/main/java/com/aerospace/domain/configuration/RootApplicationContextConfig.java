package com.aerospace.domain.configuration;

import com.aerospace.domain.application.DomainApplications;
import com.aerospace.domain.repository.Domain;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by coupang on 2017. 7. 15..
 */
@Configuration
@ComponentScan(basePackageClasses = { Domain.class, DomainApplications.class })
@MapperScan(basePackageClasses = Domain.class)
public class RootApplicationContextConfig {

	@Autowired
	private ResourcePatternResolver resourcePatternResolver;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setUsername("ojt_venice");
		dataSource.setPassword("venice");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ojtproject");

		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:com/domain/repository/*.xml"));
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean;
	}

//	@Bean
//	public PlatformTransactionManager platformTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

}