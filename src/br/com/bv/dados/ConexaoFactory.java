package br.com.bv.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory
{
	
	public Connection getConnection()
	{
		Connection conexao = null;

		try
		{
			// O mecanismo de SPI nao estava identificando o driver, entao foi necessario o Class.forName().
			// Provavelmente o driver nao e a nova versao Type 4.
			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/wservlet3", "root", "123");
				return conexao;
			}
			catch (SQLException e)
			{
				System.out.println("FALHA. Database offline.\n");
				throw new RuntimeException(e);
			}
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Classe nao encontrada!\n");
			//e.printStackTrace();
		}
		return null;
	}
	
}
