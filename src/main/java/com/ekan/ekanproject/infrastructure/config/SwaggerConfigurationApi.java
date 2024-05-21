package com.ekan.ekanproject.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigurationApi {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EKAN")
                        .version("1.0")
                        .description("Beneficiaries Api")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().name("Jean Fernandes").url("http://www.ekan.com.br").email("user@ekan.com.br"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("External documentation")
                        .url("#"));
    }

    @Bean
    public GroupedOpenApi beneficiaryApi() {
        return GroupedOpenApi.builder()
                .group("beneficiary-api")
                .pathsToMatch("/v1/api/beneficiary/**")
                .build();
    }

    @Bean
    public GroupedOpenApi documentApi() {
        return GroupedOpenApi.builder()
                .group("document-api")
                .pathsToMatch("/v1/api/document/**")
                .build();
    }

    @Bean
    public GroupedOpenApi documentTypeApi() {
        return GroupedOpenApi.builder()
                .group("document-type-api")
                .pathsToMatch("/v1/api/document-type/**")
                .build();
    }
}
