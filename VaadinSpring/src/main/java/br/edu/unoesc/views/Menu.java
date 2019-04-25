package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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
		
		Tab tab1 = new Tab("View 1");		
//		Div d = new View1();

		Tab tab2 = new Tab("View 2");
//		Div d2 = new View2();
		
		menu.add(new Icon(VaadinIcon.ANGLE_LEFT));
		menu.setWidth("100%");
		
		Tabs tabs = new Tabs(tab1, tab2);
		tabs.setWidth("100%");
		
		Div content = new PaginaPrincipal().pagina();
		menu.add(tabs);
		add(menu, content);
		
//		tabs.addSelectedChangeListener(event -> {
//			
//			Tab t = tabs.getSelectedTab();
//			if(t.equals(tab1)) {
////				content.remove(d2);
////				content.add(d);
//			}if(t.equals(tab2)) {
////				content.remove(d);
////				content.add(d2);
//			}
//		});
		
		

	}

}
