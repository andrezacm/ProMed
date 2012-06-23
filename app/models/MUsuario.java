package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.UsuarioDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MUsuario extends Model {

	public Long id;
	public Long id_acesso;
	public Long id_paciente;
	public Long id_profissional;
	public String email;
	public String login;
	public String senha;

	private UsuarioDAO dao;
	
	public MUsuario(){}
	
	public MUsuario(Long id_acesso, Long id_paciente, Long id_profissional, String email, String login, String senha){
		this.id_acesso = id_acesso;
		this.id_paciente = id_paciente;
		this.id_profissional = id_profissional;
		this.email = email;
		this.login = login;
		this.senha = senha;
		//this.data_cadastro = data_cadastro;
		//this.ultimo_acesso = ultimo_acesso;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_acesso() {
		return id_acesso;
	}

	public void setId_acesso(Long id_acesso) {
		this.id_acesso = id_acesso;
	}

	public Long getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Long getId_profissional() {
		return id_profissional;
	}

	public void setId_profissional(Long id_profissional) {
		this.id_profissional = id_profissional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	private void newDaoWithThis(){
		dao = new UsuarioDAO(this);
	}
	
	private void newDao(){
		dao = new UsuarioDAO();
	}
	
	public void salvar(){
		newDaoWithThis();
		dao.adicionar();
	}
	
	public void editar(){
		newDaoWithThis();
		dao.editar();
	}
	
	public void deletar(Long id){
		newDao();
		dao.deletar(id);
	}
	
	public List<MUsuario> listar(){
		newDao();
		return dao.getRegistros();
	}
	
	public MUsuario getUsuario(String login, String senha){
		newDao();
		return dao.getUsuario(login, senha);
	}
	
	public MUsuario getUsuario(int id){
		newDao();
		return dao.getUsuario(id);
	}
}