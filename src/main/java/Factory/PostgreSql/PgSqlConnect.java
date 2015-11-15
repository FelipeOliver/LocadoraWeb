package Factory.PostgreSql;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

import org.postgresql.*;

import DAO.AutomovelDAO;
import DAO.ClienteDAO;
import DAO.CreditoDAO;
import DAO.DebitoDAO;
import DAO.ReservaDAO;
import DAO.UserDAO;
import Factory.FactoryBD;
import Factory.Mysql.MySqlCreditoDAO;
import Factory.Mysql.MySqlDebitoDAO;

public class PgSqlConnect extends FactoryBD
{
	public Connection conn = null;	
	public UserDAO getUserDAO()
	{
		return new PgUserDAO(getConnection());
	}
	
	public ClienteDAO getClienteDAO(){
		return new PgClienteDAO(getConnection());
	}
	
	public AutomovelDAO getAutomovelDAO(){
		return new PgAutomovelDAO(getConnection());
	}
	
	public ReservaDAO getReservaDAO(){
		return new PgReservaDAO(getConnection());
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
