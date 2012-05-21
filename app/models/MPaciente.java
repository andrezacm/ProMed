package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.PacienteDAO;

import java.util.*;
import play.data.validation.Required;
import play.db.jpa.Model;

public class MPaciente extends Model {

	public String nome;
	public String sobrenome;
	public String cpf;
	public String rg;

	private PacienteDAO dao;
	
	public MPaciente(){}
	
	public MPaciente(String nome, String sobrenome, String cpf, String rg)  {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
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
	
	private void newDao(){
		dao = new PacienteDAO(this);
	}
	
	public void salvar(){
		newDao();
		dao.adicionar();
	}
}