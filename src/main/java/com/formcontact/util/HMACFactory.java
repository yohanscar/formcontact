package com.formcontact.util;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.time.Instant;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import java.security.*;
import java.math.*;
import java.net.URI;

public class HMACFactory {

	public static HttpGet implementsHMAC(HttpGet request, JSONObject json) {
		String requestContentBase64String="";;
		String requestSignatureBase64String="";
		URI u = request.getURI();

		String requestUri = u.toString();

		UUID uuid = UUID.randomUUID();
		String nonce = uuid.toString();
        nonce.replaceAll( "-" , "");
		String requestTimeStamp = new Long(java.time.Instant.now().getEpochSecond()).toString();

		String content = json.toString();

		MessageDigest m=null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		m.update(content.getBytes(),0,content.length());

		String md5Content = "" + new BigInteger(1,m.digest()).toString(16);
		
		requestContentBase64String = Base64.encodeBase64String(md5Content.getBytes());

		String signatureRawData = "8415c4fb-f7cd-471d-ac73-5ffbb586db7f" + "GET" + requestUri + requestTimeStamp +nonce +requestContentBase64String;
		String x = "tSQLNweF9i8UDEg/+/J8IvI+YpM8bPirEC0AhtAqzbE=";

		String secretKeyByteArray = Base64.decodeBase64(x).toString();
		
			try {
			 String secret = secretKeyByteArray;
			 //String message = ;
		
			 Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			 SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
			 sha256_HMAC.init(secret_key);
		
			 requestSignatureBase64String = Base64.encodeBase64String(sha256_HMAC.doFinal(signatureRawData.getBytes("UTF-8")));
			 System.out.println(requestSignatureBase64String);
			}
			catch (Exception e){
			 System.out.println("Error");
			}
		
	   
       String AuthenticationHeaderValue = "amx" +" 8415c4fb-f7cd-471d-ac73-5ffbb586db7f" +":" + requestSignatureBase64String +":" + nonce +":" + requestTimeStamp;

		request.addHeader("Authorization", AuthenticationHeaderValue);
		System.out.println("Authorization: "+AuthenticationHeaderValue);
		return request;	
	}
}