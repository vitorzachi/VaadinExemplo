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

import br.edu.unoesc.idioma.DataPickerPt;
import br.edu.unoesc.model.Safra;


@HtmlImport("frontend://styles/tema.html")
public class FinalizarSafraForm {

	private Div d = new Div();
	private FormLayout form = new FormLayout();
	private ComboBox<Safra> safra =  new ComboBox<Safra>();
	private DatePicker dataColheita = new DatePicker();
	private TextField qtdColhida = new TextField();
	private TextField valorVenda = new TextField();
	
	private Button finalizar = new Button("Finalizar");
	private Button limpar = new Button("Limpar");
	
	// construindo e retornando um Div
	public Div formulario() {
		criar();
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(finalizar);
		
		finalizar.addClickListener(e ->{

		});
		
		limpar.addClickListener(e ->{
			limpar();
		});


		d.add(form, actions);
		
		return d;
	}
	
	// criando o formulário
	private void criar() {
		safra.setPlaceholder("safra");
		safra.setItems();

		dataColheita.setPlaceholder("Data do procedimento");
		dataColheita.setI18n(new DataPickerPt().dataPt());
		
		qtdColhida.setPlaceholder("em sacas");
		qtdColhida.setValueChangeMode(ValueChangeMode.EAGER);
		valorVenda.setPlaceholder("por sacas");
		valorVenda.setValueChangeMode(ValueChangeMode.EAGER);
		
		finalizar.setThemeName("primary");
		limpar.setThemeName("secondary");

		descricaoForm();
		camposRequeridos();
		mensagemsErro();
	}
	
	// adicionando descricaos nos campos do formulario
	private void descricaoForm() {
		Label lb = new Label();
		form.addFormItem(safra, "Selecione a safra:");
		form.add(lb);
		form.addFormItem(dataColheita, "Data da colheita:");
		form.addFormItem(qtdColhida, "Quantidade colhida:");
		form.addFormItem(valorVenda, "Valor de venda:");
	}
	
	// mesagens de erro
	private void mensagemsErro() {
		safra.setErrorMessage("Safra é obrigatória");
		dataColheita.setErrorMessage("Escolha uma data");
		qtdColhida.setErrorMessage("Indique a quantidade colhida");
		valorVenda.setErrorMessage("Indique o valor de venda");
	}
	
	// campos obrigatorios
	private void camposRequeridos() {
		safra.setRequiredIndicatorVisible(true);
		dataColheita.setRequiredIndicatorVisible(true);
		qtdColhida.setRequiredIndicatorVisible(true);
		valorVenda.setRequiredIndicatorVisible(true);
	}

	// limpar campos
	private void limpar() {
		safra.clear();
		dataColheita.clear();
		qtdColhida.clear();
		valorVenda.clear();
	}


}
