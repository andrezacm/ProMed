package controllers;

import java.util.List;

import models.MUsuario;
import play.mvc.Controller;

public class Usuario extends Controller{

	static MUsuario _usuario = new MUsuario();

	public static void cadastrar() {
		if (Security.isAuthorized())
			render("Application/inserir_usuario.html");
		else
			Application.login();
	}

	public static void cadastrar_usuario(Long id_acesso, Long id_paciente, Long id_profissional, String email, String login, String senha){
		if (Security.isAuthorized()){

			MUsuario usuario = new MUsuario(id_acesso, id_paciente, id_profissional, email, login, senha);

			if (validation.hasErrors()) {
				render("Application/inserir_usuario.html", usuario);
			}

			usuario.salvar();
			listar();
		}else
			Application.login();

	}

	public static void listar(){
		if (Security.isAuthorized()){
			List<MUsuario> lista = _usuario.listar();
			render("Application/listar_usuario.html", lista);
		} else
			Application.login();
	}

	public static void editar(int id){
		if (Security.isAuthorized()){
			MUsuario usuario = _usuario.getUsuario(id);
			render("Application/editar_usuario.html", usuario);
		} else
			Application.login();
	}

	public static void editar_usuario(Long id_acesso, Long id_paciente, Long id_profissional, String email, String login, String senha, Long id){
		if (Security.isAuthorized()){
			MUsuario usuario = new MUsuario(id_acesso, id_paciente, id_profissional, email, login, senha);
			usuario.setId(id);

			usuario.editar();
			listar();
		} else
			Application.login();
	}

	public static void excluir(Long id){
		if (Security.isAuthorized()){
			_usuario.deletar(id);
			listar();
		} else
			Application.login();
	}

	public static void visualizar(int id){
		if (Security.isAuthorized()){
			MUsuario usuario = _usuario.getUsuario(id);
			render("Application/visualizar_usuario.html", usuario);
		} else
			Application.login();
	}
}
