package br.edu.unoesc.componentes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

@HtmlImport("frontend://styles/tema.html")
public class AdicionarSafraForm {
	
	public Div formulario() {
		Div d = new Div();
		
		FormLayout form = new FormLayout();
		
		TextField descricao = new TextField();
		descricao.setPlaceholder("");
		descricao.setAutofocus(true);
		descricao.setValueChangeMode(ValueChangeMode.EAGER);
		
		ComboBox<String> tipo = new ComboBox<>();
		tipo.setPlaceholder("O que foi plantado");
		tipo.setItems();

		TextField tamanhoPlantacao = new TextField();
		tamanhoPlantacao.setPlaceholder("Hectares");
		tamanhoPlantacao.setValueChangeMode(ValueChangeMode.EAGER);
		
		TextField tipoSemente = new TextField();
		tipoSemente.setPlaceholder("Identificação da semente (marca)");
		tipoSemente.setValueChangeMode(ValueChangeMode.EAGER);
		
		TextField observacao = new TextField();
		tipoSemente.setPlaceholder("Informações extras");
		observacao.setValueChangeMode(ValueChangeMode.EAGER);
		
		
		Button salvar = new Button("Salvar");
		salvar.setThemeName("primary");
		Button limpar = new Button("Limpar todos os campos");
		limpar.setThemeName("secondary");

		// adicionando descricaos nos campos do formulario
		form.addFormItem(descricao, "Descricao: ");
		form.addFormItem(tipo, "Tipo: ");		
		form.addFormItem(tamanhoPlantacao, "Tamanho da plantação: ");
		form.addFormItem(tipoSemente, "Semente");
		form.addFormItem(observacao, "Observação: ");
		
		// campos required
		descricao.setRequiredIndicatorVisible(true);
		tipo.setRequiredIndicatorVisible(true);
		tamanhoPlantacao.setRequiredIndicatorVisible(true);
		tipoSemente.setRequiredIndicatorVisible(true);
		observacao.setRequiredIndicatorVisible(true);
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(salvar, limpar);
		

		salvar.addClickListener(e ->{

		});
		
		limpar.addClickListener(event -> {
			descricao.clear();
			tipo.clear();
			tamanhoPlantacao.clear();
			tipoSemente.clear();
			observacao.clear();
		});
		
		d.add(form, actions);
		return d;

	}

}
