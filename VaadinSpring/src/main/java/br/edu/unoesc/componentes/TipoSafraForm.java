package br.edu.unoesc.componentes;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import br.edu.unoesc.model.TipoSafra;

@HtmlImport("frontend://styles/tema.html")
public class TipoSafraForm {
	
	private boolean editando = false;
	
	private List<TipoSafra> tipo = new ArrayList<>();
	private TextField nome = new TextField();
	
	private Div d = new Div();
	private FormLayout form = new FormLayout();
	private Button salvar = new Button("Salvar");
	private Button limpar = new Button("Limpar");
	private Button novo = new Button("Novo");

	private Grid<TipoSafra> grid = new Grid<>();

	public Div formulario() {
		criar();
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(salvar, limpar, novo);
		
		tabela();	
		
		salvar.addClickListener(e ->{
			if(editando == true) {
				//edita
			}else {
				//
				TipoSafra safra = new TipoSafra();
				safra.setCodigo((long)1);
				safra.setNome(nome.getValue());
				tipo.add(safra);
				grid.setItems(tipo);
			}
			editando = false;
		});
		
		limpar.addClickListener(event -> {
			nome.clear();
		});
		
		novo.addClickListener(e ->{
			editando = false;
			nome.clear();
			nome.focus();
		});
		
		
		d.add(form, actions, grid);
		return d;
	}
	
	private void criar() {
		nome.setPlaceholder("nome da safra");
		nome.setAutofocus(true);
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		
		salvar.setThemeName("primary");
		limpar.setThemeName("secondary");
		novo.setThemeName("secondary");

		// adicionando descricaos nos campos do formulario
		form.addFormItem(nome, "Nome:");
		
		// campos required
		nome.setRequiredIndicatorVisible(true);
	}
	
	private void tabela() {
		grid.setItems(tipo);
		grid.addColumn(TipoSafra::getCodigo).setHeader("Codigo");
		grid.addColumn(TipoSafra::getNome).setHeader("Nome");
		
		grid.addComponentColumn(item -> createRemoveButton(grid, item))
        .setHeader("Remover Item");
		
		grid.addComponentColumn(item -> createEditButton(grid, item))
        .setHeader("Editar Item");

		grid.setSelectionMode(Grid.SelectionMode.NONE);
	}
	
	private Button createEditButton(Grid<TipoSafra> grid, TipoSafra item) {
	    Button button = new Button("Editar", clickEvent -> {
	    	nome.setValue(item.getNome());
	    	editando = true;	    	
	    });
	    return button;
	}

	private Button createRemoveButton(Grid<TipoSafra> grid, TipoSafra item) {
	    Button button = new Button("Excluir", clickEvent -> {
	    	// Exclui tipo de safra
	    	// atualiza tablela
	    	
	    	
//	        ListDataProvider<TipoSafra> dataProvider = (ListDataProvider<TipoSafra>) grid
//	                .getDataProvider();
//	        dataProvider.getItems().;
//	        dataProvider.refreshAll();
	    });
	    return button;
	}
	
	
}
