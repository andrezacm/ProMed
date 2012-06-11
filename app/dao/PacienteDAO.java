package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MPaciente;


public class PacienteDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MPaciente paciente;

	public PacienteDAO(MPaciente paciente) {
		this.connection = new ConnectionFactory().getConnection();
		this.paciente = paciente;
	}
	
	public PacienteDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.paciente = new MPaciente();
	}

	public void adicionar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into paciente (cpf, rg, nome, sobrenome, data_nascimento, sexo, cidade, estado," +
					"pais, observacoes, data_cadastro) " +
					"values ("
							+ paciente.getCpf() + ", " 			+ paciente.getRg() + ", '" 			+ paciente.getNome() + "' ,'"
							+ paciente.getSobrenome() + "', '" 	+ paciente.data_nascimento + "', '" + paciente.sexo + "', '"
							+ paciente.cidade + "', '" 			+ paciente.estado + "', '" 			+ paciente.pais + "', '"
							+ paciente.observacoes + "', '" 	+ paciente.data_cadastro +"')");

			// executa
			smt.close();
		
			System.out.println("Paciente gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update paciente set " +
					"cpf=" + paciente.getCpf() +", rg="+ paciente.getRg() +", nome='"+ paciente.getNome() +
					"', sobrenome='" + paciente.getSobrenome() + "', data_nascimento='" + paciente.data_nascimento +
					"', sexo='" + paciente.sexo + "', cidade='" + paciente.cidade + "', estado='" + paciente.estado +
					"', pais='" + paciente.pais + "', observacoes='" + paciente.observacoes +					
					"' where id = " + paciente.getId());

			// executa
			smt.close();
		
			System.out.println("Paciente editado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Long id) {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from paciente where id="+id);

			// executa
			smt.close();
		
			System.out.println("Paciente deletado do BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<MPaciente> getRegistros(){
		
		String sql = "select * from paciente";
		
		List<MPaciente> pacientes = new ArrayList<MPaciente>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MPaciente paciente = new MPaciente(resultado_consulta.getString("nome"), 
						resultado_consulta.getString("sobrenome"), 	resultado_consulta.getString("cpf"), 
						resultado_consulta.getString("rg"), 		resultado_consulta.getString("data_nascimento"), 
						resultado_consulta.getString("sexo"), 		resultado_consulta.getString("cidade"),
						resultado_consulta.getString("estado"),		resultado_consulta.getString("pais"),
						resultado_consulta.getString("observacoes"));
				
				paciente.setId(resultado_consulta.getLong("id"));
				
				pacientes.add(paciente);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pacientes;
	}
	
	public MPaciente getPaciente(Long id){
		
		String sql = "select * from paciente where id = " + id;
		
		List<MPaciente> pacientes = new ArrayList<MPaciente>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MPaciente paciente = new MPaciente(resultado_consulta.getString("nome"), 
						resultado_consulta.getString("sobrenome"), 	resultado_consulta.getString("cpf"), 
						resultado_consulta.getString("rg"), 		resultado_consulta.getString("data_nascimento"), 
						resultado_consulta.getString("sexo"), 		resultado_consulta.getString("cidade"),
						resultado_consulta.getString("estado"),		resultado_consulta.getString("pais"),
						resultado_consulta.getString("observacoes"));
				
				paciente.setId(resultado_consulta.getLong("id"));
				
				pacientes.add(paciente);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pacientes.get(0);
	}
}
