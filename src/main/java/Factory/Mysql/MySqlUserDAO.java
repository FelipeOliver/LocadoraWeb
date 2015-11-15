package Factory.Mysql;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.UserDAO;
import Model.User;

public class MySqlUserDAO implements UserDAO{
	
	Connection conn = null;
	public MySqlUserDAO(Connection c)
	{
		conn = c;
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
			existe = false;
		}
		return existe;
	}
	
	public User getUser(String login, String pwd)
	{
		User usu = new User();
		try{
			String sql = "Select e.user_name, e.tp_user from Users e where upper(e.login) = ? and e.user_password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.toUpperCase());
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				usu.setNome(rs.getString(0));
				usu.setTp_user(rs.getString(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return usu;
	}


}
