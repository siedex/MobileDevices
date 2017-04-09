/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.configuration;

import org.springframework.web.*;
import org.springframework.web.servlet.*;
import org.springframework.web.context.support.*;

import javax.servlet.*;
/**
 *
 * @author siede
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);
        Object obj = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic servlet = container.addServlet(
                "myname", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");}
}

