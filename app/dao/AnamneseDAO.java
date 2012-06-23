package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MAnamnese;
import models.MCargo;



public class AnamneseDAO {
	private Connection connection;
	private MAnamnese anamnese;

	public AnamneseDAO(MAnamnese anamnese) {
		this.connection = new ConnectionFactory().getConnection();
		this.anamnese = anamnese;
	}
	
	public AnamneseDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.anamnese = new MAnamnese();
	}

	
	public void adicionar() {

		try {
			
			Statement smt = connection.createStatement();

			/*"insert into paciente (cpf, rg, nome, sobrenome, data_nascimento, sexo, cidade, estado," +
			"pais, observacoes, data_cadastro) " +
			"values ("
			,procedencia,qp,cd , hda, hpp, hf) 
			+ anamnese.getProcedencia() + "', '" 	+ anamnese.getQp() + "', '" + anamnese.getCd() + "', '"
							+ anamnese.getHda() + "', '" 			+ anamnese.getHpp() + "', '" 			+ anamnese.getHf()
			*/
		

			
			smt.executeUpdate(
					"insert into anamnese (endereco,estado_civil,profissao,local_de_trabalho) " +
					"values ('"
							+ anamnese.getEndereco() + "', '" 	+ anamnese.getEstado_civil() + "', '" 		+ anamnese.getProfissao() + "', '" 		+anamnese.getLocal_de_trabal()  + "')");

			// executa
			smt.close();
		
			System.out.println("Paciente gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
