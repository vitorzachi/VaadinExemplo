package br.edu.unoesc.views;

import org.springframework.boot.SpringBootConfiguration;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import br.edu.unoesc.dao.PessoasJDBC;
import br.edu.unoesc.model.Pessoa;

@SpringBootConfiguration
@Route("tabela")
@HtmlImport("frontend://styles/tema.html")
public class Tabela extends VerticalLayout{

	private static final long serialVersionUID = -1012764609446956611L;

	public Tabela() {
		add(new H1("Tabela pessoas"));
		PessoasJDBC jdbc = new PessoasJDBC();
		Grid<Pessoa> grid = new Grid<>();
		grid.setItems(jdbc.listar(Pessoa.listarTodos, Pessoa.class));
		grid.addColumn(Pessoa::getCodigo).setHeader("Codigo");
		grid.addColumn(Pessoa::getNome).setHeader("Nome");
		
		add(grid);

		grid.addItemDoubleClickListener(event -> {
			jdbc.remover(Pessoa.class, event.getItem().getCodigo());
			grid.setItems(jdbc.listar(Pessoa.listarTodos, Pessoa.class));
		});
		
	}

}
