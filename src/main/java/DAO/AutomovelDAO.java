package DAO;

import java.util.ArrayList;

import Model.Automovel;
import TO.AutomovelTO;

public interface AutomovelDAO { 
	public void cadastraAutomovel( Automovel automovel );
	public Automovel consultaAutomovel( String placa );
	public AutomovelTO consultaPorNome( String nome );
	public AutomovelTO consultaPorCategoria( String categoria, String acessorioA, String acessorioB );
	public void alteraAutomovel( Automovel automovel );
	public void alteraStatus( String placa, int status );
	public void excluiAutomovel( String placa );
	public ArrayList<Automovel> consultaAutomovelEstado( String estado );

}
