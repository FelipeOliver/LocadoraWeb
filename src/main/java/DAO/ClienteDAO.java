package DAO;

import Model.Cliente;

public interface ClienteDAO { 
	public String cadastraCliente( Cliente cliente );
	public Cliente consultaCliente( String cpf );
	public Cliente consultaPorNome( String nome );
	public void alteraCliente( Cliente cliente );
	public void excluiCliente( String cpf );

}
