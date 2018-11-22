package com.formcontact.controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.formcontact.model.ContatoModel;

	@RestController

    public class ProfitfyController {
	   
		//RouteSeq: 15
	    @RequestMapping(method=RequestMethod.GET, value="/profitfy/{x}")
	    public ResponseEntity<String> cadastrarContato(@PathVariable String x){
			String responseString = "";
		
			//String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BRL/DCR";
			String getUrl = x;

			CloseableHttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet request = new HttpGet(getUrl);

			HttpResponse response = null;
	
			try {             
	
				response = httpClient.execute(request);
				System.out.println(response.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				responseString = new BasicResponseHandler().handleResponse(response);				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println(responseString);	
	
	        return new ResponseEntity<String>(responseString, HttpStatus.CREATED);
	    }
	   
		
	}
