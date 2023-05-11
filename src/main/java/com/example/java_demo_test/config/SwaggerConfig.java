//package com.example.java_demo_test.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//
//
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//
//
//@Configuration       //��spring boot ���� class ���t�m��  
//@EnableOpenApi       //�z�L������ �ӱҥ�swagger
//@EnableWebMvc        //�ޤJ DelegatingWebMvcConfiguration �t�m�� �ӱҥ�springMvc
//public class SwaggerConfig {
//	
//	private ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
//			.title("java_demo_test Restful API")//���D
//			.description("java_demo_test API")//����
////			.termsOfServiceUrl("urn:tos")//
////			.contact(new Contact("DEFAULT", null, null))//�p���H
////			.license("Apache 2.0")//
////			.version("v3")//����
////			.licenseUrl("https://www.apache.org/licence/LICENCE-2.0.txt")//
//			.build();
//	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(DEFAULT_API_INFO)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.example.java_demo_test.controller"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	
//	
//	
//		
//	
//	
//
//}
