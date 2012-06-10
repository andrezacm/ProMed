package controllers;

import java.util.List;

import models.MPaciente;
import play.mvc.Controller;

public class Paciente extends Controller{
	
	static MPaciente _paciente = new MPaciente();
	
	public static void cadastrar() {
		render("Application/inserir_paciente.html");
	}

	public static void cadastrar_paciente(String nome, String sobrenome, String cpf, String rg) {
		MPaciente paciente = new MPaciente(nome, sobrenome, cpf, rg);
		
		if (validation.hasErrors()) {
			render("Application/inserir_paciente.html", paciente);
		}

		paciente.salvar();
		listar();
	}
	
	public static void listar(){
		List<MPaciente> lista = _paciente.listar();
		render("Application/listar_pacientes.html", lista);
	}
	
	public static void editar(int id){
		MPaciente paciente = _paciente.getPaciente(id);
		render("Application/editar_paciente.html", paciente);
	}
	
	public static void editar_paciente(String nome, String sobrenome, String cpf, String rg, Long id){
		MPaciente paciente = new MPaciente(nome, sobrenome, cpf, rg, id);
		paciente.editar();
		listar();
	}
	
	public static void excluir(Long id){
		_paciente.deletar(id);
		listar();
	}
}

