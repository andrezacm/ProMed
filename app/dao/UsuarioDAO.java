package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import model.Usuario;

public class UsuarioDAO implements InterfaceDAO{
/*
	// a conexão com o banco de dados
	private Connection connection;
	private Usuario usuario;

	public UsuarioDAO(Usuario usuario) {
		this.connection = new ConnectionFactory().getConnection();
		this.usuario = usuario;
	}
*/
	@Override
	public void adicionar() {

		String sql = "insert into usuarios (login,senha,nome) values (?,?,?)";
	/*	
	try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			stmt.setString(3,usuario.getNome());
			
			// executa
			stmt.execute();
			stmt.close();
		
			System.out.println("Usuario gravado no BD");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}*/
	}
	
	@Override
	public List getRegistros(){
		
		String sql = "select * from usuarios";
		
		/*List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultado_consulta = stmt.executeQuery();
			
			while(resultado_consulta.next()){
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado_consulta.getInt("id"));
				usuario.setLogin(resultado_consulta.getString("login"));
				usuario.setNome(resultado_consulta.getString("nome"));
				usuario.setSenha(resultado_consulta.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			resultado_consulta.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
		*/
		return new ArrayList();
	}
}
