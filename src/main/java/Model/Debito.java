package Model;

public class Debito {


	
		
		   //atributos
		   private String banco;
		   private String agencia;
		   private String cConta;
		   private String nTitular;
		   private String nCpf;
		   
		   
		   //MetodoConstrutorParametrizado
		   public Debito( String b, String a, String c, String nt, String cpf ) {
		     setBanco(b);
		     setAgencia(a);
		     setCConta(c);
		     setNTitular(nt);
		     setNCpf(cpf);
		   }
		   
		   //Metodo construtor padrao
		   public Debito() {   
		   }
		   
		   //Metodos modificadores
		   public void setBanco( String b ) {
		      banco = b;
		      }
		   
		   
		   public void setAgencia( String a ) {
		      agencia = a;
		      }
		   
		   
		   public void setCConta( String c ) {
		      
			   cConta = c;
		   }
		   
		   public void setNTitular( String nt ) {
			   nTitular = nt;
		   }
		   
		   public void setNCpf( String cpf ) {
			   nCpf = cpf;
		   }
		   
	   
		   //Metodos de acesso
		   public String getBanco() {
		      return this.banco;
		   }
		   
		   public String getAgencia() {
		      return this.agencia;
		   }
		   
		   public String getCConta(){
		      return this.cConta;
		   }
		   
		   public String getNTitular() {
		      return this.nTitular;
		   }
		   
		   public String getNCpf() {
		      return this.nCpf;
		   }
		   

		
	

}
