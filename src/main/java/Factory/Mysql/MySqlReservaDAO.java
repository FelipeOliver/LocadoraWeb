package Factory.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.AutomovelDAO;
import DAO.ReservaDAO;
import Model.Reserva;
import TO.ReservaTO;

public class MySqlReservaDAO implements ReservaDAO {
	// atributo
	   private PreparedStatement st; //prepara a consulta sql
	   Connection conn = null;
	   // construtor
	   public MySqlReservaDAO( Connection c ) {
		   conn = c;
	   }
		
	   // metodo para incluir registros no banco de dados
	   public void efetuarReserva( Reserva reserva, String status ) {
	      try {
	         String sql = "insert into Reserva (cpf_cliente, placa_automovel, dtEmprestimo, hrEmprestimo, dtDevolucao, hrDevolucao, localEmprestimo, localDevolucao, tipoKm, statusReserva) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";       
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, reserva.getCpf() ); // substitui as ? por valores
	         st.setString( 2, reserva.getPlaca() );
	         st.setString( 3, reserva.getDtEmprestimo() );
	         st.setString( 4, reserva.getHrEmprestimo() );
	         st.setString( 5, reserva.getDtDevolucao() );
	         st.setString( 6, reserva.getHrDevolucao() );
	         st.setString( 7, reserva.getLocalEmprestimo() );
	         st.setString( 8, reserva.getLocalDevolucao() );
	         st.setString( 9, reserva.getTipoKm() );
	         st.setString( 10, status );
	         st.executeUpdate(); // executa o insert no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	   }
		
	   public Reserva consultarReserva( String cpf ) {
	      Reserva reserva = null;
	      try {
	         String sql = "select * from Reserva where cpf_cliente = ? and statusReserva <> ?";
	         st = conn.prepareStatement( sql );
	         st.setString( 1, cpf );
	         st.setString( 2, "n" );
	         
	         ResultSet resultSet = st.executeQuery();
	         
	         if ( resultSet.next() ) { // so espero um resultado por isso uso o IF para verificar
	            reserva = new Reserva(); // crio uma instancia do FornecedorTO
	            reserva.setCpf( resultSet.getString( "cpf_cliente" ) );	// coloca-se os dados
	            reserva.setPlaca( resultSet.getString( "placa_automovel" ) );
	            reserva.setDtEmprestimo( ""+resultSet.getString( "dtEmprestimo" ) );
	            reserva.setHrEmprestimo( resultSet.getString( "hrEmprestimo" ) );
	            reserva.setDtDevolucao( ""+resultSet.getString( "dtDevolucao" ) );
	            reserva.setHrDevolucao( resultSet.getString( "hrDevolucao" ) );
	            reserva.setLocalEmprestimo( resultSet.getString( "localEmprestimo" ) );
	            reserva.setLocalDevolucao( resultSet.getString( "localDevolucao" ) );
	            reserva.setTipoKm( resultSet.getString( "tipoKm" ) );
	         }
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	      return reserva; // retorna a instancia com os dados dentro para quem chamou
	   }
		
	   public void alteraStatus( String cpf, String status ) { // recebe o bean com os dados a serem alterados no banco 
	      try {
	         String sql = "update Reserva set statusReserva =  ? where cpf_cliente = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, status ); // substitui as ? por valores
	         st.setString( 2, cpf );
	         st.executeUpdate(); // executa o update no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	            e.printStackTrace();
	      }   
	   }
	   
	   public ReservaTO consultarReservaFeitaNoDia() {
		      Reserva reserva = null;
		      ReservaTO itens = new ReservaTO();
		      try {
		         String sql = "select * from Reserva where dataEmprestimo = DATE_FORMAT(CURDATE() ‘%d/%m/%Y’)";
		         st = conn.prepareStatement( sql );
		         
		         ResultSet resultSet = st.executeQuery();
		         
		            while( resultSet.next() ) { 
		            reserva = new Reserva(); 
		            reserva.setCpf( resultSet.getString( "Cliente_cpf" ) );	
		            reserva.setPlaca( resultSet.getString( "Automovel_placa" ) );
		            reserva.setDtEmprestimo( ""+resultSet.getString( "dataEmprestimo" ) );
		            reserva.setHrEmprestimo( resultSet.getString( "horaEmprestimo" ) );
		            reserva.setDtDevolucao( ""+resultSet.getString( "dataDevolucao" ) );
		            reserva.setHrDevolucao( resultSet.getString( "horaDevolucao" ) );
		            reserva.setLocalEmprestimo( resultSet.getString( "localEmprestimo" ) );
		            reserva.setLocalDevolucao( resultSet.getString( "localDevolucao" ) );
		            reserva.setTipoKm( resultSet.getString( "tipoKm" ) );
		            itens.add(reserva);
		         }
		         st.close(); // fecha consulta
		      }
		      catch( Exception e ) {
		          e.printStackTrace(); // imprime descriï¿½ï¿½o do erro se ocorrer
		      }
		      return itens; // retorna a instancia com os dados dentro para quem chamou
		   }
}
