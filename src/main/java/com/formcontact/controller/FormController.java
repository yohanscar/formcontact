package com.formcontact.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.formcontact.model.form;
import com.formcontact.service.formService;

	@RestController

    public class FormController {
	   
	    @Autowired
		FormService formService;

		//RouteSeq: 15
	    @RequestMapping(method=RequestMethod.POST, value="/contato", consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<form> cadastrarContato(@RequestBody ContatoModel contato){

			ContatoModel contatoCadastrado = formService.cadastrar(form);
		
	        return new ResponseEntity<form>(contatoCadastrado, HttpStatus.CREATED);
	    }
	   
		//RouteSeq: 16
	    @RequestMapping(method=RequestMethod.GET, value="/contatos", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Collection<ContatoModel>> buscarTodosforms(){
	        Collection<ContatoModel> contatosBuscados = ContatoService.buscarTodos();
	        return new ResponseEntity<>(contatosBuscados, HttpStatus.OK);
		}
		
		//RouteSeq: 18
	    @RequestMapping(method=RequestMethod.DELETE, value="/contato/{id}")
	    public ResponseEntity<form> excluirContato(@PathVariable Integer id){
	        ContatoModel contatoEncontrado = ContatoService.buscarPorId(id);
	        if(contatoEncontrado==null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        ContatoService.excluir(contatoEncontrado);
	        return new ResponseEntity<form>(HttpStatus.OK);
		}
		
	}
