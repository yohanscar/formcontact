package com.formcontact.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection = null;
	private static String url = "jdbc:postgresql://localhost/formcontact";
	private static String user = "postgres"; 
	private static String pass = "postgres"; 	

	public static Connection getConnection(){

		if (connection == null) {
			try {
	    	    Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, pass);
			} 
			catch (SQLException e) {
				System.out.println("Erro Conexão com Banco de Dados - Detalhes: " + e);
			}

			catch (ClassNotFoundException e) {
				System.out.println("Erro Carregamento Driver Conexão - Detalhes: " + e);
			}
		}	
		return connection;	
	}
}