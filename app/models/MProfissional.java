package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.ProfissionalDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MProfissional extends Model {

	//not null
	public Long id;
	public Long id_cargo;
	public String cpf;
	public String rg;
	public String nome;
	public String sobrenome;
	public String especialidade;
	public String observacao;

	private ProfissionalDAO dao;
	
	public MProfissional(){}
	
	public MProfissional(String nome, String sobrenome, String cpf, String rg, String especialidade, String observacao, Long id_cargo) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.especialidade = especialidade;
		this.observacao = observacao;
		this.id_cargo = id_cargo;
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
	
	public Long getIdCargo() {
		return id_cargo;
	}

	public void setIdCargo(Long id_cargo) {
		this.id_cargo = id_cargo;
	}
	
	private void newDaoWithThis(){
		dao = new ProfissionalDAO(this);
	}
	
	private void newDao(){
		dao = new ProfissionalDAO();
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
	
	public List<MProfissional> listar(){
		newDao();
		return dao.getRegistros();
	}
	
	public MProfissional getProfissional(int id){
		newDao();
		return dao.getProfissional(id);
	}
}