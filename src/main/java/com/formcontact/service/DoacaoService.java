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

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formcontact.model.DoacaoModel;

@Service
public class DoacaoService {
	
    private java.sql.Connection con = ConnectionFactory.getConnection();
     
    public DoacaoModel cadastrar(DoacaoModel Doacao){

 	    String sql = "INSERT INTO doacao ( nome , cpf , email, valorDoacao, total_bitcoins, origem, destino, api_response, data_inclusao) VALUES ( ? , ? , ? ,? , ? , ? ,? , ? , ? )";
		
    	try{  	    		    
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    preparedStatement.setString(1, Doacao.nome);
    	    preparedStatement.setString(2, Doacao.cpf);	
    	    preparedStatement.setString(3,Doacao.email);	
    	    preparedStatement.setFloat(4, Doacao.valorDoacao);
    	    preparedStatement.setFloat(5, Doacao.totalBitcoins);
    	    preparedStatement.setString(6, Doacao.origem);
    	    preparedStatement.setString(7, Doacao.destino);
    	    preparedStatement.setString(8, Doacao.apiResponse);
    	    preparedStatement.setTimestamp(9, Doacao.dataInclusao);
    	    preparedStatement.execute();
 	        	    
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	} 
    	return Doacao;
    }
   
    public List<DoacaoModel> buscarTodos(){
    	List<DoacaoModel> ListaRetorno = new ArrayList<DoacaoModel>();
    	String sql = "SELECT * FROM doacao order by id_doacao desc ";
    	
    	try{
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    
    	    ResultSet rs1 = preparedStatement.executeQuery();

	        DoacaoModel x = null;
    	    while(rs1.next()){
    	    	x = new DoacaoModel();
    	        x.idDoacao = rs1.getInt("id_Doacao");
    	    	x.nome = rs1.getString("moeda");
    	    	x.cpf = rs1.getString("tipo");
    	    	x.email = rs1.getString("valor");
    	    	x.valorDoacao = rs1.getFloat("nome");
    	    	x.totalBitcoins = rs1.getFloat("email");
				x.origem = rs1.getString("telefone");
				x.destino = rs1.getString("telefone");
				x.apiResponse = rs1.getString("telefone");
				x.dataInclusao = rs1.getTimestamp("telefone");
    	    	    	    	
    	        System.out.println(x.toString());    	        
    	        
    	        ListaRetorno.add(x);
    	    }
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	}
    	return ListaRetorno;
	}
	
    public void excluir(DoacaoModel Doacao){
    	String sql = "DELETE FROM doacao WHERE id_doacao = ?";

    	try{
    	    PreparedStatement preparedStatement = con.prepareStatement(sql);	
    	    preparedStatement.setInt(1, Doacao.idDoacao);
    	    
    	    preparedStatement.execute();
    	    
    	}catch(SQLException e){
    	    System.out.println(sql +e);
    	    e.printStackTrace();
    	}
    }

    public DoacaoModel buscarPorId(Integer idform) {
    	DoacaoModel encontrada = new DoacaoModel();
    	String sql = "SELECT * FROM doacao WHERE id_doacao = ?";
    	try{
    	    System.out.println("buscar form por id >> "+idform);
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    		preparedStatement.setInt(1, idform);
    		
    	    ResultSet rs1 = preparedStatement.executeQuery();

	        DoacaoModel x = null;
    	    while(rs1.next()){
    	    	x = new DoacaoModel();
    	        x.idDoacao = rs1.getInt("id_Doacao");
    	    	x.nome = rs1.getString("moeda");
    	    	x.cpf = rs1.getString("tipo");
    	    	x.email = rs1.getString("valor");
    	    	x.valorDoacao = rs1.getFloat("nome");
    	    	x.totalBitcoins = rs1.getFloat("email");
				x.origem = rs1.getString("telefone");
				x.destino = rs1.getString("telefone");
				x.apiResponse = rs1.getString("telefone");
				x.dataInclusao = rs1.getTimestamp("telefone");
    	    	    	    	
    	        System.out.println(x.toString());    
    	        
    	        encontrada = x;
    	        break;
        	    }
    	}catch(SQLException e){
    	    System.out.println("Erro de SQL > QUERY SELECT * FROM Doacao: "+e);
    	    e.printStackTrace();
    	}    	
    	return encontrada;
	}	
}