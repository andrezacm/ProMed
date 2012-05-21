package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.MPaciente;


public class PacienteDAO implements InterfaceDAO{

	// a conexão com o banco de dados
	private Connection connection;
	private MPaciente paciente;

	public PacienteDAO(MPaciente paciente) {
		this.connection = new ConnectionFactory().getConnection();
		this.paciente = paciente;
	}

	@Override
	public void adicionar() {

		String sql = "insert into paciente (cpf,rg,nome,sobrenome,data_cadastro) values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,paciente.getCpf());
			stmt.setString(2,paciente.getRg());
			stmt.setString(3,paciente.getNome());
			stmt.setString(4,paciente.getSobrenome());
			stmt.setString(5,"2012-05-21");
			
			// executa
			stmt.execute();
			stmt.close();
		
			System.out.println("Paciente gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List getRegistros(){
		
		String sql = "select * from paciente";
		
		List<MPaciente> pacientes = new ArrayList<MPaciente>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				MPaciente paciente = new MPaciente(resultado_consulta.getString("nome"), 
						resultado_consulta.getString("sobrenome"), resultado_consulta.getString("cpf"), 
						resultado_consulta.getString("rg"));
				
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
}
