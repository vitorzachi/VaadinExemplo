package br.edu.unoesc.componentes;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

@HtmlImport("frontend://styles/tema.html")
public class PaginaPrincipal{

	public Div pagina() {
		Div d = new Div();
		d.add(new H2("Ultima safra: "), new DetalhesPaginaPrincipal().detalhes());
		return d;
	}

}
