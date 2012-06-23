package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MProfissional;


public class ProfissionalDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MProfissional profissional;

	public ProfissionalDAO(MProfissional profissional) {
		this.connection = new ConnectionFactory().getConnection();
		this.profissional = profissional;
	}
	
	public ProfissionalDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.profissional = new MProfissional();
	}

	public void adicionar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into profissional (cpf, rg, nome, sobrenome, especialidade, " +
					"observacao, id_cargo) " +
					"values ("
							+ profissional.getCpf() + ", " 			+ profissional.getRg() + ", '" 			+ profissional.getNome() + "' ,'"
							+ profissional.getSobrenome() + "', '" 	+ profissional.especialidade + "', '" 	+ profissional.observacao + "', "
							+ profissional.id_cargo +")");

			// executa
			smt.close();
		
			System.out.println("Profissional gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update profissional set " +
					"cpf=" + profissional.getCpf() +", rg="+ profissional.getRg() +", nome='"+ profissional.getNome() +
					"', sobrenome='" + profissional.getSobrenome() + "', especialidade='" + profissional.especialidade +
					"', id_cargo=" + profissional.id_cargo + ", observacao='" + profissional.observacao +					
					"' where id = " + profissional.getId());

			// executa
			smt.close();
		
			System.out.println("Profissional editado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Long id) {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from profissional where id="+id);

			// executa
			smt.close();
		
			System.out.println("Profissional deletado do BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<MProfissional> getRegistros(){
		
		String sql = "select * from profissional";
		
		List<MProfissional> profissionals = new ArrayList<MProfissional>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MProfissional profissional = new MProfissional(resultado_consulta.getString("nome"), 
						resultado_consulta.getString("sobrenome"), 	resultado_consulta.getString("cpf"), 
						resultado_consulta.getString("rg"), 		resultado_consulta.getString("especialidade"), 
						resultado_consulta.getString("observacao"), resultado_consulta.getLong("id_cargo"));
				
				profissional.setId(resultado_consulta.getLong("id"));
				
				profissionals.add(profissional);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profissionals;
	}
	
	public MProfissional getProfissional(int id){
		
		String sql = "select * from profissional where id = " + id;
		
		List<MProfissional> profissionals = new ArrayList<MProfissional>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MProfissional profissional = new MProfissional(resultado_consulta.getString("nome"), 
						resultado_consulta.getString("sobrenome"), 	resultado_consulta.getString("cpf"), 
						resultado_consulta.getString("rg"), 		resultado_consulta.getString("especialidade"), 
						resultado_consulta.getString("observacao"), resultado_consulta.getLong("id_cargo"));
				
				profissional.setId(resultado_consulta.getLong("id"));
				
				profissionals.add(profissional);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profissionals.get(0);
	}
}
