package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.MTipoProcedimento;

public class TipoProcedimentoDAO {

	// a conexão com o banco de dados
	private Connection connection;
	private MTipoProcedimento tipo_procedimento;

	public TipoProcedimentoDAO(MTipoProcedimento tipo_procedimento) {
		this.connection = new ConnectionFactory().getConnection();
		this.tipo_procedimento = tipo_procedimento;
	}

	public TipoProcedimentoDAO(){
		this.connection = new ConnectionFactory().getConnection();
		this.tipo_procedimento = new MTipoProcedimento();
	}

	public void adicionar() {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"insert into tipo_procedimento (nome, descricao) " +
					"values ('"
							+ tipo_procedimento.getNome() + "', '" + tipo_procedimento.getDescricao() +"')");

			// executa
			smt.close();

			System.out.println("TipoProcedimento gravado no BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editar() {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate(
					"update tipo_procedimento set " +
					"nome='" + tipo_procedimento.getNome() +"', descricao='"+ tipo_procedimento.getDescricao() +		
					"' where id = " + tipo_procedimento.getId());

			// executa
			smt.close();

			System.out.println("TipoProcedimento editado no BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Long id) {

		try {

			Statement smt = connection.createStatement();

			smt.executeUpdate("delete from tipo_procedimento where id="+id);

			// executa
			smt.close();

			System.out.println("TipoProcedimento deletado do BD");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<MTipoProcedimento> getRegistros(){

		String sql = "select * from tipo_procedimento";

		List<MTipoProcedimento> tipo_procedimentos = new ArrayList<MTipoProcedimento>();

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultado_consulta = stmt.executeQuery();

			while(resultado_consulta.next()){
				MTipoProcedimento tipo_procedimento = new MTipoProcedimento(
						resultado_consulta.getString("nome"), 
						resultado_consulta.getString("descricao"));

				tipo_procedimento.setId(resultado_consulta.getLong("id"));

				tipo_procedimentos.add(tipo_procedimento);
			}

			resultado_consulta.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tipo_procedimentos;
	}

	public MTipoProcedimento getTipoProcedimento(Long id){

		String sql = "select * from tipo_procedimento where id = " + id;

		List<MTipoProcedimento> tipo_procedimentos = new ArrayList<MTipoProcedimento>();

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet resultado_consulta = stmt.executeQuery();

			while(resultado_consulta.next()){
				MTipoProcedimento tipo_procedimento = new MTipoProcedimento(
						resultado_consulta.getString("nome"), 
						resultado_consulta.getString("descricao"));

				tipo_procedimento.setId(resultado_consulta.getLong("id"));

				tipo_procedimentos.add(tipo_procedimento);
			}

			resultado_consulta.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tipo_procedimentos.get(0);
	}
}