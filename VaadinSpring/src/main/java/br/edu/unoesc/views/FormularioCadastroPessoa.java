package br.edu.unoesc.views;

import org.springframework.boot.SpringBootConfiguration;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import br.edu.unoesc.dao.PessoasJDBC;
import br.edu.unoesc.model.Pessoa;

@SpringBootConfiguration
@Route("")
@HtmlImport("styles/tema.html")
public class FormularioCadastroPessoa extends VerticalLayout {

	private static final long serialVersionUID = 5424359762979917616L;

	FormularioCadastroPessoa(){
		FormLayout formBinder = new FormLayout();
		Binder<Pessoa> binder = new Binder<>();
		
		// The object that will be edited
		Pessoa editandoPropriedade= new Pessoa();

		// Create the fields
		TextField nome = new TextField();
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		
		Label infoLabel = new Label();
		NativeButton save = new NativeButton("Salvar");
		NativeButton reset = new NativeButton("Limpar");

		formBinder.addFormItem(nome, "nome");
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(save, reset);
		
		add(formBinder, actions);
		
		save.addClickListener(e ->{
			PessoasJDBC jdbcPessoa = new PessoasJDBC();
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome.getValue());
			jdbcPessoa.inserir(pessoa);
		});
		
		reset.addClickListener(e ->{
			nome.clear();
		});

	}
	
	
}
