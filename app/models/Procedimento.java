package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.util.*;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Procedimento extends Model {

	@Required
	public String nome;
	@Required
	public Long idPaciente;
	public Long idFuncionario;
	@Required
	public String observacao;

	public Procedimento(String nome, Long idPaciente, Long idFuncionario, String observacao)  {
		this.nome = nome;
		this.idPaciente= idPaciente;
		this.idFuncionario = idFuncionario;
		this.observacao = observacao;
	}
}