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
import com.formcontact.model.ContatoModel;
import com.formcontact.service.ContatoService;

	@RestController

    public class FormController {
	   
	    @Autowired
		ContatoService ContatoService;

		//RouteSeq: 15
	    @RequestMapping(method=RequestMethod.POST, value="/contato", consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ContatoModel> cadastrarContato(@RequestBody ContatoModel contato){

			ContatoModel contatoCadastrado = ContatoService.cadastrar(form);
		
	        return new ResponseEntity<ContatoModel>(contatoCadastrado, HttpStatus.CREATED);
	    }
	   
		//RouteSeq: 16
	    @RequestMapping(method=RequestMethod.GET, value="/contatos", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Collection<ContatoModel>> buscarTodosforms(){
	        Collection<ContatoModel> contatosBuscados = ContatoService.buscarTodos();
	        return new ResponseEntity<>(contatosBuscados, HttpStatus.OK);
		}
		
		//RouteSeq: 18
	    @RequestMapping(method=RequestMethod.DELETE, value="/contato/{id}")
	    public ResponseEntity<ContatoModel> excluirContato(@PathVariable Integer id){
	        ContatoModel contatoEncontrado = ContatoService.buscarPorId(id);
	        if(contatoEncontrado==null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        ContatoService.excluir(contatoEncontrado);
	        return new ResponseEntity<ContatoModel>(HttpStatus.OK);
		}
		
	}
