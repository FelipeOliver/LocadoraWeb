package Factory.PostgreSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DAO.ClienteDAO;
import Model.Cliente;

public class PgClienteDAO implements ClienteDAO {
	private PreparedStatement st; //prepara a consulta sql
	Connection conn = null;
	
	public PgClienteDAO(Connection c){
		conn = c;
	}
	   
		
	   public String cadastraCliente( Cliente cliente ) {
	      try {
	         String sql = "insert into Cliente (cpf, nome, rg, telefone, email, dtNascimento, sexo, numRegistro, estado, validadeCNH, dataEmissaoCNH) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";       
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, cliente.getCpf() ); // substitui as ? por valores
	         st.setString( 2, cliente.getNome() );
	         st.setString( 3, cliente.getRg() ); 
	         st.setString( 4, cliente.getTelefone() );
	         st.setString( 5, cliente.getEmail() );
	         st.setString( 6, cliente.getDtNascimento() );
	         st.setString( 7, cliente.getSexo() );
	         st.setString( 8, cliente.getNumRegistro() );
	         st.setString( 9, cliente.getEstado() );
	         st.setString( 10, cliente.getValidadeCNH() );
	         st.setString( 11, cliente.getDataEmissaoCNH() );
	         st.executeUpdate(); // executa o insert no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	          return e.toString();
	      }
	      return "OK";
	   }
		
	   public Cliente consultaCliente( String cpf ) {
	      Cliente cliente = null;
	      try {
	         String sql = "select * from Cliente where Cpf = ?";
	         st = conn.prepareStatement( sql );
	         st.setString( 1, cpf );
	         
	         ResultSet resultSet = st.executeQuery();
	         
	         if ( resultSet.next() ) { // s� espero um resultado por isso uso o IF para verificar
	            cliente = new Cliente(); // crio uma instancia 
	            cliente.setCpf( resultSet.getString( "Cpf" ) );	// coloca-se os dados
	            cliente.setNome( resultSet.getString( "nome" ) );
	            cliente.setRg( resultSet.getString( "rg" ) );
	            cliente.setTelefone( resultSet.getString( "telefone" ) );
	            cliente.setEmail( resultSet.getString( "email" ) );
	            cliente.setDtNascimento( resultSet.getString( "dtNascimento" ) );
	            cliente.setSexo( resultSet.getString( "sexo" ) );
	            cliente.setNumRegistro( resultSet.getString( "numRegistro" ) );
	            cliente.setEstado( resultSet.getString( "estado" ) );
	            cliente.setValidadeCNH( resultSet.getString( "validadeCNH" ) );
	            cliente.setDataEmissaoCNH( resultSet.getString( "dataEmissaoCNH" ) );
	         }
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	          e.printStackTrace(); // imprime descricao do erro se ocorrer
	      }
	      return cliente; // retorna a instancia com os dados dentro para quem chamou
	   }
		
	   public Cliente consultaPorNome( String nome )
		{
	      Cliente cliente = null;
	      try
			{
	         String sql = "select * from Cliente where nome like ?"; // like permite econtrar nomes com coringas
	         st = conn.prepareStatement( sql );
	         st.setString( 1, nome + "%" ); // adiciona o % para permitir consulta coringa
	         
	         ResultSet resultSet = st.executeQuery();
	         if( resultSet.next() ) {
	            cliente = new Cliente(); // crio uma instancia 
	            cliente.setCpf( resultSet.getString( "cpf" ) );	// coloca-se os dados
	            cliente.setNome( resultSet.getString( "nome" ) );
	            cliente.setRg( resultSet.getString( "rg" ) );
	            cliente.setTelefone( resultSet.getString( "telefone" ) );
	            cliente.setEmail( resultSet.getString( "email" ) );
	            cliente.setDtNascimento( resultSet.getString( "dtNascimento" ) );
	            cliente.setSexo( resultSet.getString( "sexo" ) );
	            cliente.setNumRegistro( resultSet.getString( "numRegistro" ) );
	            cliente.setEstado( resultSet.getString( "estado" ) );
	            cliente.setValidadeCNH( resultSet.getString( "validadeCNH" ) );
	            cliente.setDataEmissaoCNH( resultSet.getString( "dataEmissaoCNH" ) );	
	         }
	         st.close(); // fecha consulta  
	      }
	      catch( Exception e ) {
	         JOptionPane.showMessageDialog( null, "Nao existe cadastro para o nome informado", "ERRO", JOptionPane.ERROR_MESSAGE );
	      }
	      return cliente;
	   }
		
	   public void alteraCliente( Cliente cliente ) { // recebe o bean com os dados a serem alterados no banco 
	      try {
	         String sql = "update Cliente set nome = ?, rg = ?, telefone = ?, email = ?, dtNascimento = ?, sexo = ?, numRegistro = ?, estado = ?, validadeCNH = ?, dataEmissaoCNH = ? where Cpf = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         //st.setString( 1, cliente.getCpf() ); // substitui as ? por valores
	         st.setString( 1, cliente.getNome() );
	         st.setString( 2, cliente.getRg() );
	         st.setString( 3, cliente.getTelefone() );
	         st.setString( 4, cliente.getEmail() );
	         st.setString( 5, cliente.getDtNascimento() );
	         st.setString( 6, cliente.getSexo() );
	         st.setString( 7, cliente.getNumRegistro() );
	         st.setString( 8, cliente.getEstado() );
	         st.setString( 9, cliente.getValidadeCNH() );
	         st.setString( 10, cliente.getDataEmissaoCNH() );
	         st.setString( 11, cliente.getCpf() );
	         st.executeUpdate(); // executa o update no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	            e.printStackTrace();
	      }   
	   }
		
	   public void excluiCliente( String cpf ) { //delete registro pelo Codigo 
	      try {
	         String sql = "delete from Cliente where Cpf = ?";
	         st = conn.prepareStatement( sql ); // prepara o statement
	         st.setString( 1, cpf ); // substitui a ?
	         st.executeUpdate(); // executa o delete no banco
	         st.close(); // fecha consulta
	      }
	      catch( Exception e ) {
	         JOptionPane.showMessageDialog( null, "N�o existe cadastro para o cpf informado", "ERRO", JOptionPane.ERROR_MESSAGE );
	      } 
	   }
		
	   /*public ArrayList<FornecedorTO> listarItens()	// o retorno  um ArrayList generics de ItemsFornecedor
		{ 
	      FornecedorTO fornecedorTO = null;
	      ArrayList <FornecedorTO>itens = new ArrayList<FornecedorTO>(); // cria a instancia do ArrayList
	      try
			{
	         String sql = "select * from projeto.tabFornecedor order by frnNome"; // ordena por ordem alfab�tica ascendente a-z
	         st = conn.prepareStatement( sql );
	         ResultSet resultSet = st.executeQuery(); // objeto com a lista de resultados
	         while( resultSet.next() )// enquanto tiver outro registro continue no looping
				{ 
	            fornecedorTO = new FornecedorTO(); // cria novo item de fornecedor
	            fornecedorTO.setFrnCodigo( resultSet.getInt( "frnCodigo" ) );	// adiciona dados a ele
	            fornecedorTO.setFrnNome( resultSet.getString( "frnNome" ) );
	            fornecedorTO.setFrnCidade( resultSet.getString( "frnCidade" ) );
	            fornecedorTO.setFrnEstado( resultSet.getString( "frnEstado" ) );
	            itens.add( fornecedorTO ); // adiciona o item de fornecedor no ArrayList
	         }    
	         st.close(); // fecha consulta
	      }
	      catch( Exception e )
			{
	         e.printStackTrace();
	      }
	      return itens; // devolve o ArrayList cheio de Itens de Fornecedor.
	   }*/

} 
