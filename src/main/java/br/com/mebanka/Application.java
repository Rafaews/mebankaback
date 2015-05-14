package br.com.mebanka;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");
		
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		
	}
	private AnnotationConfigWebApplicationContext buildApplicationContext() {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("br.com.mebanka.configurations");
		return webApplicationContext;
	}

}
