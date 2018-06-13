package com.javaliu;

import com.javaliu.modules.i18n.AcceptHeaderLocaleTzCompositeResolver;
import com.javaliu.modules.i18n.TimeZoneInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        //return new AcceptHeaderLocaleTzCompositeResolver(sessionLocaleResolver);
        return new SessionLocaleResolver();
    }

    @Bean
    public WebMvcConfigurer configurer () {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors (InterceptorRegistry registry) {
                TimeZoneInterceptor interceptor = new TimeZoneInterceptor();
                InterceptorRegistration i = registry.addInterceptor(interceptor);
                i.excludePathPatterns("/timeZone/tzHandler", "/timeZone/tzValueHandler");
            }
        };
    }
}
