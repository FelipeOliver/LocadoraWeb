package Factory.PostgreSql;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.UserDAO;
import Model.User;

public class PgUserDAO implements UserDAO{
	
	public static Connection conn = null;
	public PgUserDAO(Connection c){
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
			out.println("Teste");
			
			String sql = "Select e.user_name, e.tp_user from Users e where upper(e.login) = ? and e.user_password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.toUpperCase());
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			out.println("Nome: " + rs.toString());
			while (rs.next())
			{
				usu.setNome(rs.getString("user_name"));
				out.println("Nome: " + rs.getString("user_name"));
				usu.setTp_user(rs.getString("tp_user"));
				out.println("Tp_user: " + rs.getString("tp_user"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return usu;
	}
}
