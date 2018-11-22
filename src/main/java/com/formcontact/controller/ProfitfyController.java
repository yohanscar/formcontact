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
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyBrltoDcr/")
	    public ResponseEntity<String> brlDcr(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BRL/DCR";

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
	   
		
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyBrltoLtc/")
	    public ResponseEntity<String> brlLtc(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BRL/LTC";

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
	   
		
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyBrltoBtc/")
	    public ResponseEntity<String> brlBtc(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BRL/BTC";

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
	   
		
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyBtctoLtc/")
	    public ResponseEntity<String> btcLtc(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BTC/LTC";

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
	   
		
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyBtctoDcr/")
	    public ResponseEntity<String> btcDcr(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/BTC/DCR";

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
	   
		
	    @RequestMapping(method=RequestMethod.GET, value="/profitfyLtctoDcr/")
	    public ResponseEntity<String> LtcDcr(){
			String responseString = "";

			String getUrl = "https://profitfy.trade/api/v1/public/orderbook/LTC/DCR";

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
