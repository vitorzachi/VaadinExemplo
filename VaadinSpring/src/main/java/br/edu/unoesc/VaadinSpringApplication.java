package br.edu.unoesc;

import com.vaadin.flow.spring.SpringServlet;
import com.vaadin.flow.spring.annotation.EnableVaadin;

import br.edu.unoesc.dao.UsuarioDao;
import br.edu.unoesc.model.Safra;
import br.edu.unoesc.model.Usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@EnableVaadin
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class VaadinSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VaadinSpringApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

		servletContext.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic registration = servletContext
				.addServlet("dispatcher", new SpringServlet(context, true));
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");
	}
	
	
		

}
