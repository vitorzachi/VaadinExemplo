package br.edu.unoesc.views;

import org.springframework.boot.SpringBootConfiguration;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Gestão de Safra")
@Route("")
@HtmlImport("frontend://styles/tema.html")
public class Login extends VerticalLayout{

	private static final long serialVersionUID = -2857064336200457491L;
	
	public Button botao;;
	
	public Login() {
		
		LoginForm login = new LoginForm();
		login.setI18n(createPortugueseI18n());

		login.addLoginListener( e -> {
			login.getUI().ifPresent(ui -> ui.navigate("menu"));
		});
		
		login.addForgotPasswordListener(e ->{
			
		});
		
		botao = new Button();
		botao.setThemeName("secondary");
		setAlignItems(Alignment.CENTER);
		botao.setIcon(new Icon(VaadinIcon.SIGN_IN));
		botao.setText("Cadastrar-se");
		add(login, botao);
		
		botao.addClickListener(e ->{
        	botao.getUI().ifPresent(ui -> ui.navigate("cadastroUsuario"));
		});
		
	}

	private LoginI18n createPortugueseI18n() {
		final LoginI18n i18n = LoginI18n.createDefault();

	    i18n.setHeader(new LoginI18n.Header());
	    i18n.getHeader().setTitle("Gestão de Safra");
	    i18n.getHeader().setDescription("Faça a gestão das safras de sua lavoura");
	    i18n.getForm().setUsername("Usuário");
	    i18n.getForm().setTitle("Acesse:");
	    i18n.getForm().setSubmit("Entrar");
	    i18n.getForm().setPassword("Senha");
	    i18n.getForm().setForgotPassword("Esqueci minha senha");
	    i18n.getErrorMessage().setTitle("Usuário/senha inválidos");
	    i18n.getErrorMessage()
	        .setMessage("Confira seu usuário e senha e tente novamente.");
	    i18n.setAdditionalInformation(
	        "Caso não tenha cadastro crie um cadastrar-se");
	    return i18n;
	}

}
