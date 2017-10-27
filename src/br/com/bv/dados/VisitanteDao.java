package br.com.bv.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitanteDao
{	
	private int id;
	private String nome, telefone, email, mensagem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void adicionar(String nome, String telefone, String email, String mensagem)
	{
		Connection conexao = null;
		String comandoSQL = "";
		PreparedStatement pst = null;
		
		comandoSQL =	"INSERT INTO wservlet3.Visitante(nome, telefone, email, mensagem) " +
						"VALUES (?, ?, ?, ?);";		
		try
		{
			conexao = new ConexaoFactory().getConnection();
			pst = conexao.prepareStatement(comandoSQL);
			pst.setString(1, nome);
			pst.setString(2, telefone);
			pst.setString(3, email);
			pst.setString(4, mensagem);
			pst.execute();
		}
		catch (SQLException e)
		{
			System.out.println("ERRO. Não foi possivel se conectar ao banco.");
			//e.printStackTrace();
		}
		finally
		{
			/*try {
				pst.close();
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	public List<VisitanteDao> listar()
	{
		Connection conexao = null;
		String comandoSQL = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<VisitanteDao> visitantes = new ArrayList<VisitanteDao>();
		VisitanteDao visitante = null;
		
		comandoSQL =	"SELECT * FROM Visitante;";
		
		try
		{
			conexao = new ConexaoFactory().getConnection();	
			pst = conexao.prepareStatement(comandoSQL);
			rs = pst.executeQuery();
			while (rs.next())
			{
				visitante = new VisitanteDao();
				visitante.setId(rs.getInt("id"));
				visitante.setNome(rs.getString("nome"));
				visitante.setEmail(rs.getString("email"));
				visitante.setMensagem(rs.getString("mensagem"));
				visitantes.add(visitante);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				pst.close();
				conexao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return visitantes;
	}

}
