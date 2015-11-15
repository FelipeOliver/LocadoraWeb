package Model;

import DAO.ClienteDAO;
import Factory.FactoryBD;

public class Cliente {
   //Atributos
   private String nome;
   private String cpf;
   private String rg;
   private String telefone;
   private String email;
   private String dtNascimento;
   private String sexo;
   private String numRegistro;
   private String estado;
   private String validadeCNH;
   private String dataEmissaoCNH;
   
   //Metodo construtor parametrizado
   public Cliente( String nome, String cpf, String rg, String telefone, String email, String dtNascimento, String sexo, String numRegistro, String estado, String validadeCNH, String dataEmissaoCNH ) {
      setNome          ( nome );
      setCpf           ( cpf );
      setRg            ( rg );
      setTelefone      ( telefone );
      setEmail         ( email );
      setDtNascimento  ( dtNascimento );
      setSexo          ( sexo );
      setNumRegistro   ( numRegistro );
      setEstado        ( estado );
      setValidadeCNH   ( validadeCNH );
      setDataEmissaoCNH( dataEmissaoCNH );
   }
   
   //Metodo construtor padrao
   public Cliente() {   
   }
   
   //Metodos modificadores
   public void setNome( String nome ) {
      if( !nome.equals( null ) && !nome.equals( "" ) ) {
         this.nome = nome;
      }
   }
   
   public void setCpf( String cpf ) {
      if( !cpf.equals( null ) && !cpf.equals( "" ) ) {
         this.cpf = cpf;
      }
   }
   
   public void setRg( String rg ) {
      if( !rg.equals( null ) && !rg.equals( "" ) ) {
         this.rg = rg;
      }
   }
   
   public void setTelefone( String telefone ) {
      if( !telefone.equals( null ) && !telefone.equals( "" ) ) {
         this.telefone = telefone;
      }
   }
   
   public void setEmail( String email ) {
      if( !email.equals( null ) && !email.equals( "" ) ) {
         this.email = email;
      }
   }
   
   public void setDtNascimento( String dtNascimento) {
      if( dtNascimento != null ) {
         this.dtNascimento = dtNascimento;
      }
   }
   
   public void setSexo( String sexo ) {
      this.sexo = sexo;
   }
   
   public void setNumRegistro( String numRegistro ) {
      if( !numRegistro.equals( null ) && !numRegistro.equals( "" ) ) {
         this.numRegistro = numRegistro;
      }
   }
   
   public void setEstado( String estado ) {
      if( !estado.equals( null ) && !estado.equals( "" ) ) {
         this.estado = estado;
      }
   }
   
   public void setValidadeCNH( String validadeCNH) {
      if( validadeCNH != null ) {
         this.validadeCNH = validadeCNH;
      }
   }
   
   public void setDataEmissaoCNH( String dataEmissaoCNH ) {
      if( dataEmissaoCNH != null ) {
         this.dataEmissaoCNH = dataEmissaoCNH;
      }
   }
   
   //Metodos de acesso
   public String getNome() {
      return this.nome;
   }
   
   public String getCpf() {
      return this.cpf;
   }
   
   public String getRg() {
      return this.rg;
   }
   
   public String getTelefone() {
      return this.telefone;
   }
   
   public String getEmail() {
      return this.email;
   }
   
   public String getDtNascimento() {
      return this.dtNascimento;
   }
   
   public String getSexo() {
      return this.sexo;
   }
   
   public String getNumRegistro() {
      return this.numRegistro;
   }
   
   public String getEstado() {
      return this.estado;
   }
   
   public String getValidadeCNH() {
      return this.validadeCNH;
   }
   
   public String getDataEmissaoCNH() {
      return this.dataEmissaoCNH;
   }
   
   public void cadastraCliente( Cliente cliente ) {
      FactoryBD.getFactoryDB(1).getClienteDAO().cadastraCliente(cliente);//ClienteDAO().cadastraCliente( cliente );
   }
   
   public Cliente consultaCliente( String cpf ) {
      return FactoryBD.getFactoryDB(1).getClienteDAO().consultaCliente( cpf );
   }
   
   public void alteraCliente( Cliente cliente ) {
	   FactoryBD.getFactoryDB(1).getClienteDAO().alteraCliente( cliente );
   }
   
   public void excluiCliente( String cpf ) {
	   FactoryBD.getFactoryDB(1).getClienteDAO().excluiCliente( cpf );
   }
}
