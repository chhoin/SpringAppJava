package com.spring.app.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class WebBootstrap implements WebApplicationInitializer{

	public void onStartup(ServletContext context) throws ServletException {
		
		// 1.Create AnnotationConfigWebApplicationContext Object
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		
		// 2.Register the Configuration Class
		root.register(WebConfiguration.class);
		
		// 3.Create DispatacherServelt, add it to container,
		// and assign it to the servletRegisteration
		ServletRegistration.Dynamic dispatcherServlet = context.addServlet("springDispatcher", new DispatcherServlet(root));
		
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
