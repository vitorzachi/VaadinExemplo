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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.edu.unoesc.componentes.PaginaPrincipal;

@PageTitle("Gestão de Safra")
@Route("menu")
@HtmlImport("frontend://styles/tema.html")
public class Menu extends VerticalLayout{

	private static final long serialVersionUID = 7818309610561851854L;

	private HorizontalLayout menu = new HorizontalLayout(); 
	
	private Map<Tab, Component> tabsToPages = new HashMap<>();
	private Tabs tabs = new Tabs();	
	private Div content = new Div();
	
	
	// Definindo Div com as paginas
	private Div pgPrincipal = new PaginaPrincipal().pagina();
	private Div pgAddSafra = new AdicionarSafra().pagina();
	private Div pgTipoSafra = new TipoSafra().pagina();
	private Div pgProcediemento = new ProcedimentoSafra().pagina();
	private Div pgFinalizar = new FinalizarSafra().pagina();
	
	public Menu() {
		
		// criando paginas e tabs de conteudos
		paginaPrincipal();
		paginaAddSafra();
		tipoSafra();
		procedimento();
		finalizar();
		
		// editando tabs e conteudo
		tabs.setWidth("100%");
		tabs.setFlexGrowForEnclosedTabs(3);
		content.setWidthFull();
		
		// selecionando pagina ao clicar em tab
		tabs.addSelectedChangeListener(event -> {
		    pgPrincipal.setVisible(false);
		    pgAddSafra.setVisible(false);
		    pgTipoSafra.setVisible(false);
		    pgProcediemento.setVisible(false);
		    pgFinalizar.setVisible(false);
		    
		    Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
		    selectedPage.setVisible(true);

		});
		
		// editando menu 
		menu.setWidth("100%");
		// adicionando tabs em menU
		menu.add(tabs);
		// retornando VerticalLayout com menu e conteudo
		add(menu, content);

	}
	

	// criando tabs mapeando tab com conteudo e adicionando conteudo

	private void paginaPrincipal() {
		Tab principal = new Tab("Página principal");
		tabsToPages.put(principal, pgPrincipal);
		tabs.add(principal);
		content.add(pgPrincipal);
	}
	
	private void paginaAddSafra() {
		Tab addSafra = new Tab("Adicionar safra");		
		pgAddSafra.setVisible(false);
		tabsToPages.put(addSafra, pgAddSafra);
		tabs.add(addSafra);
		content.add(pgAddSafra);
	}
	
	private void tipoSafra() {
		Tab tipoSafra = new Tab("Tipo de safra");		
		pgTipoSafra.setVisible(false);
		tabsToPages.put(tipoSafra, pgTipoSafra);
		tabs.add(tipoSafra);
		content.add(pgTipoSafra);
	}
	
	private void procedimento() {
		Tab procedimento = new Tab("Realizar Procedimento");		
		pgProcediemento.setVisible(false);
		tabsToPages.put(procedimento, pgProcediemento);
		tabs.add(procedimento);
		content.add(pgProcediemento);
	}
	
	private void finalizar() {
		Tab finalizar = new Tab("Colher safra");
		pgFinalizar.setVisible(false);
		tabsToPages.put(finalizar, pgFinalizar);
		tabs.add(finalizar);
		content.add(pgFinalizar);
	}
	
//	public Menu() {
//	
//	
//	Tab principal = new Tab("Página principal");
//	Div pgPrincipal = new PaginaPrincipal().pagina();
//	
//	Tab addSafra = new Tab("Adicionar safra");		
//	Div pgAddSafra = new AdicionarSafra().pagina();
//	pgAddSafra.setVisible(false);
//	
//	Tab tipoSafra = new Tab("Tipo de safra");		
//	Div pgTipoSafra = new TipoSafra().pagina();
//	pgTipoSafra.setVisible(false);
//	
//	Tab procedimento = new Tab("Realizar Procedimento");		
//	Div pgProcediemento = new ProcedimentoSafra().pagina();
//	pgProcediemento.setVisible(false);
//	
//	Map<Tab, Component> tabsToPages = new HashMap<>();
//	tabsToPages.put(principal, pgPrincipal);
//	tabsToPages.put(addSafra, pgAddSafra);
//	tabsToPages.put(tipoSafra, pgTipoSafra);
//	tabsToPages.put(procedimento, pgProcediemento);
//	
//	Tabs tabs = new Tabs(principal, addSafra, tipoSafra, procedimento);
//	tabs.setWidth("100%");
//	tabs.setFlexGrowForEnclosedTabs(3);
//	Div content = new Div(pgPrincipal,pgAddSafra, pgTipoSafra, pgProcediemento);
//	content.setWidthFull();
//	
//	tabs.addSelectedChangeListener(event -> {
//	    pgPrincipal.setVisible(false);
//	    pgAddSafra.setVisible(false);
//	    pgTipoSafra.setVisible(false);
//	    pgProcediemento.setVisible(false);
//	    
//	    Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
//	    selectedPage.setVisible(true);
//
//	});
//	
//	
//	menu.setWidth("100%");
//	menu.add(tabs);
//	add(menu, content);
//
//}

}
