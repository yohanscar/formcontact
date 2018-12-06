package com.formcontact.model;

import java.io.Serializable;
import java.sql.Timestamp;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
				
@JsonPropertyOrder({ "idDoacao", "nome", "cpf","email", "valorDoacao", "totalBitcoins","origem","destino","apiResponse","dataInclusao"})
@JsonInclude(Include.NON_NULL)

public class DoacaoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idDoacao")
    public Integer idDoacao;

    @JsonProperty("nome")
	public String nome;
	
    @JsonProperty("cpf")
	public String cpf;
	        
    @JsonProperty("email")
	public String email;	

    @JsonProperty("valorDoacao")
	public Float valorDoacao;	
	
    @JsonProperty("totalBitcoins")
	public Float totalBitcoins;	

    @JsonProperty("origem")
	public String origem;

    @JsonProperty("destino")
	public String destino;	

    @JsonProperty("apiResponse")
	public String apiResponse;	

    @JsonProperty("dataInclusao")
	public Timestamp dataInclusao;	

    public DoacaoModel() {};
    
    public DoacaoModel(DoacaoModel doacao) {
    	this.idDoacao = doacao.idDoacao;
    	this.nome = doacao.nome;
    	this.cpf = doacao.cpf;
    	this.email = doacao.email;
    	this.valorDoacao = doacao.valorDoacao;
		this.totalBitcoins = doacao.totalBitcoins;		
    	this.origem = doacao.origem;	
    	this.destino = doacao.destino;	
    	this.apiResponse = doacao.apiResponse;	
    	this.dataInclusao = doacao.dataInclusao;
    }
}
