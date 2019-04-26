package br.edu.unoesc.componentes;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import br.edu.unoesc.dao.UsuarioDao;
import br.edu.unoesc.model.Usuario;


@HtmlImport("frontend://styles/tema.html")
public class CadastroUsuarioForm {
	
	@Autowired
	private UsuarioDao dao; 

	public Div formulario() {
		
		Div d = new Div();
		
		FormLayout form = new FormLayout();
		
		TextField nome = new TextField();
		nome.setPlaceholder("Primeiro nome");
		nome.setAutofocus(true);
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		TextField sobrenome = new TextField();
		sobrenome.setPlaceholder("Segundo nome");
		sobrenome.setValueChangeMode(ValueChangeMode.EAGER);
		EmailField email = new EmailField();
		email.setPlaceholder("nome@exemplo.com");
		email.setValueChangeMode(ValueChangeMode.EAGER);
		PasswordField senha = new PasswordField();
		senha.setPlaceholder("Senha de acesso");
		senha.setValueChangeMode(ValueChangeMode.EAGER);
		PasswordField confirmacaoSenha = new PasswordField();
		confirmacaoSenha.setPlaceholder("Confirmação da senha");
		confirmacaoSenha.setValueChangeMode(ValueChangeMode.EAGER);
		DatePicker nascimento = new DatePicker();
		nascimento.setPlaceholder("Nascimento");
		
		Button salvar = new Button("Salvar");
		salvar.setThemeName("primary");
		Button limpar = new Button("Limpar todos os campos");
		limpar.setThemeName("secondary");

		// adicionando nomes nos campos do formulario
		form.addFormItem(nome, "Nome: ");
		form.addFormItem(sobrenome, "Sobrenome: ");		
		form.addFormItem(email, "E-mail: ");
		form.addFormItem(nascimento, "Data de Nascimento");
		form.addFormItem(senha, "Senha: ");
		form.addFormItem(confirmacaoSenha, "Confirme sua senha: ");
		
		// campos required
		nome.setRequiredIndicatorVisible(true);
		sobrenome.setRequiredIndicatorVisible(true);
		email.setRequiredIndicatorVisible(true);
		senha.setRequiredIndicatorVisible(true);
		confirmacaoSenha.setRequiredIndicatorVisible(true);
		nascimento.setRequiredIndicatorVisible(true);
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(salvar, limpar);
		
		salvar.addClickListener(e ->{
			if(senha.isEmpty() || senha.getValue().contentEquals(confirmacaoSenha.getValue())) {
				Usuario usuario = new Usuario();
				usuario.setNome(nome.getValue());
				usuario.setSobrenome(sobrenome.getValue());
				usuario.setEmail(email.getValue());
				usuario.setSenha(senha.getValue());
				usuario.setDataNascimento(Date.from(nascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				dao.inserir(usuario);
				
				salvar.getUI().ifPresent(ui -> ui.navigate(""));
				
			}else {
				Dialog dialog = new DialogMensagem().erroForm();
				dialog.open();
			}
		});
		
		limpar.addClickListener(event -> {
			nome.clear();
			sobrenome.clear();
			email.clear();
			senha.clear();
			confirmacaoSenha.clear();
			nascimento.clear();
		});
		
		d.add(form, actions);
		return d;
	}
}
