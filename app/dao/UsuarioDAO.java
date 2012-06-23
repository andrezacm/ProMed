package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controllers.Application;

import models.MUsuario;


public class UsuarioDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MUsuario usuario;

	public UsuarioDAO(MUsuario usuario) {
		this.connection = new ConnectionFactory().getConnection();
		this.usuario = usuario;
	}

	public UsuarioDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.usuario = new MUsuario();
	}

	public void adicionar() {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into usuario (login, senha, email) " +
							"values ('"+ usuario.getLogin() + "', '"+ usuario.getSenha() +"', '"+ usuario.getEmail() +"')");

			// executa
			smt.close();

			System.out.println("Usuario gravado no BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editar() {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update usuario set " +
							"login='" + usuario.getLogin() +"', senha='"+ usuario.getSenha()  +
							"', email = '" + usuario.getEmail() +
							"' where id = " + usuario.getId());

			// executa
			smt.close();

			System.out.println("Usuario editado no BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Long id) {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from usuario where id="+id);

			// executa
			smt.close();

			System.out.println("Usuario deletado do BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<MUsuario> getRegistros(){

		String sql = "select * from usuario";

		List<MUsuario> usuarios = new ArrayList<MUsuario>();

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultado_consulta = stmt.executeQuery();

			while(resultado_consulta.next()){
				MUsuario usuario = new MUsuario(
						resultado_consulta.getLong("id_acesso"), 
						resultado_consulta.getLong("id_paciente"), 
						resultado_consulta.getLong("id_profissional"), 
						resultado_consulta.getString("email"), 
						resultado_consulta.getString("login"), 
						resultado_consulta.getString("senha"));

				usuario.setId(resultado_consulta.getLong("id"));

				usuarios.add(usuario);
			}

			resultado_consulta.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios;
	}

	public MUsuario getUsuario(String login, String senha){

		String sql = "select * from usuario where login = '" + login + "' and senha = '" + senha +"'";

		List<MUsuario> usuarios = new ArrayList<MUsuario>();

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultado_consulta = stmt.executeQuery();

			while(resultado_consulta.next()){
				MUsuario usuario = new MUsuario(
						resultado_consulta.getLong("id_acesso"), 
						resultado_consulta.getLong("id_paciente"), 
						resultado_consulta.getLong("id_profissional"), 
						resultado_consulta.getString("email"), 
						resultado_consulta.getString("login"), 
						resultado_consulta.getString("senha"));

				usuario.setId(resultado_consulta.getLong("id"));

				usuarios.add(usuario);
			}

			resultado_consulta.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try{
			return usuarios.get(0);
		} catch (IndexOutOfBoundsException e){
			Application.loginerror();
		}
		return null;
	}

	public MUsuario getUsuario(int id){

		String sql = "select * from usuario where id = " + id;

		List<MUsuario> usuarios = new ArrayList<MUsuario>();

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultado_consulta = stmt.executeQuery();

			while(resultado_consulta.next()){
				MUsuario usuario = new MUsuario(
						resultado_consulta.getLong("id_acesso"), 
						resultado_consulta.getLong("id_paciente"), 
						resultado_consulta.getLong("id_profissional"), 
						resultado_consulta.getString("email"), 
						resultado_consulta.getString("login"), 
						resultado_consulta.getString("senha"));

				usuario.setId(resultado_consulta.getLong("id"));

				usuarios.add(usuario);
			}

			resultado_consulta.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios.get(0);
	}
}
