package br.edu.unoesc.VaadinSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.server.PWA;

@PWA(name = "Minha aplicação Vaadin",iconPath = "icons/icon.png", shortName = "MyPWA") // não necessaria // 
@SpringBootApplication
public class VaadinSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VaadinSpringApplication.class, args);
	}

}
