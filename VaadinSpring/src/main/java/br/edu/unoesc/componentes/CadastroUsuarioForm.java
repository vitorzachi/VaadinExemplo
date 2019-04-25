package br.edu.unoesc.componentes;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;


@HtmlImport("frontend://styles/tema.html")
public class CadastroUsuarioForm {

	public Div formulario() {
		
		Div d = new Div();
		
		FormLayout form = new FormLayout();
		
		TextField nome = new TextField();
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		TextField sobrenome = new TextField();
		sobrenome.setValueChangeMode(ValueChangeMode.EAGER);
		TextField email = new TextField();
		email.setValueChangeMode(ValueChangeMode.EAGER);
		PasswordField senha = new PasswordField();
		senha.setValueChangeMode(ValueChangeMode.EAGER);
		PasswordField confirmacaoSenha = new PasswordField();
		confirmacaoSenha.setValueChangeMode(ValueChangeMode.EAGER);
		DatePicker nascimento = new DatePicker();
		
		NativeButton salvar = new NativeButton("Salvar");
		NativeButton limpar = new NativeButton("Limpar todos os campos");

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
