package controllers;

import java.util.List;

import models.MCargo;
import models.MCargo;
import play.mvc.Controller;

public class Cargo extends Controller{

	static MCargo _cargo = new MCargo();

	public static void cadastrar() {
		if (Security.isAuthorized()){
			render("Application/inserir_cargo.html");
		} else
			Application.login();
	}

	public static void cadastrar_cargo(String nome, String descricao) {
		if (Security.isAuthorized()){
			validation.required(nome);
			validation.required(descricao);

			MCargo cargo = new MCargo(nome, descricao);

			if (validation.hasErrors()) {
				render("Application/inserir_cargo.html", cargo);
			}

			cargo.salvar();
			listar();
		} else
			Application.login();
	}

	public static void listar(){
		if (Security.isAuthorized()){
			List<MCargo> lista = _cargo.listar();
			render("Application/listar_cargos.html", lista);
		} else
			Application.login();
	}

	public static void editar(Long id){
		if (Security.isAuthorized()){
			MCargo cargo = _cargo.getCargo(id);
			render("Application/editar_cargo.html", cargo);
		} else
			Application.login();
	}

	public static void editar_cargo(String nome, String descricao, Long id){
		if (Security.isAuthorized()){
			MCargo cargo = new MCargo(nome, descricao);
			cargo.setId(id);

			cargo.editar();
			listar();
		} else
			Application.login();
	}

	public static void excluir(Long id){
		if (Security.isAuthorized()){
			_cargo.deletar(id);
			listar();
		} else
			Application.login();
	}

	public static void visualizar(Long id){
		if (Security.isAuthorized()){
			MCargo cargo = _cargo.getCargo(id);
			render("Application/visualizar_cargo.html", cargo);
		} else
			Application.login();
	}
}

