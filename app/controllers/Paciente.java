package controllers;

import java.util.List;

import models.MPaciente;
import play.mvc.Controller;

public class Paciente extends Controller{
	
	MPaciente paciente = new MPaciente();
	
	public static void inserir_paciente() {
		render();
	}

	public static void cadastrar_paciente(String nome,String sobrenome, String cpf, String rg) {
		MPaciente paciente = new MPaciente(nome, sobrenome, cpf, rg);
		
		if (validation.hasErrors()) {
			render("Application/inserir_paciente.html", paciente);
		}

		paciente.salvar();
		Application.index();
	}
	
}
