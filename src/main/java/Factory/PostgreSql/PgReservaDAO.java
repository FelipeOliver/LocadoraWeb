package Factory.PostgreSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.AutomovelDAO;
import DAO.ReservaDAO;
import Model.Reserva;
import TO.AutomovelTO;
import TO.ReservaTO;

public class PgReservaDAO implements ReservaDAO {
	// atributo
	   private PreparedStatement st; //prepara a consulta sql
	   Connection conn = null;
	   // construtor
	   public PgReservaDAO( Connection c ) {
		   conn = c;
	   }
		
	   // metodo para incluir registros no banco de dados
	   public void efetuarReserva( Reserva reserva, String status ) {
	      try {
	         String sql = "insert into Reserva (Cliente_cpf, Automovel_placa, dataEmprestimo  , horaEmprestimo , dataDevolucao, horaDevolucao , localEmprestimo, localDevolucao, tipoKm, statusReserva) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";       
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
		  System.out.println(cpf); 
	      Reserva reserva = null;
	      try {
	         String sql = "select * from Reserva where cliente_cpf = ? and statusreserva != ?";
	         st = conn.prepareStatement( sql );
	         st.setString( 1, cpf );
	         st.setString( 2, "n" );
	         
	         ResultSet resultSet = st.executeQuery();
	         
	         if ( resultSet.next() ) { // so espero um resultado por isso uso o IF para verificar
	            reserva = new Reserva(); // crio uma instancia do FornecedorTO
	            reserva.setCpf( resultSet.getString( "cliente_cpf" ) );	// coloca-se os dados
	            reserva.setPlaca( resultSet.getString( "automovel_placa" ) );
	            reserva.setDtEmprestimo( ""+resultSet.getString( "dataEmprestimo" ) );
	            reserva.setHrEmprestimo( resultSet.getString( "horaEmprestimo" ) );
	            reserva.setDtDevolucao( ""+resultSet.getString( "dataDevolucao " ) );
	            reserva.setHrDevolucao( resultSet.getString( "horaDevolucao " ) );
	            reserva.setLocalEmprestimo( resultSet.getString( "localEmprestimo" ) );
	            reserva.setLocalDevolucao( resultSet.getString( "localDevolucao" ) );
	            reserva.setTipoKm( resultSet.getString( "tipoKm" ) );
	         }
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	      //System.out.println(reserva.getPlaca());
	      return reserva; // retorna a instancia com os dados dentro para quem chamou
	   }
		
	   public void alteraStatus( String placa, String status ) { // recebe o bean com os dados a serem alterados no banco 
	      try {
	         String sql = "update Reserva set statusReserva =  ? where Automovel_placa = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, status ); // substitui as ? por valores
	         st.setString( 2, placa );
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
		         String sql = "select * from Reserva where dataEmprestimo = to_char(now()::date, 'dd/mm/yyyy')";
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
