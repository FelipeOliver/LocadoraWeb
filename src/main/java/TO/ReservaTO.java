package TO;


import java.io.Serializable;
import java.util.ArrayList;

import Model.Reserva;


public class ReservaTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Reserva> lista;
	
	public ReservaTO(){
		lista = new ArrayList<Reserva>();
	}
	
	public void add(Reserva reserva){
		lista.add(reserva);
	}
	
	public boolean remove(Reserva reserva){
		return(lista.remove(reserva));
	}
	
	public ArrayList<Reserva> getLista(){
		return lista;
	}
}

