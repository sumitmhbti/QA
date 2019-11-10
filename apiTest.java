import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
public class apiTest {

	@Test
	public void apiGet() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("-----------This is the URI---------------");
		System.out.println(httpRequest);
		System.out.println("--------------------------------------------");
		
		//httpRequest.header("Content-Type","application/json");
		
		Response response = httpRequest.request(Method.GET, "/posts/1");
		System.out.println("-----------This is the response---------------");
		System.out.println(response);
		System.out.println("----------------------------------------------");
		
		String responseBody = response.getBody().asString();
		System.out.println("-----------This is the response as string---------------");
		System.out.println(responseBody);
		System.out.println("----------------------------------------------");
		
		Headers responseHeaders = response.getHeaders();
		System.out.println("-----------This is the Header---------------");
		System.out.println(responseHeaders);
		System.out.println("----------------------------------------------");
		
		int responsestatusCode = response.getStatusCode();
		System.out.println("-----------This is the responsestatusCode---------------");
		System.out.println(responsestatusCode);
		System.out.println("----------------------------------------------");
		
		//To validate the specific JSON key
		JsonPath json = response.jsonPath();
		HashMap<String, String>jsonValue = json.get();
		
		System.out.println("-----------This is the json---------------");
		System.out.println(jsonValue);
		System.out.println("----------------------------------------------");
		
		HashMap<String, Object> mymap = new HashMap<String,Object>();
		mymap.put("userId", 1);
		mymap.put("id", 1);
		mymap.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		mymap.put("body", "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
		System.out.println(mymap);
		
		//assert.jsonValue.equals(mymap);
		Assert.assertEquals(jsonValue, mymap);
		
		
	}
	@Test
	public void apiPost() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("-----------This is the URI---------------");
		System.out.println(httpRequest);
		System.out.println("--------------------------------------------");
		
		httpRequest.header("Content-Type","application/json","charset=UTF-8");
		
		Response response = httpRequest.request(Method.POST, "/posts");
		System.out.println("-----------This is the response---------------");
		System.out.println(response);
		System.out.println("----------------------------------------------");
		
		String payload="{\"title: 'foo',\r\n" + 
				"      body: 'bar',\r\n" + 
				"      userId: 1}";
		

		
		String responseBody = response.getBody().asString();
		System.out.println("-----------This is the response as string---------------");
		System.out.println(responseBody);
		System.out.println("----------------------------------------------");
		
		Headers responseHeaders = response.getHeaders();
		System.out.println("-----------This is the Header---------------");
		System.out.println(responseHeaders);
		System.out.println("----------------------------------------------");
		
		int responsestatusCode = response.getStatusCode();
		System.out.println("-----------This is the responsestatusCode---------------");
		System.out.println(responsestatusCode);
		System.out.println("----------------------------------------------");
		
		//To validate the specific JSON key
		JsonPath json = response.jsonPath();
		HashMap<String, String>jsonValue = json.get();
		
		System.out.println("-----------This is the json---------------");
		System.out.println(jsonValue);
		System.out.println("----------------------------------------------");
		
		HashMap<String, Object> mymap = new HashMap<String,Object>();
	
		mymap.put("id", 101);

		System.out.println(mymap);
		
		Assert.assertEquals(jsonValue, mymap);
		
		
	}
	@Test
	public void apiUpdate() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("-----------This is the URI---------------");
		System.out.println(httpRequest);
		System.out.println("--------------------------------------------");
		
		httpRequest.header("Content-Type","application/json","charset=UTF-8");
		
		Response response = httpRequest.request(Method.PUT, "/posts/1");
		System.out.println("-----------This is the response---------------");
		System.out.println(response);
		System.out.println("----------------------------------------------");
		
		String payload="{\"id: 1,\r\n" + 
				"      title: 'foo',\r\n" + 
				"      body: 'bar',\r\n" + 
				"      userId: 1}";
		

		
		String responseBody = response.getBody().asString();
		System.out.println("-----------This is the response as string---------------");
		System.out.println(responseBody);
		System.out.println("----------------------------------------------");
		
		Headers responseHeaders = response.getHeaders();
		System.out.println("-----------This is the Header---------------");
		System.out.println(responseHeaders);
		System.out.println("----------------------------------------------");
		
		int responsestatusCode = response.getStatusCode();
		System.out.println("-----------This is the responsestatusCode---------------");
		System.out.println(responsestatusCode);
		System.out.println("----------------------------------------------");
		
		//To validate the specific JSON key
		JsonPath json = response.jsonPath();
		HashMap<String, String>jsonValue = json.get();
		
		System.out.println("-----------This is the json---------------");
		System.out.println(jsonValue);
		System.out.println("----------------------------------------------");
		
		HashMap<String, Object> mymap = new HashMap<String,Object>();
		
		mymap.put("id", 1);

		System.out.println(mymap);
		Assert.assertEquals(jsonValue, mymap);
		
		
	}
	@Test
	public void apiDelete() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("-----------This is the URI---------------");
		System.out.println(httpRequest);
		System.out.println("--------------------------------------------");
		
		httpRequest.header("Content-Type","application/json","charset=UTF-8");
		
		Response response = httpRequest.request(Method.DELETE, "/posts/1");
		System.out.println("-----------This is the response---------------");
		System.out.println(response);
		System.out.println("----------------------------------------------");
		
		
		String responseBody = response.getBody().asString();
		System.out.println("-----------This is the response as string---------------");
		System.out.println(responseBody);
		System.out.println("----------------------------------------------");
		
		Headers responseHeaders = response.getHeaders();
		System.out.println("-----------This is the Header---------------");
		System.out.println(responseHeaders);
		System.out.println("----------------------------------------------");
		
		int responsestatusCode = response.getStatusCode();
		System.out.println("-----------This is the responsestatusCode---------------");
		System.out.println(responsestatusCode);
		System.out.println("----------------------------------------------");
		
		
		Assert.assertEquals(responsestatusCode, 200);
				
	}	
	
}
