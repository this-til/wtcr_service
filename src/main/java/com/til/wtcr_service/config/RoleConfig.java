package com.til.wtcr_service.config;

import graphql.kickstart.tools.boot.SchemaDirective;
import graphql.language.Argument;
import graphql.language.Value;
import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Objects;

@Configuration
public class RoleConfig implements WebMvcConfigurer {
/*
    @Bean
    public SchemaDirective customDirective() {
        return new SchemaDirective("role", new SchemaDirectiveWiring() {

        });
    }*/
}
