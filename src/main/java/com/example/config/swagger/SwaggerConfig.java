package com.example.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket swaggerUserApi1() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("user-api-v1")
				.select()
				.paths(PathSelectors.regex("/api/v1.*"))
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0.0").title("User API V1").description("Documentation User API v1")
				.build());
		// @formatter:on
	}

	@Bean
	public Docket swaggerUserApi2() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("user-api-v2")
				.select()
				.paths(PathSelectors.regex("/api/v2.*"))
				.build()
				.apiInfo(new ApiInfoBuilder().version("2.0.0").title("User API V2").description("Documentation User API v2")
				.build());
		// @formatter:on
	}
}