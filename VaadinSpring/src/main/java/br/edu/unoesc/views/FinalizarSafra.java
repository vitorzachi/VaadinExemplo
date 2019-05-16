package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

import br.edu.unoesc.componentes.FinalizarSafraForm;

@HtmlImport("frontend://styles/tema.html")
public class FinalizarSafra {

	public Div pagina() {
		Div d = new Div();
		d.add(new H2("Finalizar Safra"), new FinalizarSafraForm().formulario());
		return d;
	}	
}
