package br.edu.unoesc.componentes;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@HtmlImport("frontend://styles/tema.html")
public class DetalhesPaginaPrincipal{
	
	Div detalhes() {
		Div div = new Div();
		VerticalLayout vl = new VerticalLayout();

		Label dtInicio = new Label("Data Inicio: ");
		Label dtFim= new Label("Data Fim: ");
		Label safra = new Label("Safra: ");
		Label vGasto = new Label("Valor Gasto ");
		Label vRecebido = new Label("Valor Total Recebido: ");
		Label lucroFinal = new Label("Lucro Final: ");
		
		vl.add(dtInicio, dtFim, safra,vGasto, vRecebido, lucroFinal);
		div.add(vl);

		return div;
	}

}
