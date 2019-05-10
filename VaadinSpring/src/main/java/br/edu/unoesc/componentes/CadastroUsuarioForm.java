package br.edu.unoesc.componentes;

import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
import br.edu.unoesc.idioma.DataPickerPt;
import br.edu.unoesc.model.Usuario;

@HtmlImport("frontend://styles/tema.html")
public class CadastroUsuarioForm {
	
	@Autowired
	private UsuarioDao dao; 

	private Div d = new Div();
	private FormLayout form = new FormLayout();
	private TextField nome = new TextField();
	private TextField sobrenome = new TextField();
	private EmailField email = new EmailField();
	private PasswordField senha = new PasswordField();
	private PasswordField confirmacaoSenha = new PasswordField();
	private DatePicker nascimento = new DatePicker();
	private Button salvar = new Button("Salvar");
	private Button limpar = new Button("Limpar todos os campos");


	public Div formulario() {
		
		criandoEstrutura();
		criarFormulario();
		camposObrigatorios();
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.setSpacing(true);
		actions.add(salvar, limpar);
		
		salvar.addClickListener(e ->{
			if(senha.isEmpty() || senha.getValue().contentEquals(confirmacaoSenha.getValue())) {
				Usuario usuario = new Usuario();
				usuario.setNome(nome.getValue());
				usuario.setSobrenome(sobrenome.getValue());
				usuario.setEmail(email.getValue());
				usuario.setSenha(senha.getValue());
				usuario.setDataNascimento(Date.from(nascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				System.out.println(usuario.toString());
				
				this.dao.save(usuario);
				
				
				salvar.getUI().ifPresent(ui -> ui.navigate(""));
				
			}else {
				Dialog dialog = new DialogMensagem().erroForm();
				dialog.open();
			}
		});
		
		limpar.addClickListener(event -> {
			limpar();
		});
		
		d.add(form, actions);
		return d;
	}
	
	private void limpar() {
		nome.clear();
		sobrenome.clear();
		email.clear();
		senha.clear();
		confirmacaoSenha.clear();
		nascimento.clear();
	}
	
	private void camposObrigatorios() {
		// campos required
		nome.setRequiredIndicatorVisible(true);
		sobrenome.setRequiredIndicatorVisible(true);
		email.setRequiredIndicatorVisible(true);
		senha.setRequiredIndicatorVisible(true);
		confirmacaoSenha.setRequiredIndicatorVisible(true);
		nascimento.setRequiredIndicatorVisible(true);
	}
	
	private void criandoEstrutura() {
		nome.setPlaceholder("Primeiro nome");
		nome.setAutofocus(true);
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		sobrenome.setPlaceholder("Segundo nome");
		sobrenome.setValueChangeMode(ValueChangeMode.EAGER);
		email.setPlaceholder("nome@exemplo.com");
		email.setValueChangeMode(ValueChangeMode.EAGER);
		senha.setPlaceholder("Senha de acesso");
		senha.setValueChangeMode(ValueChangeMode.EAGER);
		confirmacaoSenha.setPlaceholder("Confirmação da senha");
		confirmacaoSenha.setValueChangeMode(ValueChangeMode.EAGER);
		nascimento.setPlaceholder("Nascimento");
		nascimento.setLocale(new Locale("br"));
		
		nascimento.setI18n(new DataPickerPt().dataPt());
		        
		salvar.setThemeName("primary");
		limpar.setThemeName("secondary");
	}
	
	private void criarFormulario() {

		// adicionando nomes nos campos do formulario
		form.addFormItem(nome, "Nome: ");
		form.addFormItem(sobrenome, "Sobrenome: ");		
		form.addFormItem(email, "E-mail: ");
		form.addFormItem(nascimento, "Data de Nascimento");
		form.addFormItem(senha, "Senha: ");
		form.addFormItem(confirmacaoSenha, "Confirme sua senha: ");
	}
}
