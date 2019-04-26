package br.edu.unoesc.componentes;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;

public class DialogMensagem {
	
	Dialog dialog = new Dialog();
	
	public Dialog erroForm() {
		dialog.setWidth("300px");
		dialog.setHeight("130px");
		
		Div d1 = new Div();
		Label erro = new Label("Dados Inconsistentes");
		erro.getStyle().set("color", "red");
		d1.getStyle().set("text-align", "center");		
		d1.setWidth("100%");
		d1.add(erro);
		
		Div d2 = new Div();
		Label mensagem = new Label("Verefique os campos preenchidos");
		d2.getStyle().set("text-align", "center");
		d2.setWidth("100%");
		d2.add(mensagem);
		
		Div d3 = new Div();
		Button fechar = new Button("Fechar");
		fechar.setThemeName("primary");
		fechar.setAutofocus(true);
		
		d3.getStyle().set("padding-top", "5%");
		d3.getStyle().set("text-align", "center");
		d3.add(fechar);
		
		d3.setWidthFull();
		
		fechar.addClickListener(e ->{
			dialog.close();
		});
		
		dialog.setCloseOnOutsideClick(false);
		dialog.add(d1, d2, d3);
		return dialog;
		
	}
	
	public Dialog sucesso(String mensagem) {
		dialog.setWidth("300px");
		dialog.setHeight("130px");
		
		Div d1 = new Div();
		Label sucesso = new Label("Dados salvos com sucesso!");
		sucesso.getStyle().set("color", "blue");
		d1.getStyle().set("text-align", "center");		
		d1.setWidth("100%");
		d1.add(sucesso);
		
		Div d2 = new Div();
		Label m = new Label(mensagem);
		d2.getStyle().set("text-align", "center");
		d2.setWidth("100%");
		d2.add(m);
		
		Div d3 = new Div();
		Button fechar = new Button("Fechar");
		fechar.setThemeName("primary");
		fechar.setAutofocus(true);
		
		d3.getStyle().set("padding-top", "5%");
		d3.getStyle().set("text-align", "center");
		d3.add(fechar);
		
		d3.setWidthFull();
		
		fechar.addClickListener(e ->{
			dialog.close();
		});
		
		dialog.setCloseOnOutsideClick(false);
		dialog.add(d1, d2, d3);
		return dialog;
	}

}
