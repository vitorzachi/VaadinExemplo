package br.edu.unoesc.views;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

import br.edu.unoesc.componentes.PaginaPrincipal;

@Route("menu")
@HtmlImport("frontend://styles/tema.html")
public class Menu extends VerticalLayout{

	private static final long serialVersionUID = 7818309610561851854L;
	
	public Menu() {
		
		HorizontalLayout menu = new HorizontalLayout(); 
		
		Tab principal = new Tab("Página principal");
		Div pgPrincipal = new PaginaPrincipal().pagina();
		
		Tab addSafra = new Tab("Adicionar safra");		
		Div pgAddSafra = new AdicionarSafra().pagina();
		pgAddSafra.setVisible(false);
		
		Tab tipoSafra = new Tab("Tipo de safra");		
		Div pgTipoSafra = new TipoSafra().pagina();
		pgTipoSafra.setVisible(false);
		
		Map<Tab, Component> tabsToPages = new HashMap<>();
		tabsToPages.put(principal, pgPrincipal);
		tabsToPages.put(addSafra, pgAddSafra);
		tabsToPages.put(tipoSafra, pgTipoSafra);
		
		Tabs tabs = new Tabs(principal, addSafra, tipoSafra);
		tabs.setWidth("100%");
		tabs.setFlexGrowForEnclosedTabs(3);
		Div content = new Div(pgPrincipal,pgAddSafra, pgTipoSafra);
		content.setWidthFull();
		
		tabs.addSelectedChangeListener(event -> {
		    pgPrincipal.setVisible(false);
		    pgAddSafra.setVisible(false);
		    pgTipoSafra.setVisible(false);
		    
		    Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
		    selectedPage.setVisible(true);

		});
		
		
		menu.setWidth("100%");
		menu.add(tabs);
		add(menu, content);
		
		

	}

}
