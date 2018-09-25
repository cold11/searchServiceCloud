package com.cold.searchService.conf;

import com.cold.searchService.server.ISearchService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.xml.ws.Endpoint;


/**
 * @Auther: ohj
 * @Date: 2018/9/25 10:46
 * @Description:
 */
@Configuration
public class CxfConfig {
//    @Autowired
//    private Bus bus;
    @Autowired
    private ISearchService searchService;

//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
//    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
        bean.setLoadOnStartup(0);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),searchService);
        endpoint.publish("/searchService");//接口发布在 /services/searchService 目录下
        return endpoint;
    }
}