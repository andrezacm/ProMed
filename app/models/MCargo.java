package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.CargoDAO;

import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MCargo extends Model {

	public Long id;
	public String nome;
	public String descricao;

	private CargoDAO dao;
	
	public MCargo(){}
	
	public MCargo(String nome, String descricao)  {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private void newDaoWithThis(){
		dao = new CargoDAO(this);
	}
	
	private void newDao(){
		dao = new CargoDAO();
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
	
	public List<MCargo> listar(){
		newDao();
		return dao.getRegistros();
	}
	
	public MCargo getCargo(int id){
		newDao();
		return dao.getCargo(id);
	}
}