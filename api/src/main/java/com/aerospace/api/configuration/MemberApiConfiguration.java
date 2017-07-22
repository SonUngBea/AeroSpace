package com.aerospace.api.configuration;

import com.aerospace.api.controller.ApiController;
import com.aerospace.api.interceptor.ApiPermissionCheckInterceptor;
import com.aerospace.domain.configuration.RootApplicationContextConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by coupang on 2017. 7. 19..
 */
@Configuration
@Import({RootApplicationContextConfig.class})
@ComponentScan(
	basePackageClasses = { ApiController.class}
)
public class MemberApiConfiguration extends WebMvcConfigurerAdapter {
	public MemberApiConfiguration() {
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.apiPermissionCheckInterceptor());
	}

	@Bean
	public ApiPermissionCheckInterceptor apiPermissionCheckInterceptor() {
		return new ApiPermissionCheckInterceptor();
	}
}
