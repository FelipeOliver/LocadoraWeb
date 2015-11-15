package Factory.PostgreSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import DAO.DebitoDAO;
import Model.Debito;

public class PgDebitoDAO implements DebitoDAO {
		private PreparedStatement st; //prepara a consulta sql
		Connection conn = null;
		
		public PgDebitoDAO(Connection c){
			conn = c;
		}
	   // metodo para incluir registros no banco de dados
	   public void insereDados( Debito debito ) {
	      try {
	         String sql = "insert into debito (banco, agencia, cConta, nTitular, cpf) values (?, ?, ?, ?, ?)";       
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, debito.getBanco() ); // substitui as ? por valores
	         st.setString( 2, debito.getAgencia() );
	         st.setString( 3, debito.getCConta() );
	         st.setString( 4, debito.getNTitular() );
	         st.setString( 5, debito.getNCpf() );
	         st.executeUpdate(); // executa o insert no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	   }
}

