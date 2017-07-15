package com.configuration;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by woongs on 2017. 7. 14..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com" })
public class WebConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public HandlebarsViewResolver handlebarsViewResolver() {
		HandlebarsViewResolver handlebarsViewResolver = new HandlebarsViewResolver();
		handlebarsViewResolver.setPrefix("/WEB-INF/views/");
		handlebarsViewResolver.setOrder(0);
		handlebarsViewResolver.setSuffix(".hbs");

		return handlebarsViewResolver;
	}
}
