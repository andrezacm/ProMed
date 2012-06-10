package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.PacienteDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MPaciente extends Model {

	//not null
	public Long id;
	public String cpf;
	public String rg;
	public String nome;
	public String sobrenome;
	public String data_nascimento;

	public String sexo;
	public String cidade;
	public String estado;
	public String pais;
	public String observacoes;
	public String data_cadastro;

	private PacienteDAO dao;
	
	public MPaciente(){}
	
	public MPaciente(String nome, String sobrenome, String cpf, String rg, String data_nascimento, String sexo, 
			String cidade, String estado, String pais, String observacoes)  {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.observacoes = observacoes;
	}
	
	public void setDataCadastro(){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.data_cadastro = format.format(new Date());
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private void newDaoWithThis(){
		dao = new PacienteDAO(this);
	}
	
	private void newDao(){
		dao = new PacienteDAO();
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
	
	public List<MPaciente> listar(){
		newDao();
		return dao.getRegistros();
	}
	
	public MPaciente getPaciente(int id){
		newDao();
		return dao.getPaciente(id);
	}
}