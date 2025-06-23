package ru.pet.nzcheinenm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.servlet.Filter;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import org.apache.catalina.servlets.DefaultServlet;
import org.ocpsoft.rewrite.servlet.DispatcherType;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import java.util.EnumSet;

@ComponentScan({"ru.pet.nzcheinenm"})
@OpenAPIDefinition
@SpringBootApplication
public class NzcheinenmApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(NzcheinenmApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        Servlet servlet = new DefaultServlet();
        return new ServletRegistrationBean(servlet, "*.jsf");
    }

    @Bean
    public FilterRegistrationBean rewriteFilter() {
        FilterRegistrationBean rwFilter = new FilterRegistrationBean();
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
}
