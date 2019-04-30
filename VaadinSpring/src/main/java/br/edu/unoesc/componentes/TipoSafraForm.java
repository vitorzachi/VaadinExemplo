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
	
	List<TipoSafra> tipo = new ArrayList<>();

	public Div formulario() {
		Div d = new Div();
		
		FormLayout form = new FormLayout();
		
		TextField nome = new TextField();
		nome.setPlaceholder("nome da safra");
		nome.setAutofocus(true);
		nome.setValueChangeMode(ValueChangeMode.EAGER);
		
		Button salvar = new Button("Salvar");
		salvar.setThemeName("primary");
		Button limpar = new Button("Limpar");
		limpar.setThemeName("secondary");

		// adicionando descricaos nos campos do formulario
		form.addFormItem(nome, "Nome:");
		
		// campos required
		nome.setRequiredIndicatorVisible(true);
		
		// Button bar
		HorizontalLayout actions = new HorizontalLayout();
		actions.add(salvar, limpar);
		
		Grid<TipoSafra> grid = new Grid<>();
		grid.setItems(tipo);
		grid.addColumn(TipoSafra::getCodigo).setHeader("Codigo");
		grid.addColumn(TipoSafra::getNome).setHeader("Nome");
		
		grid.addComponentColumn(item -> createRemoveButton(grid, item))
        .setHeader("Remover Item");
		
		grid.addComponentColumn(item -> createEditButton(grid, item))
        .setHeader("Editar Item");

		grid.setSelectionMode(Grid.SelectionMode.NONE);
		
		
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
		
		
		
		d.add(form, actions, grid);
		return d;
	}
	
	private Button createEditButton(Grid<TipoSafra> grid, TipoSafra item) {
	    Button button = new Button("Editar", clickEvent -> {
	    	editando = true;	    	
	    });
	    return button;
	}

	private Button createRemoveButton(Grid<TipoSafra> grid, TipoSafra item) {
	    Button button = new Button("Excluir", clickEvent -> {
	    	// Exclui tipo de safra
	    	
//	        ListDataProvider<Person> dataProvider = (ListDataProvider<Person>) grid
//	                .getDataProvider();
//	        dataProvider.getItems().remove(item);
//	        dataProvider.refreshAll();
	    });
	    return button;
	}
}
