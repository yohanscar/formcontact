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
import com.formcontact.model.DoacaoModel;
import com.formcontact.service.DoacaoService;

	@RestController

    public class DoacaoController {
	   
	    @Autowired
		DoacaoService DoacaoService;

		//RouteSeq: 15
	    @RequestMapping(method=RequestMethod.POST, value="/doacao", consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<DoacaoModel> cadastrarDoacao(@RequestBody DoacaoModel Doacao){
            String wallet = "0x9a138cfa1ccff75d03140c51af9780d6233292b8";
			DoacaoModel DoacaoCadastrado = DoacaoService.cadastrar(Doacao);
		
	        return new ResponseEntity<DoacaoModel>(DoacaoCadastrado, HttpStatus.CREATED);
	    }
	   
		//RouteSeq: 16
	    @RequestMapping(method=RequestMethod.GET, value="/doacao", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Collection<DoacaoModel>> buscarTodasDoacoes(){
	        Collection<DoacaoModel> DoacaosBuscados = DoacaoService.buscarTodos();
	        return new ResponseEntity<>(DoacaosBuscados, HttpStatus.OK);
		}
				
	}
