package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void inserir_paciente() {
		render();
	}

	public static void inserir_funcionario() {
		render();
	}
	
	public static void inserir_procedimento(Long idPaciente) {
		render(idPaciente);
	}
	/*
	public static void visualizar_pacientes() {
		List<MPaciente> paciente = MPaciente.find("order by nome asc").fetch();
		render(paciente);
	}
	*/
	public static void visualizar_funcionario() {
		List<MFuncionario> funcionario = MFuncionario.find("order by nome asc").fetch();
		render(funcionario);
	}

	public static void visualizar_procedimento(Long idPaciente) {
		List<MProcedimento> procedimento = MProcedimento.find("idPaciente", idPaciente).fetch();
		render(procedimento);
	}
	
	public static void editar(Long id) {
		MPaciente paciente = MPaciente.find("id", id).first();
		render(paciente);
	}
	
	public static void editar_fun(Long id) {
		MFuncionario funcionario = MFuncionario.find("id", id).first();
		render("Application/editar_funcionario.html", funcionario);
	}

	public static void excluir(Long id) {
		MPaciente paciente = MPaciente.find("id", id).first();
		paciente.delete();
		index();
	}

	public static void excluir_funcionario(Long id) {
		MFuncionario funcionario = MFuncionario.find("id", id).first();
		funcionario.delete();
		index();
	}
	
	/*public static void cadastrar_paciente(String nome,String dataNascimento,String sexo, String rg,String email, String telefone, String end, String cep,String planoDesaude) {
		MPaciente paciente = new MPaciente(nome,dataNascimento, sexo, rg,email,telefone,end,cep,planoDesaude);
		if (validation.hasErrors()) {
			render("Application/inserir.html", paciente);
		}

		paciente.save();
		index();
	}*/
	
	public static void cadastrar_funcionario(String nome,String dataNascimento,String sexo, String rg,String email,String telefone,String cargo) {
		MFuncionario funcionario = new MFuncionario(nome,dataNascimento, sexo, rg,email,telefone,cargo);
		if (validation.hasErrors()) {
			render("Application/inserir_funcionario.html", funcionario);
		}

		funcionario.save();
		index();
	}

	public static void cadastrar_procedimento(String nome, Long idPaciente, Long idFuncionario, String observacao) {
		MProcedimento procedimento = new MProcedimento(nome, idPaciente, idFuncionario, observacao);
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
		List<Object> paciente = MPaciente.find("nome", nome).fetch();
		render("Application/consultar.html", paciente);
	}

	/*public static void editar_paciente(long id) {
		validation.required(request.params.get("nome"));
		validation.required(request.params.get("rg"));

		MPaciente paciente = MPaciente.find("id", id).first();

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
	}*/
	
	public static void editar_funcionario(long id) {
		validation.required(request.params.get("nome"));

		MFuncionario funcionario = MFuncionario.find("id", id).first();

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
