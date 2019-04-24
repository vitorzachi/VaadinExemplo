package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

@HtmlImport("frontend://styles/tema.html")
public class PaginaPrincipal{

	Div pagina() {
		Div d = new Div();
		d.add(new H2("Ultima safra: "), new DetalhesPaginaPrincipal().detalhes());
		return d;
	}

}
