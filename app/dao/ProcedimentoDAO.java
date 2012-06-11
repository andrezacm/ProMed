package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MProcedimento;


public class ProcedimentoDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MProcedimento procedimento;

	public ProcedimentoDAO(MProcedimento procedimento) {
		this.connection = new ConnectionFactory().getConnection();
		this.procedimento = procedimento;
	}
	
	public ProcedimentoDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.procedimento = new MProcedimento();
	}

	public void adicionar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into procedimento (id_paciente, id_tipo_procedimento, data_inicio, data_fim, " +
					"local, observacoes) " +
					"values ("
							+ procedimento.id_paciente 	+ ", " 		+ procedimento.id_tipo_procedimento + ", '" 
							+ procedimento.data_inicio 	+ "' ,'" 	+ procedimento.data_fim 			+ "', '" 
							+ procedimento.local 		+ "', '" 	+ procedimento.observacoes 			+ "')");

			// executa
			smt.close();
		
			System.out.println("Procedimento gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update procedimento set " +
						"id_paciente = " 			+ procedimento.id_paciente +
						", id_tipo_procedimento = "	+ procedimento.id_tipo_procedimento +
						", data_inicio = '"			+ procedimento.data_inicio +
						"', data_fim ='" 			+ procedimento.data_fim + 
						"', local ='" 				+ procedimento.local +
						"', observacoes ='" 		+ procedimento.observacoes +					
							"' where id = " + procedimento.getId());

			// executa
			smt.close();
		
			System.out.println("Procedimento editado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Long id) {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from procedimento where id="+id);

			// executa
			smt.close();
		
			System.out.println("Procedimento deletado do BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<MProcedimento> getRegistros(){
		
		String sql = "select * from procedimento";
		
		List<MProcedimento> procedimentos = new ArrayList<MProcedimento>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			//id_paciente, id_tipo_procedimento, data_inicio, data_fim,"local, observacoes
			while(resultado_consulta.next()){
				MProcedimento procedimento = new MProcedimento(resultado_consulta.getLong("id_paciente"), 
						resultado_consulta.getLong("id_tipo_procedimento"), resultado_consulta.getString("data_inicio"), 
						resultado_consulta.getString("data_fim"), resultado_consulta.getString("local"), 
						resultado_consulta.getString("observacoes"));
				
				procedimento.setId(resultado_consulta.getLong("id"));
				
				procedimentos.add(procedimento);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return procedimentos;
	}
	
	public MProcedimento getProcedimento(int id){
		
		String sql = "select * from procedimento where id = " + id;
		
		List<MProcedimento> procedimentos = new ArrayList<MProcedimento>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MProcedimento procedimento = new MProcedimento(resultado_consulta.getLong("id_paciente"), 
						resultado_consulta.getLong("id_tipo_procedimento"), resultado_consulta.getString("data_inicio"), 
						resultado_consulta.getString("data_fim"), resultado_consulta.getString("local"), 
						resultado_consulta.getString("observacoes"));
				
				procedimento.setId(resultado_consulta.getLong("id"));
				
				procedimentos.add(procedimento);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return procedimentos.get(0);
	}
}
