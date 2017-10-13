package org.gestion.init;

import org.gestion.config.DataSourceMySQLConfig;
import org.gestion.config.JpaConfig;
import org.gestion.config.ServicesConfig;
import org.gestion.web.controller.interceptor.ValidationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@CrossOrigin
@Configuration
@EnableWebMvc
@Import({ServicesConfig.class, JpaConfig.class, DataSourceMySQLConfig.class})
public class WebAppConfig {

	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	public ValidationInterceptor getValidationInterceptor(){
		return new ValidationInterceptor();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
						.allowedHeaders("Content-Type");
			}
			
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(getValidationInterceptor()).excludePathPatterns("/login").excludePathPatterns("/user/create"); //à changer, page de login
			}
		};
	}
}
