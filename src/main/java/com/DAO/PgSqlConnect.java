package com.DAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

import org.postgresql.*;

public class PgSqlConnect 
{
	public Connection conn = null;
	
	public PgSqlConnect ()
	{
		
	}

	public Connection getConnection()
	{
		try
		{
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
			String user = dbUri.getUserInfo().split(":")[0];
			String pwd  = dbUri.getUserInfo().split(":")[1];
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(dbUrl,user,pwd);//, "chvobxupuixlhe", " Pe3oiHrrFVoJMGsZNf06nrtwEQ");
		}
		catch(URISyntaxException ee )
		{
			out.println("Erro ao pegar varáveis de ambiente");
			ee.printStackTrace();
			throw new RuntimeException(ee);	
		}
		catch(SQLException e)
		{
			out.println("Erro ao conectar no Banco de Dados");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void closeConnection()
	{
		try
		{
			conn.close();
		}
		catch(Exception e)
		{
			out.println("Erro ao Fechar Conexão: ");
			e.printStackTrace();
		}
	}
}
