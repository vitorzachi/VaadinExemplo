package br.edu.unoesc.componentes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import br.edu.unoesc.model.TipoSafra;

@HtmlImport("frontend://styles/tema.html")
public class AdicionarSafraForm {

	private Div d = new Div();
	private FormLayout form = new FormLayout();
	private TextField descricao = new TextField();
	private ComboBox<TipoSafra> tipo = new ComboBox<>();
	private TextField tamanhoPlantacao = new TextField();
	private TextField tipoSemente = new TextField();
	private TextArea observacao = new TextArea();
	private Button salvar = new Button("Salvar");
	private Button limpar = new Button("Limpar todos os campos");
	
	public Div formulario() {
		
		criar();
		
		salvar.setThemeName("primary");
		limpar.setThemeName("secondary");

		// Button bar
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
	
	public void criar() {
		descricao.setPlaceholder("");
		descricao.setAutofocus(true);
		descricao.setValueChangeMode(ValueChangeMode.EAGER);
		
		tipo.setPlaceholder("O que foi plantado");
		tipo.setItems();

		tamanhoPlantacao.setPlaceholder("Hectares");
		tamanhoPlantacao.setValueChangeMode(ValueChangeMode.EAGER);
		
		tipoSemente.setPlaceholder("Identificação da semente (marca)");
		tipoSemente.setValueChangeMode(ValueChangeMode.EAGER);
		tipoSemente.setPlaceholder("Informações extras");

		observacao.setValueChangeMode(ValueChangeMode.EAGER);
		
		// adicionando descricaos nos campos do formulario
		form.addFormItem(descricao, "Descricao: ");
		form.addFormItem(tipo, "Tipo: ");		
		form.addFormItem(tamanhoPlantacao, "Tamanho da plantação: ");
		form.addFormItem(tipoSemente, "Semente");
		form.addFormItem(observacao, "Observação: ");

		camposObrigatorios();
		mensagensErro();
	}
	
	public void limpar() {
		descricao.clear();
		tipo.clear();
		tamanhoPlantacao.clear();
		tipoSemente.clear();
		observacao.clear();
	}
	
	public void camposObrigatorios() {
		// campos required
		descricao.setRequiredIndicatorVisible(true);
		tipo.setRequiredIndicatorVisible(true);
		tamanhoPlantacao.setRequiredIndicatorVisible(true);
		tipoSemente.setRequiredIndicatorVisible(true);
	}
	
	public void mensagensErro() {
		descricao.setErrorMessage("Descrição é obrigatória");
		tipo.setErrorMessage("Tipo é obrigatório");
		tamanhoPlantacao.setErrorMessage("O tamanho da plantação é obrigatório");
		tipoSemente.setErrorMessage("O tipo da semente é obrigatório");
	}

}
