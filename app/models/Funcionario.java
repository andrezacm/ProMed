package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;
import java.util.*;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Funcionario extends Model {

	@Required
	public String nome;
	public String dataNascimento;
	public String sexo;
	public String rg;
	public String telefone;
	public String email;
	public String cargo;

	public Funcionario(String nome,String dataNascimento,String sexo, String rg,String email, String telefone, String cargo)  {
		this.nome = nome;
		this.dataNascimento= dataNascimento;
		this.sexo = sexo;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
	}
}