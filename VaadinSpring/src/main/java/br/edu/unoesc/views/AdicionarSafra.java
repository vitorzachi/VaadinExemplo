package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

import br.edu.unoesc.componentes.AdicionarSafraForm;

@HtmlImport("frontend://styles/tema.html")
public class AdicionarSafra {

	public Div pagina() {
		Div d = new Div();
		d.add(new H2("Adicionar safra"), new AdicionarSafraForm().formulario());
		return d;
	}	

}
