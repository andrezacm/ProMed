package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.TipoProcedimentoDAO;

import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MTipoProcedimento extends Model {

	public Long id;
	public String nome;
	public String descricao;

	private static TipoProcedimentoDAO dao;

	public MTipoProcedimento(){}

	public MTipoProcedimento(String nome, String descricao)  {
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
		dao = new TipoProcedimentoDAO(this);
	}

	private static void newDao(){
		dao = new TipoProcedimentoDAO();
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

	public static List<MTipoProcedimento> listar(){
		newDao();
		return dao.getRegistros();
	}

	public static MTipoProcedimento getTipoProcedimento(Long id){
		newDao();
		return dao.getTipoProcedimento(id);
	}
}