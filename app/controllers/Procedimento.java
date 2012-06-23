package controllers;

import java.util.List;

import models.MProcedimento;
import play.mvc.Controller;

public class Procedimento extends Controller{
	
	static MProcedimento _procedimento = new MProcedimento();
	
	public static void cadastrar() {
		render("Application/inserir_procedimento.html");
	}

	public static void cadastrar_procedimento(Long id_paciente, Long id_tipo_procedimento, String data_inicio, String data_fim, 
			String local, String observacoes) {
		
		MProcedimento procedimento = new MProcedimento(id_paciente, id_tipo_procedimento, data_inicio, data_fim, local, observacoes);
		
		if (validation.hasErrors()) {
			render("Application/inserir_procedimento.html", procedimento);
		}

		procedimento.salvar();
		listar();
	}
	
	public static void listar(){
		List<MProcedimento> lista = _procedimento.listar();
		render("Application/listar_procedimentos.html", lista);
	}
	
	public static void editar(int id){
		MProcedimento procedimento = _procedimento.getProcedimento(id);
		render("Application/editar_procedimento.html", procedimento);
	}
	
	public static void editar_procedimento(Long id_paciente, Long id_tipo_procedimento, String data_inicio, String data_fim, 
			String local, String observacoes, Long id) {
		
		MProcedimento procedimento = new MProcedimento(id_paciente, id_tipo_procedimento, data_inicio, data_fim, local, observacoes);
		procedimento.setId(id);
		
		procedimento.editar();
		listar();
	}
	
	public static void excluir(Long id){
		_procedimento.deletar(id);
		listar();
	}
	
	public static void visualizar(int id){
		MProcedimento procedimento = _procedimento.getProcedimento(id);
		render("Application/visualizar_procedimento.html", procedimento);
	}
}
