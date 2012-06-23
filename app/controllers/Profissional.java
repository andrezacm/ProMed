package controllers;

import java.util.List;

import models.MProfissional;
import play.mvc.Controller;

public class Profissional extends Controller{
	
	static MProfissional _profissional = new MProfissional();
	
	public static void cadastrar() {
		render("Application/inserir_profissional.html");
	}

	public static void cadastrar_profissional(String nome, String sobrenome, String cpf, String rg, String especialidade, String observacao, Long id_cargo) {
		
		MProfissional profissional = new MProfissional(nome, sobrenome, cpf, rg, especialidade, observacao, id_cargo);
		
		if (validation.hasErrors()) {
			render("Application/inserir_profissional.html", profissional);
		}

		profissional.salvar();
		listar();
	}
	
	public static void listar(){
		List<MProfissional> lista = _profissional.listar();
		render("Application/listar_profissionais.html", lista);
	}
	
	public static void editar(int id){
		MProfissional profissional = _profissional.getProfissional(id);
		render("Application/editar_profissional.html", profissional);
	}
	
	public static void editar_profissional(String nome, String sobrenome, String cpf, String rg, String especialidade, String observacao, Long id_cargo, Long id){
		
		MProfissional profissional = new MProfissional(nome, sobrenome, cpf, rg, especialidade, observacao, id_cargo);
		profissional.setId(id);
		
		profissional.editar();
		listar();
	}
	
	public static void excluir(Long id){
		_profissional.deletar(id);
		listar();
	}
	
	public static void visualizar(int id){
		MProfissional profissional = _profissional.getProfissional(id);
		render("Application/visualizar_profissional.html", profissional);
	}
}
