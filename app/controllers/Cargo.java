package controllers;

import java.util.List;

import models.MCargo;
import models.MCargo;
import play.mvc.Controller;

public class Cargo extends Controller{
	
	static MCargo _cargo = new MCargo();
	
	public static void cadastrar() {
		render("Application/inserir_cargo.html");
	}

	public static void cadastrar_cargo(String nome, String descricao) {
		
		MCargo cargo = new MCargo(nome, descricao);
		
		if (validation.hasErrors()) {
			render("Application/inserir_cargo.html", cargo);
		}

		cargo.salvar();
		listar();
	}
	
	public static void listar(){
		List<MCargo> lista = _cargo.listar();
		render("Application/listar_cargos.html", lista);
	}
	
	public static void editar(Long id){
		MCargo cargo = _cargo.getCargo(id);
		render("Application/editar_cargo.html", cargo);
	}
	
	public static void editar_cargo(String nome, String descricao, Long id){
		
		MCargo cargo = new MCargo(nome, descricao);
		cargo.setId(id);
		
		cargo.editar();
		listar();
	}
	
	public static void excluir(Long id){
		_cargo.deletar(id);
		listar();
	}
	
	public static void visualizar(Long id){
		MCargo cargo = _cargo.getCargo(id);
		render("Application/visualizar_cargo.html", cargo);
	}
}