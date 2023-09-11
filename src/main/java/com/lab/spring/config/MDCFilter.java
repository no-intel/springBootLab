//package com.lab.spring.config;
//
//import jakarta.servlet.*;
//import org.slf4j.MDC;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class MDCFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        final UUID uuid = UUID.randomUUID();
//        MDC.put("request_id", uuid.toString());
//        chain.doFilter(request, response);
//        MDC.clear();
//    }
//}
