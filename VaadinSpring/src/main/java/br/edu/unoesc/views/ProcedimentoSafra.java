package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;

import br.edu.unoesc.componentes.ProcedimentoForm;

@HtmlImport("frontend://styles/tema.html")
public class ProcedimentoSafra {

	public Div pagina() {
		Div d = new Div();
		d.add(new H2("Realizar Procedimento"), new ProcedimentoForm().formulario());
		return d;
	}	
}
