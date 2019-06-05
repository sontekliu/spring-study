package com.javaliu;

import com.javaliu.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@EnableHelloWorld
public class App {
    public static void main(String[] args) {
        // SpringApplication.run(App.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .web(WebApplicationType.NONE)
                .sources(App.class)
                .run(args);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        //return new AcceptHeaderLocaleTzCompositeResolver(sessionLocaleResolver);
//        return new SessionLocaleResolver();
//    }
//
//    @Bean
//    public WebMvcConfigurer configurer () {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addInterceptors (InterceptorRegistry registry) {
//                TimeZoneInterceptor interceptor = new TimeZoneInterceptor();
//                InterceptorRegistration i = registry.addInterceptor(interceptor);
//                i.excludePathPatterns("/timeZone/tzHandler", "/timeZone/tzValueHandler");
//            }
//        };
//    }

}
