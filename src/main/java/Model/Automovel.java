package Model;

import DAO.AutomovelDAO;
import Factory.FactoryBD;

public class Automovel {
	   //Atributos
	   private String chassi;
	   private String placa;
	   private String cidade;
	   private double km;
	   private double valorKm;
	   private String estado;
	   private String modelo;
	   private String fabricante; 
	   private String grupo;
	   private String acessorioA;
	   private String acessorioB;
	   private String imagem;
	   
	   //Metodo construtor parametrizado
	   public Automovel( String chassi, String placa, String cidade, double km, double valorKm, String estado, String modelo, String fabricante, String grupo, String acessorioA, String acessorioB, String imagem ) {
	      setChassi    ( chassi );
	      setPlaca     ( placa );
	      setCidade    ( cidade );
	      setKm        ( km );
	      setValorKm   ( valorKm );
	      setEstado    ( estado );
	      setModelo    ( modelo );
	      setFabricante( fabricante );
	      setGrupo     ( grupo );
	      setAcessorioA( acessorioA );
	      setAcessorioB( acessorioB );
	      setImagem( imagem );
	   } 
	   
	   //Metodo construtor padrao
	   public Automovel() {
	   }
	   
	   //Metodos modificadores
	   public void setChassi( String chassi ) {
	      if( !chassi.equals( null ) && !chassi.equals( "" ) ) {
	         this.chassi = chassi;
	      }
	   }
	   
	   public void setPlaca( String placa ) {
	      if( !placa.equals( null ) && !placa.equals( "" ) ) {
	         this.placa = placa;
	      }
	   }
	   
	   public void setCidade( String cidade ) {
	      if( !cidade.equals( null ) && !cidade.equals( "" ) ) {
	         this.cidade = cidade;
	      }
	   }
	   
	   public void setKm( double km ) {
	      if( km >= 0.0 ) {
	         this.km = km;
	      }
	   }
	   
	   
	   public void setValorKm( double valorKm ) {
	      if( valorKm >= 0.0 ) {
	         this.valorKm = valorKm;
	      }
	   }
	   
	   public void setEstado( String estado ) {
	         this.estado = estado;
	   }
	   
	   public void setModelo( String modelo ) {
	      if( !modelo.equals( null ) && !modelo.equals( "" ) ) {
	         this.modelo = modelo;
	      }
	   }
	   
	   public void setFabricante( String fabricante ) {
	      if( !fabricante.equals( null ) && !fabricante.equals( "" ) ) {
	         this.fabricante = fabricante;
	      }
	   }
	   
	   public void setGrupo( String grupo ) {
	      if( !grupo.equals( null ) && !grupo.equals( "" ) ) {
	         this.grupo = grupo;
	      }
	   }
	   
	   public void setAcessorioA( String acessorioA ) {
	      this.acessorioA = ""+acessorioA;  
	   }
	   
	   public void setAcessorioB( String acessorioB ) {
	      this.acessorioB = ""+acessorioB;
	   }
	   
	   public void setImagem( String imagem ) {
		   this.imagem = imagem;
	   }
	   
	   //Mï¿½todos de acesso
	   public String getChassi() {
	      return this.chassi;
	   }
	   
	   public String getPlaca() {
	      return this.placa;
	   }
	   
	   public String getCidade() {
	      return this.cidade;
	   }
	   
	   public double getKm() {
	      return this.km;
	   }
	   
	   public double getValorKm() {
	      return this.valorKm;
	   }
	   
	   public String getEstado() {
	      return this.estado;
	   }
	   
	   public String getModelo() {
	      return this.modelo;
	   }
	   
	   public String getFabricante() {
	      return this.fabricante;
	   }
	   
	   public String getGrupo() {
	      return this.grupo;
	   }
	   
	   public String getAcessorioA() {
	      return this.acessorioA;
	   }
	   
	   public String getAcessorioB() {
	      return this.acessorioB;
	   }
	   
	   public String getImagem() {
		   return this.imagem;
	   }
	   
	   public void cadastraAutomovel( Automovel automovel ) {
		   FactoryBD.getFactoryDB(1).getAutomovelDAO().cadastraAutomovel( automovel );
	   }
	   
	   public Automovel consultaAutomovel( String placa ) {
	      return FactoryBD.getFactoryDB(1).getAutomovelDAO().consultaAutomovel( placa );
	   }
	   
	   public void alteraAutomovel( Automovel automovel ) {
		   FactoryBD.getFactoryDB(1).getAutomovelDAO().alteraAutomovel( automovel );
	   }
	   
	   public void excluiAutomovel( String placa ) {
		   FactoryBD.getFactoryDB(1).getAutomovelDAO().excluiAutomovel( placa );
	      
	   }
	}
