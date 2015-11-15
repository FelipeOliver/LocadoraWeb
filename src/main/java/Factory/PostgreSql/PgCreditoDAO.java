package Factory.PostgreSql;
import Model.Credito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DAO.CreditoDAO;

public class PgCreditoDAO implements CreditoDAO {
	
		private PreparedStatement st; //prepara a consulta sql
		Connection conn = null;
		
		public PgCreditoDAO(Connection c){
			conn = c;
		}
		
	   // metodo para incluir registros no banco de dados
	   public void insereDados( Credito credito ) {
	      try {
	         String sql = "insert into Credito (bandeira, nCartao, cSeguranca, nTitular, vencimento, nParcelas) values (?, ?, ?, ?, ?, ?)";       
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, credito.getBandeira() ); // substitui as ? por valores
	         st.setString( 2, credito.getNCartao() );
	         st.setString( 3, credito.getcSeguranca() );
	         st.setString( 4, credito.getNTitular() );
	         st.setString( 5, credito.getVencimento() );
	         st.setString( 6, credito.getParcelas() );
	         st.executeUpdate(); // executa o insert no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	   }
		
	   	   
}

