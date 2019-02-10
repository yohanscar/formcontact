package com.formcontact.controller;
import org.json.JSONObject;
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
import com.formcontact.util.HMACFactory;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


	@RestController

    public class DoacaoController {
	   
	    @Autowired
		DoacaoService DoacaoService;

		//RouteSeq: 15
	    @RequestMapping(method=RequestMethod.POST, value="/doacao", consumes=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<DoacaoModel> cadastrarDoacao(@RequestBody DoacaoModel Doacao){
			String wallet = "0x9a138cfa1ccff75d03140c51af9780d6233292b8";
			wallet = GerarCarteiraDoacao(Doacao);
			DoacaoModel DoacaoCadastrado = DoacaoService.cadastrar(Doacao);

			
		
	        return new ResponseEntity<DoacaoModel>(DoacaoCadastrado, HttpStatus.CREATED);
	    }
	   
		//RouteSeq: 16
	    @RequestMapping(method=RequestMethod.GET, value="/doacao", produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Collection<DoacaoModel>> buscarTodasDoacoes(){
	        Collection<DoacaoModel> DoacaosBuscados = DoacaoService.buscarTodos();
	        return new ResponseEntity<>(DoacaosBuscados, HttpStatus.OK);
		}

		private String GerarCarteiraDoacao(DoacaoModel Doacao){

			System.out.println("================================ \n GerarCarteiraDoacao:");
		   
			//https://bootcamp.profitfy.trade
			
			//String getUrl = "https://bootcamp.profitfy.trade/api/v1/private/payment/cripto";
			String getUrl = "https://bootcamp.profitfy.trade/api/v1/private/userinfo/";
			
			JSONObject json = new JSONObject();
			json.put("coinFrom", "BRL");
			json.put("coinTo", "BTC");
			json.put("amount", Doacao.valorDoacao);
			json.put("reference", "0");
			json.put("create", true);
	
			System.out.println("amount:" + Doacao.valorDoacao);
		   
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			//HttpPost request = new HttpPost(getUrl);
			HttpGet request = new HttpGet(getUrl);
	
			HttpResponse response = null;
			try { 
				
				StringEntity params = new StringEntity(json.toString());

				//request = HMACFactory.implementsHMAC(request,json);

				String hmac = GerarHMAC(json);

		        request.addHeader("Authorization", hmac);
				
				System.out.println("= =  \n hmac:");  
				System.out.println(hmac);  
				
				//request.addHeader("Content-Type", "application/json");
				//request.addHeader("accept", "text/json");
				request.addHeader("accept", "application/json");
				request.addHeader("User-Agent", "Form 0.1");
				//request.setEntity(params);    
	
				response = httpClient.execute(request);
				System.out.println(response.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			String transactionHash = "";
			try {
				String responseString = new BasicResponseHandler().handleResponse(response);
				transactionHash = responseString;
				
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("----------- \n transactionHash:");
			System.out.println(transactionHash);
	
			return transactionHash;
		}

		private String GerarHMAC(JSONObject json){

			System.out.println("================================ \n GerarHMAC:");
		   
			String getUrl = "https://localhost:5001/api/values/";
				
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
			
			HttpPost request = new HttpPost(getUrl);
	
			HttpResponse response = null;
			try { 
				
				StringEntity params = new StringEntity(json.toString());
				
				request.addHeader("Content-Type", "application/json");
				//request.addHeader("accept", "text/json");
				//request.addHeader("accept", "application/json");
				request.addHeader("User-Agent", "Form 0.1");
				request.setEntity(params);    
	
				response = httpClient.execute(request);
				System.out.println(response.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			String transactionHash = "";
			try {
				String responseString = new BasicResponseHandler().handleResponse(response);
				transactionHash = responseString;
				
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("----------- \n hmac local response:");
			System.out.println(transactionHash);
	
			return transactionHash;
		}
				
	}
