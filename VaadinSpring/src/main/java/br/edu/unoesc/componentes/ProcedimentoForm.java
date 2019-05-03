package br.edu.unoesc.componentes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import br.edu.unoesc.model.Safra;

@HtmlImport("frontend://styles/tema.html")
public class ProcedimentoForm {

	private Div d = new Div();
	private FormLayout form = new FormLayout();
	private ComboBox<Safra> safra = new ComboBox<>();
	private TextField descricao = new TextField();
	private TextField tipo = new TextField();
	private DatePicker dataP = new DatePicker();
	private TextField quantidade = new TextField();
	private TextField valor = new TextField();
	private TextField obs = new TextField();
	
	private Button salvar = new Button("Salvar");
	private Button limpar = new Button("Limpar todos os campos");

	public Div formulario() {
		
		criar();

		HorizontalLayout actions = new HorizontalLayout();
		actions.add(salvar, limpar);
		
		salvar.addClickListener(e ->{

		});
		
		limpar.addClickListener(event -> {
			limpar();
		});

		d.add(form, actions);
		
		return d;
	}
	
	
	private void criar() {
		
		safra.setPlaceholder("Selecione a safra");
		safra.setItems();
		
		descricao.setPlaceholder("");
		descricao.setAutofocus(true);
		descricao.setValueChangeMode(ValueChangeMode.EAGER);
		
		tipo.setPlaceholder("Qual a origem do procedimento");
		tipo.setValueChangeMode(ValueChangeMode.EAGER);
		
		dataP.setPlaceholder("Data do procedimento");
		
		quantidade.setPlaceholder("Qtd de produto aplicado");
		quantidade.setValueChangeMode(ValueChangeMode.EAGER);
		
		valor.setPlaceholder("vl gasto no procedimento");
		valor.setValueChangeMode(ValueChangeMode.EAGER);
		
		obs.setPlaceholder("Observação complementar");
		obs.setValueChangeMode(ValueChangeMode.EAGER);

		salvar.setThemeName("primary");
		limpar.setThemeName("secondary");
		
		criarFormulario();
		requeridos();
		mensagemsErro();
	}
	
	private void criarFormulario() {
		Label lb = new Label();
		form.addFormItem(safra, "Safra: ");
		form.add(lb);
		form.addFormItem(descricao, "Descrição: ");
		form.addFormItem(tipo, "Tipo");
		form.addFormItem(dataP, "Data: ");
		form.addFormItem(quantidade, "Quantidade: ");
		form.addFormItem(valor, "Valor: ");
		form.addFormItem(obs, "Observação: ");
	}
	
	private void limpar() {
		safra.clear();
		descricao.clear();
		tipo.clear();
		dataP.clear();
		quantidade.clear();
		valor.clear();
		obs.clear();
	}
	
	private void requeridos() {
		safra.setRequiredIndicatorVisible(true);
		descricao.isRequired();
		tipo.isRequired();
		dataP.isRequired();
		quantidade.isRequired();
		valor.isRequired();
	}
	
	private void mensagemsErro() {
		safra.setErrorMessage("Safra é obrigatória");
		descricao.setErrorMessage("Adicione uma descrição");
		tipo.setErrorMessage("Adicione um tipo");
		dataP.setErrorMessage("Escolha uma data");
		quantidade.setErrorMessage("Quantidade é obrigatória para calculos futuros");
		valor.setErrorMessage("Valor é obrigatório para calculos futuros");
	}
	
	
}
