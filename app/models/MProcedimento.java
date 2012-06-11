package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.ProcedimentoDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.data.validation.Required;
import play.db.jpa.Model;

public class MProcedimento extends Model {

	//not null
	public Long id;
	public Long id_paciente;
	public Long id_tipo_procedimento;
	public String data_inicio;
	public String data_fim;
	public String local;
	public String observacoes;

	private ProcedimentoDAO dao;
	
	public MProcedimento(){}
	
	public MProcedimento(Long id_paciente, Long id_tipo_procedimento, String data_inicio, String data_fim, 
			String local, String observacoes) {
		
		this.id_paciente = id_paciente;
		this.id_tipo_procedimento = id_tipo_procedimento;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.local = local;
		this.observacoes = observacoes;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	private void newDaoWithThis(){
		dao = new ProcedimentoDAO(this);
	}
	
	private void newDao(){
		dao = new ProcedimentoDAO();
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
	
	public List<MProcedimento> listar(){
		newDao();
		return dao.getRegistros();
	}
	
	public MProcedimento getProcedimento(int id){
		newDao();
		return dao.getProcedimento(id);
	}
}