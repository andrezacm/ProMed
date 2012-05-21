package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		List<Paciente> pacientes = Paciente.find("order by nome asc").fetch();
		render(pacientes);
	}

	public static void inserir() {
		render();
	}

	public static void inserir_funcionario() {
		render();
	}
	
	public static void inserir_procedimento(Long idPaciente) {
		render(idPaciente);
	}
	
	public static void visualizar() {
		List<Paciente> paciente = Paciente.find("order by nome asc").fetch();
		render(paciente);
	}
	
	public static void visualizar_funcionario() {
		List<Funcionario> funcionario = Funcionario.find("order by nome asc").fetch();
		render(funcionario);
	}

	public static void visualizar_procedimento(Long idPaciente) {
		List<Procedimento> procedimento = Procedimento.find("idPaciente", idPaciente).fetch();
		render(procedimento);
	}
	
	public static void editar(Long id) {
		Paciente paciente = Paciente.find("id", id).first();
		render(paciente);
	}
	
	public static void editar_fun(Long id) {
		Funcionario funcionario = Funcionario.find("id", id).first();
		render("Application/editar_funcionario.html", funcionario);
	}

	public static void excluir(Long id) {
		Paciente paciente = Paciente.find("id", id).first();
		paciente.delete();
		index();
	}

	public static void excluir_funcionario(Long id) {
		Funcionario funcionario = Funcionario.find("id", id).first();
		funcionario.delete();
		index();
	}
	
	public static void cadastrar_paciente(String nome,String dataNascimento,String sexo, String rg,String email, String telefone, String end, String cep,String planoDesaude) {
		Paciente paciente = new Paciente(nome,dataNascimento, sexo, rg,email,telefone,end,cep,planoDesaude);
		if (validation.hasErrors()) {
			render("Application/inserir.html", paciente);
		}

		paciente.save();
		index();
	}
	
	public static void cadastrar_funcionario(String nome,String dataNascimento,String sexo, String rg,String email,String telefone,String cargo) {
		Funcionario funcionario = new Funcionario(nome,dataNascimento, sexo, rg,email,telefone,cargo);
		if (validation.hasErrors()) {
			render("Application/inserir_funcionario.html", funcionario);
		}

		funcionario.save();
		index();
	}

	public static void cadastrar_procedimento(String nome, Long idPaciente, Long idFuncionario, String observacao) {
		Procedimento procedimento = new Procedimento(nome, idPaciente, idFuncionario, observacao);
		if (validation.hasErrors()) {
			render("Application/inserir_procedimento.html", procedimento);
		}

		procedimento.save();
		index();
	}
	
	public static void consultar(){
		render("Application/consultar.html");
	}
	
	public static void consultar_paciente(){
		/*		validation.required(request.params.get("nome"));
		validation.required(request.params.get("rg"));
		 */		
		String nome = request.params.get("nome");
		List<Object> paciente = Paciente.find("nome", nome).fetch();
		render("Application/consultar.html", paciente);
	}

	public static void editar_paciente(long id) {
		validation.required(request.params.get("nome"));
		validation.required(request.params.get("rg"));

		Paciente paciente = Paciente.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/editar.html", paciente);
		}

		paciente.nome = request.params.get("nome");
		paciente.dataNascimento = request.params.get("dataNascimento");
		paciente.sexo = request.params.get("sexo");
		paciente.rg = request.params.get("rg");
		paciente.email = request.params.get("email");
		paciente.telefone = request.params.get("telefone");
		paciente.end= request.params.get("end");
		paciente.cep = request.params.get("cep");
		paciente.planoDesaude = request.params.get("plano");

		paciente.save();
		index();
	}
	
	public static void editar_funcionario(long id) {
		validation.required(request.params.get("nome"));

		Funcionario funcionario = Funcionario.find("id", id).first();

		if (validation.hasErrors()) {
			render("Application/editar_funcionario.html", funcionario);
		}

		funcionario.nome = request.params.get("nome");
		funcionario.rg = request.params.get("rg");
		funcionario.email = request.params.get("email");
		funcionario.telefone = request.params.get("telefone");
		funcionario.cargo = request.params.get("cargo");

		funcionario.save();
		index();
	}
}
