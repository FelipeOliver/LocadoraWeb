package Factory.Mysql;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DAO.AutomovelDAO;
import Model.Automovel;
import TO.AutomovelTO;

public class MySqlAutomovelDAO implements AutomovelDAO {
	private PreparedStatement st; //prepara a consulta sql
	Connection conn = null;
	
	public MySqlAutomovelDAO(Connection c){
		conn = c;
	}

	
	// metodo para incluir registros no banco de dados
	public void cadastraAutomovel( Automovel automovel ) {
		try {
	         String sql = "insert into Automovel (placa, chassi, cidade, km, valorKm, estado, modelo, fabricante, grupo, acessorioA, acessorioB, imagem,statusAutomovel) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";       
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, automovel.getPlaca() ); // substitui as ? por valores
	         st.setString( 2, automovel.getChassi() );
	         st.setString( 3, automovel.getCidade() );
	         st.setDouble( 4, automovel.getKm() );
	         st.setDouble( 5, automovel.getValorKm() );
	         st.setString( 6, automovel.getEstado() );
	         st.setString( 7, automovel.getModelo() );
	         st.setString( 8, automovel.getFabricante() );
	         st.setString( 9, automovel.getGrupo() );
	         st.setString( 10, automovel.getAcessorioA() );
	         st.setString( 11, automovel.getAcessorioB() );
	         st.setString( 12, automovel.getImagem() );
	         st.setInt( 13, 0 );
	         st.executeUpdate(); // executa o insert no banco
	         st.close(); // fecha consulta 
		}
	    catch( Exception e ) {
	    	e.printStackTrace(); // imprime descricao do erro se ocorrer
	    }
	}
		
	   public Automovel consultaAutomovel( String placa ) {
	      Automovel automovel = null;
	      try {
	         String sql = "select * from Automovel where placa = ?";
	         st = conn.prepareStatement( sql );
	         st.setString( 1, placa );
	         
	         ResultSet resultSet = st.executeQuery();
	         
	         if ( resultSet.next() ) { //  espero um resultado por isso uso o IF para verificar
	            automovel = new Automovel(); // crio uma instancia 
	            automovel.setPlaca( resultSet.getString( "placa" ) );	// coloca-se os dados
	            automovel.setChassi( resultSet.getString( "chassi" ) );
	            automovel.setCidade( resultSet.getString( "cidade" ) );
	            automovel.setKm( resultSet.getDouble( "km" ) );
	            automovel.setValorKm( resultSet.getDouble( "valorKm" ) );
	            automovel.setEstado( resultSet.getString( "estado" ) );
	            automovel.setModelo( resultSet.getString( "modelo" ) );
	            automovel.setFabricante( resultSet.getString( "fabricante" ) );
	            automovel.setGrupo( resultSet.getString( "grupo" ) );
	            automovel.setAcessorioA( resultSet.getString( "acessorioA" ) );
	            automovel.setAcessorioB( resultSet.getString( "acessorioB" ) );
	            automovel.setImagem( resultSet.getString( "imagem" ) );
	         }
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	         e.printStackTrace();
	      }
	      return automovel; // retorna a instancia com os dados dentro para quem chamou
	   }
		
	   public AutomovelTO consultaPorNome( String nome )
		{
	      Automovel automovel = null;
	      AutomovelTO itens = new AutomovelTO();
	      try
			{
	         String sql = "select * from Automovel where modelo like ? and statusAutomovel <> ?"; // like permite encontrar nomes com coringas
	         st = conn.prepareStatement( sql );
	         st.setString( 1, nome + "%" ); // adiciona o % para permitir consulta coringa
	         st.setString( 2, "1" );
	         
	         ResultSet resultSet = st.executeQuery();
	         while( resultSet.next() ) {
	            automovel = new Automovel(); // crio uma instancia 
	            automovel.setPlaca( resultSet.getString( "placa" ) );	// coloca-se os dados
	            automovel.setChassi( resultSet.getString( "chassi" ) );
	            automovel.setCidade( resultSet.getString( "cidade" ) );
	            automovel.setKm( resultSet.getDouble( "km" ) );
	            automovel.setValorKm( resultSet.getDouble( "valorKm" ) );
	            automovel.setEstado( resultSet.getString( "estado" ) );
	            automovel.setModelo( resultSet.getString( "modelo" ) );
	            automovel.setFabricante( resultSet.getString( "fabricante" ) );
	            automovel.setGrupo( resultSet.getString( "grupo" ) );
	            automovel.setAcessorioA( resultSet.getString( "acessorioA" ) );
	            automovel.setAcessorioB( resultSet.getString( "acessorioB" ) );
	            automovel.setImagem( resultSet.getString( "imagem" ) );
	            itens.add(automovel);
	         }
	         st.close(); // fecha consulta  
	      }
	      catch( Exception e ) {
	            e.printStackTrace(); 
	      }
	      return itens;
	   }
		
	   public AutomovelTO consultaPorCategoria( String categoria, String acessorioA, String acessorioB )
		{
	      Automovel automovel = null;
	      AutomovelTO itens = new AutomovelTO();
	      try
			{
	         String sql = "select * from Automovel where grupo = ? and acessorioA = ? and acessorioB = ? and statusAutomovel <> ?"; // like permite econtrar nomes com curingas
	         st = conn.prepareStatement( sql );
	         st.setString( 1, categoria ); // adiciona o % para permitir consulta coringa
	         st.setString( 2, acessorioA );
	         st.setString( 3, acessorioB );
	         st.setString( 4, "1" );
	         
	         ResultSet resultSet = st.executeQuery();
	         while( resultSet.next() ) {
	            automovel = new Automovel(); // crio uma instancia 
	            automovel.setPlaca( resultSet.getString( "placa" ) );	// coloca-se os dados
	            automovel.setChassi( resultSet.getString( "chassi" ) );
	            automovel.setCidade( resultSet.getString( "cidade" ) );
	            automovel.setKm( resultSet.getDouble( "km" ) );
	            automovel.setValorKm( resultSet.getDouble( "valorKm" ) );
	            automovel.setEstado( resultSet.getString( "estado" ) );
	            automovel.setModelo( resultSet.getString( "modelo" ) );
	            automovel.setFabricante( resultSet.getString( "fabricante" ) );
	            automovel.setGrupo( resultSet.getString( "grupo" ) );
	            automovel.setAcessorioA( resultSet.getString( "acessorioA" ) );
	            automovel.setAcessorioB( resultSet.getString( "acessorioB" ) );
	            automovel.setImagem( resultSet.getString( "imagem" ) );
	            itens.add( automovel );	
	         }
	         st.close(); // fecha consulta  
	      }
	      catch( Exception e ) {
	            e.printStackTrace(); 
	      }
	      return itens;
	   }
	   
	   public void alteraAutomovel( Automovel automovel ) { // recebe o bean com os dados a serem alterados no banco 
	      try {
	         String sql = "update Automovel set placa =  ?, chassi = ?, cidade = ?, km = ?, valorKm = ?, estado = ?, modelo = ?, fabricante = ?, grupo = ?, acessorioA = ?, acessorioB = ?, imagem = ? where placa = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, automovel.getPlaca() ); // substitui as ? por valores
	         st.setString( 2, automovel.getChassi() );
	         st.setString( 3, automovel.getCidade() );
	         st.setDouble( 4, automovel.getKm() );
	         st.setDouble( 5, automovel.getValorKm() );
	         st.setString( 6, automovel.getEstado() );
	         st.setString( 7, automovel.getModelo() );
	         st.setString( 8, automovel.getFabricante() );
	         st.setString( 9, automovel.getGrupo() );
	         st.setString( 10, automovel.getAcessorioA() );
	         st.setString( 11, automovel.getAcessorioB() );
	         st.setString( 12, automovel.getImagem() );
	         st.setString( 13, automovel.getPlaca() );
	         st.executeUpdate(); // executa o update no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	            e.printStackTrace();
	      }   
	   }
	   
	   public void alteraStatus( String placa, int status ) { // recebe o bean com os dados a serem alterados no banco 
	      try {
	         String sql = "update Automovel set statusAutomovel = ? where placa = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setInt( 1, status ); // substitui as ? por valores
	         st.setString( 2, placa );
	         st.executeUpdate(); // executa o update no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	            e.printStackTrace();
	      }   
	   }
		
	   public void excluiAutomovel( String placa ) { //delete registro pelo Cï¿½digo 
	      try {
	         String sql = "delete from Automovel where placa = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, placa ); // substitui a ?
	         st.executeUpdate(); // executa o delete no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	         e.printStackTrace();
	      }   
	   }
	   
	   public ArrayList<String> listarItens()	
		{ 
	      Automovel automovel = null;
	      ArrayList <String>itens = new ArrayList<String>();
	      Calendar data2 = Calendar.getInstance();
	      String dataAtual = new SimpleDateFormat("yyyy-MM-dd").format(data2.getTime());
	      System.out.println( dataAtual );
	      try
			{
	         String sql = "select a.placa, a.modelo, a.fabricante, r.dtEmprestimo from Automovel a inner join Reserva r on a.placa = r.placa_automovel where dtEmprestimo = ?"; // like permite encontrar nomes com coringas
	         st = conn.prepareStatement( sql );
	         st.setString( 1, dataAtual );
	         
	         ResultSet resultSet = st.executeQuery();
	         while( resultSet.next() ) {
	            String resp = ""; // crio uma instancia 
	            resp = resultSet.getString( "placa" ) + "\t\t" + resultSet.getString( "modelo" ) + "\t\t" + resultSet.getString( "fabricante" ) + "\t\t" + resultSet.getDate( "dtEmprestimo" ) + "\n";	// coloca-se os dados
	            
	            itens.add( resp );
	         }
	         st.close(); // fecha consulta  
	      }
	      catch( Exception e ) {
	            e.printStackTrace(); 
	      }
	      return itens;
	   }
	   
	   public ArrayList<Automovel> consultaAutomovelEstado( String estado ) {
		      ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
		      try {
		         String sql = "select modelo, placa, imagem, valorKm from Automovel where estado = ?";
		         st = conn.prepareStatement( sql );
		         st.setString( 1, estado );
		         
		         ResultSet resultSet = st.executeQuery();
		         
		         if ( resultSet.next() ) { // s� espero um resultado por isso uso o IF para verificar
		            Automovel automovel = new Automovel();
		        	automovel.setPlaca( resultSet.getString( "placa" ) );	// coloca-se os dado
		            automovel.setValorKm( resultSet.getDouble( "valorKm" ) );
		            automovel.setModelo( resultSet.getString( "modelo" ) );
		            automovel.setImagem( resultSet.getString( "Imagem" ) );
		            automoveis.add(automovel);
		         }
		         st.close(); // fecha consulta
		      }
		      catch( Exception e ) {
		         e.printStackTrace();
		      }
		      return automoveis; // retorna a instancia com os dados dentro para quem chamou
		   }

}
