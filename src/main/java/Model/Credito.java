package Model;

public class Credito {
	
	 //Atributos
	   private String bandeira;
	   private String nCartao;
	   private String cSeguranca;
	   private String nTitular;
	   private String vencimento;
	   private String parcelas;
	   
	   //Metodo construtor parametrizado
	   public Credito( String b, String nc, String cs, String nt, String v, String p ) {
	      setBandeira( b );
	      setNCartao ( nc );
	      setCSeguranca ( cs );
	      setNTitular ( nt );
	      setVencimento ( v );
	      setParcelas ( p );
	   }
	   
	   //Metodo construtor padrao
	   public Credito() {   
	   }
	   
	   //Metodos modificadores
	   public void setBandeira( String b ) {
	      bandeira = b;
	      }
	   
	   
	   public void setNCartao( String nc ) {
	      nCartao = nc;
	      }
	   
	   
	   public void setCSeguranca( String cs ) {
	      
		   cSeguranca = cs;
	   }
	   
	   public void setNTitular( String nt ) {
		   nTitular = nt;
	   }
	   
	   public void setVencimento( String v ) {
		   vencimento = v;
	   }
	   
	   public void setParcelas( String p) {
		   parcelas = p;
	   }
	   
	   //Metodos de acesso
	   public String getBandeira() {
	      return this.bandeira;
	   }
	   
	   public String getNCartao() {
	      return this.nCartao;
	   }
	   
	   public String getcSeguranca(){
	      return this.cSeguranca;
	   }
	   
	   public String getNTitular() {
	      return this.nTitular;
	   }
	   
	   public String getVencimento() {
	      return this.vencimento;
	   }
	   
	   public String getParcelas() {
	      return this.parcelas;
	   }
	   

	
}
