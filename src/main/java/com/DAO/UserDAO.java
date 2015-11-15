package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.lang.System.out;


public class UserDAO
{
	Connection conn = null;
	public UserDAO()
	{
		conn = new PgSqlConnect().getConnection();
	}
	
	public boolean verificarUser(String login, String pwd)
	{
		boolean existe = false;
		try
		{
			String sql = "Select count(*) from Users e where upper(e.login) = ? and e.user_password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.toUpperCase());
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			//stmt.close();
			while (rs.next())
			{
				int resultado = rs.getInt(1);
				out.println("Retornou: " + resultado);
				if (resultado > 0)
				{
					existe = true;
				}
			}
			conn.close();
			
		}
		catch(Exception e)
		{
			//existe = false;
			e.printStackTrace();
		}
		return existe;
	}
}
