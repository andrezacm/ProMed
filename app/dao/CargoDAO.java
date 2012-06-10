package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MCargo;

public class CargoDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MCargo cargo;

	public CargoDAO(MCargo cargo) {
		this.connection = new ConnectionFactory().getConnection();
		this.cargo = cargo;
	}
	
	public CargoDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.cargo = new MCargo();
	}

	public void adicionar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into cargo (nome, descricao) " +
					"values ('"
							+ cargo.getNome() + "', '" + cargo.getDescricao() +"')");

			// executa
			smt.close();
		
			System.out.println("Cargo gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editar() {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update cargo set " +
					"nome='" + cargo.getNome() +"', descricao='"+ cargo.getDescricao() +		
					"' where id = " + cargo.getId());

			// executa
			smt.close();
		
			System.out.println("Cargo editado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Long id) {

		try {
			
			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from cargo where id="+id);

			// executa
			smt.close();
		
			System.out.println("Cargo deletado do BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<MCargo> getRegistros(){
		
		String sql = "select * from cargo";
		
		List<MCargo> cargos = new ArrayList<MCargo>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MCargo cargo = new MCargo(
						resultado_consulta.getString("nome"), 
						resultado_consulta.getString("descricao"));
				
				cargo.setId(resultado_consulta.getLong("id"));
				
				cargos.add(cargo);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cargos;
	}
	
	public MCargo getCargo(Long id){
		
		String sql = "select * from cargo where id = " + id;
		
		List<MCargo> cargos = new ArrayList<MCargo>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MCargo cargo = new MCargo(
						resultado_consulta.getString("nome"), 
						resultado_consulta.getString("descricao"));
				
				cargo.setId(resultado_consulta.getLong("id"));
				
				cargos.add(cargo);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cargos.get(0);
	}
}
