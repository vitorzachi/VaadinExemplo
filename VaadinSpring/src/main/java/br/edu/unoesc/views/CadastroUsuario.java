package br.edu.unoesc.views;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.edu.unoesc.componentes.CadastroUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Gestão de Safra")
@Route("cadastroUsuario")
@HtmlImport("frontend://styles/tema.html")
public class CadastroUsuario extends Div{

	private static final long serialVersionUID = -5497533232441585612L;
	private CadastroUsuarioForm cadastroUsuarioForm;

	@Autowired
	public  CadastroUsuario(CadastroUsuarioForm cadastroUsuarioForm){
		this.cadastroUsuarioForm= cadastroUsuarioForm;
	}

	public CadastroUsuario(){
		add(new H2("Cadastro de Usuário"), cadastroUsuarioForm.formulario());
		
	}	
}
