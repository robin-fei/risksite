package com.wpt.risk.exec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;

@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "com.wpt.risk"
})
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableWebMvc
public class RiskuiApplication {

    @Autowired
    private MultipartConfigElement multipartConfig;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RiskuiApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.setMultipartConfig(multipartConfig);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return registration;
    }
}
