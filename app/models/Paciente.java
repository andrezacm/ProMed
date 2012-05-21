package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.util.*;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Paciente extends Model {

	@Required
	public String nome;
	@Required
	public String dataNascimento;
	@Required
	public String sexo;
	@Required
	public String rg;
	@Required
	public String end;
	@Required
	public String cep;
	@Required
	public String telefone;
	@Required
	public String email;
	@Required
	public String planoDesaude;

	public Paciente(String nome,String dataNascimento,String sexo, String rg,String email, String telefone, String end, String cep,String planoDesaude)  {
		this.nome = nome;
		this.dataNascimento= dataNascimento;
		this.sexo = sexo;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.end = end;
		this.cep = cep;
		this.planoDesaude = planoDesaude;
	}
}