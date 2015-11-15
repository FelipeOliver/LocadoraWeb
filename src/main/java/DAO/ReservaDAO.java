package DAO;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Factory.Mysql.MySqlConnect;
import Model.Reserva;
import TO.ReservaTO;

import java.sql.SQLException;

public interface ReservaDAO { // herda classe que cria a conexao
   
	public void efetuarReserva( Reserva reserva, String status );
	public Reserva consultarReserva( String cpf );
	public void alteraStatus( String cpf, String status );
	public ReservaTO consultarReservaFeitaNoDia();
}
