package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer{

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

		// 排除配置
		addInterceptor.excludePathPatterns("/error/404","/v2/api-docs", "/swagger-resources", "/configuration/security",
				"/swagger-ui.html", "/swagger-resources/configuration/ui");
		addInterceptor.excludePathPatterns("/","/v1/auth/login",
				"/*.html",
				"/favicon.ico",
				"/**/*.html",
				"/**/*.css",
				"/**/*.js",
				"/**/*.jpg",
				"/**/*.png"
		      );

		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}

}
