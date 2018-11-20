package com.formcontact.service;

import com.formcontact.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formcontact.model.ContatoModel;

@Service
public class ContatoService {
	
    private java.sql.Connection con = ConnectionFactory.getConnection();
     
    public ContatoModel cadastrar(ContatoModel contato){

 	    String sql = "INSERT INTO contato ( moeda , tipo , valor, nome, email, telefone) VALUES ( ? , ? , ? ,? , ? , ? )";
		
    	try{  	    		    
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    preparedStatement.setString(1, contato.moeda);
    	    preparedStatement.setString(2, contato.tipo);	
    	    preparedStatement.setInt(3,contato.valor);	
    	    preparedStatement.setString(4, contato.nome);
    	    preparedStatement.setString(5, contato.email);
    	    preparedStatement.setString(6, contato.telefone);
    	    preparedStatement.execute();
 	        	    
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	} 
    	return contato;
    }
   
    public List<ContatoModel> buscarTodos(){
    	List<ContatoModel> ListaRetorno = new ArrayList<ContatoModel>();
    	String sql = "SELECT * FROM contato order by id_contato desc ";
    	
    	try{
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    
    	    ResultSet rs1 = preparedStatement.executeQuery();

	        ContatoModel x = null;
    	    while(rs1.next()){
    	    	x = new ContatoModel();
    	        x.idContato = rs1.getInt("id_contato");
    	    	x.moeda = rs1.getString("moeda");
    	    	x.tipo = rs1.getString("tipo");
    	    	x.valor = rs1.getInt("valor");
    	    	x.nome = rs1.getString("nome");
    	    	x.email = rs1.getString("email");
				x.telefone = rs1.getString("telefone");
    	    	    	    	
    	        System.out.println(x.toString());    	        
    	        
    	        ListaRetorno.add(x);
    	    }
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	}
    	return ListaRetorno;
	}
	
    public void excluir(ContatoModel contato){
    	String sql = "DELETE FROM contato WHERE ID_form = ?";

    	try{
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);	
    	    preparedStatement.setInt(1, contato.idContato);
    	    
    	    preparedStatement.execute();
    	    
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	}
    }

    public ContatoModel buscarPorId(Integer idform) {
    	ContatoModel encontrada = new ContatoModel();
    	String sql = "SELECT * FROM contato WHERE id_contato = ?";
    	try{
    	    System.out.println("buscar form por id >> "+idform);
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    		preparedStatement.setInt(1, idform);
    		
    	    ResultSet rs1 = preparedStatement.executeQuery();

	        ContatoModel x = null;
    	    while(rs1.next()){
    	    	x = new ContatoModel();
    	        x.idContato = rs1.getInt("id_contato");
    	    	x.moeda = rs1.getString("moeda");
    	    	x.tipo = rs1.getString("tipo");
    	    	x.valor = rs1.getInt("valor");
    	    	x.nome = rs1.getString("nome");
    	    	x.email = rs1.getString("email");
				x.telefone = rs1.getString("telefone");
    	    	    	    	
    	        System.out.println(x.toString());    
    	        
    	        encontrada = x;
    	        break;
        	    }
    	}catch(SQLException e){
    	    System.out.println("Erro de SQL > QUERY SELECT * FROM contato: "+e);
    	    e.printStackTrace();
    	}    	
    	return encontrada;
	}	
}