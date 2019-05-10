package br.edu.unoesc.views;


import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import br.edu.unoesc.componentes.CadastroUsuarioForm;

@PageTitle("Gestão de Safra")
@Route("cadastroUsuario")
@HtmlImport("frontend://styles/tema.html")
public class CadastroUsuario extends VerticalLayout{
	
	private static final long serialVersionUID = 7072697725845935565L;
	
	public CadastroUsuario(){
		add(new H2("Cadastro de Usuário"), new CadastroUsuarioForm().formulario());
		
	}
	
}
