package Factory;

import java.sql.Connection;

import DAO.AutomovelDAO;
import DAO.ClienteDAO;
import DAO.CreditoDAO;
import DAO.DebitoDAO;
import DAO.ReservaDAO;
import DAO.UserDAO;
import Factory.Mysql.MySqlConnect;
import Factory.PostgreSql.PgSqlConnect;

public abstract class FactoryBD {
	
	public abstract Connection getConnection();
	public abstract void closeConnection();
	public abstract UserDAO getUserDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract AutomovelDAO getAutomovelDAO();
	public abstract ReservaDAO getReservaDAO();
	public abstract CreditoDAO getCreditoDAO();
	public abstract DebitoDAO getDebitoDAO();
	
	public static FactoryBD getFactoryDB(int escolha){
			switch(escolha){
				//MySql
			    case 1:
					return new MySqlConnect();
				//PostGreSql	
				case 2:
					return new PgSqlConnect();
				default:
					return null;
			}
	}
}
