package controllers;

import java.util.List;

import models.MTipoProcedimento;
import models.MTipoProcedimento;
import play.mvc.Controller;

public class TipoProcedimento extends Controller{
	
	static MTipoProcedimento _tipo_procedimento = new MTipoProcedimento();
	
	public static void cadastrar() {
		render("Application/inserir_tipo_procedimento.html");
	}

	public static void cadastrar_tipo_procedimento(String nome, String descricao) {
		
		MTipoProcedimento tipo_procedimento = new MTipoProcedimento(nome, descricao);
		
		if (validation.hasErrors()) {
			render("Application/inserir_tipo_procedimento.html", tipo_procedimento);
		}

		tipo_procedimento.salvar();
		listar();
	}
	
	public static void listar(){
		List<MTipoProcedimento> lista = _tipo_procedimento.listar();
		render("Application/listar_tipo_procedimentos.html", lista);
	}
	
	public static void editar(Long id){
		MTipoProcedimento tipo_procedimento = _tipo_procedimento.getTipoProcedimento(id);
		render("Application/editar_tipo_procedimento.html", tipo_procedimento);
	}
	
	public static void editar_tipo_procedimento(String nome, String descricao, Long id){
		
		MTipoProcedimento tipo_procedimento = new MTipoProcedimento(nome, descricao);
		tipo_procedimento.setId(id);
		
		tipo_procedimento.editar();
		listar();
	}
	
	public static void excluir(Long id){
		_tipo_procedimento.deletar(id);
		listar();
	}
	
	public static void visualizar(Long id){
		MTipoProcedimento tipo_procedimento = _tipo_procedimento.getTipoProcedimento(id);
		render("Application/visualizar_tipo_procedimento.html", tipo_procedimento);
	}
}