package Model;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Calendar; 
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Factory.FactoryBD;
import DAO.AutomovelDAO;
import DAO.ClienteDAO; 

public class Pagamento {

   //Atributos
   private Reserva reserva1;
   private double kmAtual;
   private String agenciaDevolvida;
   private Automovel automovel;
   private Cliente cliente;
 
   
   public Pagamento( Reserva reserva1, double kmAtual, String agenciaDevolvida ) {
      this.reserva1 = reserva1;
      this.kmAtual = kmAtual;
      this.agenciaDevolvida = agenciaDevolvida;
      System.out.println("porradocaralho");
      automovel = FactoryBD.getFactoryDB(2).getAutomovelDAO().consultaAutomovel( reserva1.getPlaca() );
      cliente = FactoryBD.getFactoryDB(2).getClienteDAO().consultaCliente( reserva1.getCpf() );
   }
   
   	   public long qtdDias() throws ParseException
	   {
	    
   	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
   	      Calendar dataA = Calendar.getInstance(); 
   	      Calendar dataB = Calendar.getInstance();
   	       
   	   dataB.setTime(sdf.parse(reserva1.getDtEmprestimo()));
   		long dias = 0; 
	    int diferenca = dataA.DAY_OF_YEAR - dataB.DAY_OF_YEAR;
	    dias = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	    
   		 
	    return dias;
	   }
   
   
   public double calcKmLivre() {
     
	   try{
	   return ( kmAtual - automovel.getKm() ) * automovel.getValorKm();
	   }
	   
	   catch(Exception e ){return 0.0;}
	   }
   
   public double calcAgencia() {
      double valor = 0.0;
      if( !agenciaDevolvida.equals( reserva1.getLocalEmprestimo() ) ) {
         valor = 30;
      }
      return valor;
   }
      
	public  double calculoControlado() {
		
		try{
		return(( qtdDias() * 0.01 * automovel.getValorKm() ) + calcAgencia());
		}
		
		   catch(Exception e ){return 0.0;}
		   }




	public  double calculoLivre(){
		try{
		return (calcKmLivre() + ( qtdDias() * 0.01 * calcKmLivre() ) + calcAgencia());
		}
		
		catch(Exception e){return 0.0;}
		}

}