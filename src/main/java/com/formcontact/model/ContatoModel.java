package com.formcontact.model;

import java.io.Serializable;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "idContato", "moeda", "tipo", "valor", "nome","email","telefone"})
@JsonInclude(Include.NON_NULL)

public class ContatoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("idContato")
    public Integer idContato;

    @JsonProperty("moeda")
	public String moeda;
	
    @JsonProperty("tipo")
	public String tipo;
	
	@JsonProperty("valor")
    public Integer valor;
        
    @JsonProperty("nome")
	public String nome;

    @JsonProperty("email")
	public String email;	

    @JsonProperty("telefone")
	public String telefone;	

    public ContatoModel() {};
    
    public ContatoModel(ContatoModel contato) {
    	this.idContato = contato.idContato;
    	this.moeda = contato.moeda;
    	this.tipo = contato.tipo;
    	this.valor = contato.valor;
    	this.nome = contato.nome;
		this.email = contato.email;		
    	this.telefone = contato.telefone;
    }
}
