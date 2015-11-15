package Model;

public class Reserva {
	   
	   //atributos
	   private static String cpf;
	   private static String placa;
	   private String dtEmprestimo;
	   private String hrEmprestimo;
	   private String dtDevolucao;
	   private String hrDevolucao;
	   private String localEmprestimo;
	   private String localDevolucao;
	   private String tipoKm;
	   
	   //metodo construtor parametrizado
	   public Reserva( String cpf, String placa, String dtEmprestimo, String hrEmprestimo, String dtDevolucao, String hrDevolucao, String localEmprestimo, String localDevolucao, String tipoKm ) {
	      setCpf( cpf );
	      setPlaca( placa );
	      setDtEmprestimo( dtEmprestimo );
	      setHrEmprestimo( hrEmprestimo );
	      setDtDevolucao( dtDevolucao );
	      setHrDevolucao( hrDevolucao );
	      setLocalEmprestimo( localEmprestimo );
	      setLocalDevolucao( localDevolucao );
	      setTipoKm( tipoKm );
	   }
	   
	   public Reserva() {
	   }
	   
	   //Metodos modificadores
	   public void setCpf( String cpf ) {
	      this.cpf = cpf;
	   }
	   
	   public void setPlaca( String placa ) {
	      this.placa = placa;
	   }
	   
	   public void setDtEmprestimo( String dtEmprestimo ) {
	      this.dtEmprestimo = dtEmprestimo;
	   }
	   
	   public void setHrEmprestimo( String hrEmprestimo ) {
	      this.hrEmprestimo = hrEmprestimo;
	   }
	   
	   public void setDtDevolucao( String dtDevolucao ) {
	      this.dtDevolucao = dtDevolucao;
	   }
	   
	   public void setHrDevolucao( String hrDevolucao ) {
	      this.hrDevolucao = hrDevolucao;
	   }
	   
	   public void setLocalEmprestimo( String localEmprestimo ) {
	      this.localEmprestimo = localEmprestimo;
	   }
	   
	   public void setLocalDevolucao( String localDevolucao ) {
	      this.localDevolucao = localDevolucao;
	   }
	   
	   public void setTipoKm( String tipoKm ) {
	      this.tipoKm = tipoKm;
	   }
	   
	   //Metodos de acesso
	   public String getCpf() {
	      return cpf;
	   }
	   
	   public String getPlaca() {
	      return placa;
	   }
	   
	   public String getDtEmprestimo() {
	      return dtEmprestimo;
	   }
	   
	   public String getHrEmprestimo() {
	      return hrEmprestimo;
	   }
	   
	   public String getDtDevolucao() {
	      return dtDevolucao;
	   }
	   
	   public String getHrDevolucao() {
	      return hrDevolucao;
	   }
	   
	   public String getLocalEmprestimo() {
	      return localEmprestimo;
	   }
	   
	   public String getLocalDevolucao() {
	      return localDevolucao;
	   }
	   
	   public String getTipoKm() {
	      return tipoKm;
	   }
	}
