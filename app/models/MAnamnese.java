package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import dao.AnamneseDAO;
import dao.CargoDAO;
import dao.PacienteDAO;

import java.util.*;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class MAnamnese extends Model {

	@Required
	public Long idPaciente;
	public String endereco;
	public String estado_civil;
	public String profissao;
	public String local_de_trabal;
	public String procedencia;
	public String qp;
	public String cd;
	public String hda;
	public String hpp;
	public String hf;
	
	private static AnamneseDAO dao;

	
	public MAnamnese(){
		
	}
	
	public MAnamnese(String endereco ,String estado_civil,String profissao,String local_de_trabal, String procedencia,
			String qp,String cd , String hda, String hpp, String hf)  {
		this.endereco = endereco;
		this.estado_civil= estado_civil;
		this.profissao = profissao;
		this.local_de_trabal = local_de_trabal;
		this.procedencia=procedencia;
		this.qp=qp;
		this.cd = cd;
		this.hda = hda;
		this.hpp = hpp;
		this.hf = hf;
	}


	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getLocal_de_trabal() {
		return local_de_trabal;
	}

	public void setLocal_de_trabal(String local_de_trabal) {
		this.local_de_trabal = local_de_trabal;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getQp() {
		return qp;
	}

	public void setQp(String qp) {
		this.qp = qp;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getHda() {
		return hda;
	}

	public void setHda(String hda) {
		this.hda = hda;
	}

	public String getHpp() {
		return hpp;
	}

	public void setHpp(String hpp) {
		this.hpp = hpp;
	}

	public String getHf() {
		return hf;
	}

	public void setHf(String hf) {
		this.hf = hf;
	}
	private void newDaoWithThis(){
		dao = new AnamneseDAO(this);
	}
	
	public void salvar(){
		newDaoWithThis();
		dao.adicionar();
	}
}