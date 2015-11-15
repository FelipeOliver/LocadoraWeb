package Factory.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;
import DAO.AutomovelDAO;
import DAO.ClienteDAO;
import DAO.CreditoDAO;
import DAO.DebitoDAO;
import DAO.ReservaDAO;
import DAO.UserDAO;
import Factory.FactoryBD;

import com.mysql.jdbc.*;

public class MySqlConnect extends FactoryBD
{
	public Connection conn    = null;
	public static String url  = "jdbc:mysql://127.0.0.1:3306/locadoraautomovel";
	public static String user = "root";
	public static String pwd  = "";
	
	public UserDAO getUserDAO(){
		return new MySqlUserDAO(getConnection());
	}
	
	public ClienteDAO getClienteDAO(){
		return new MySqlClienteDAO(getConnection());
	}
	
	public AutomovelDAO getAutomovelDAO(){
		return new MySqlAutomovelDAO(getConnection());
	}
	
	public ReservaDAO getReservaDAO(){
		return new MySqlReservaDAO(getConnection());
	}
	
	public CreditoDAO getCreditoDAO(){
		return new MySqlCreditoDAO(getConnection());
	}
	
	public DebitoDAO getDebitoDAO(){
		return new MySqlDebitoDAO(getConnection());
	}
	
	public Connection getConnection()
	{
		try
		{
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(url, user, pwd);
		}
		catch(SQLException e)
		{
			out.println("Erro ao conectar no Banco de Dados");
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
