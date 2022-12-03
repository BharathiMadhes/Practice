package com.testNG;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class TestNgInteg extends BaseClass{
	@Test
	public void postMethod() throws IOException {
	JsonPath js=new JsonPath(BaseClass.jsonRead());	
	given().log().all()
		.body(js.getString("item[0].request.body.raw")).when().post("Library/Addbook.php")
	        .then().log().all().statusCode(200).extract().response().asString();
	        String placeid=js.getString("item[1].request.url.query[0].key");
			String value=js.getString("item[1].request.url.query[0].value");
			System.out.println(placeid);
			System.out.println(value);
			
	}		
	@Test
	public void getMethod() throws IOException {
		JsonPath js=new JsonPath(BaseClass.jsonRead());
	given().log().all()
     		.queryParam(js.getString("item[1].request.url.query[0].key"), js.getString("item[1].request.url.query[0].value"))
			.when().get("Library/Addbook.php")
		    .then().log().all()
		    .assertThat().statusCode(200)
		    .extract()
		    .response()
		    .toString();
	}
	@Test
	public void getMethodByAuthor() throws IOException {
		JsonPath js=new JsonPath(BaseClass.jsonRead());
	given().log().all()
     		.queryParam(js.getString("item[2].request.url.query[0].key"), js.getString("item[2].request.url.query[0].key"))
			.when().get("Library/GetBook.php?AuthorName=John foer")
		    .then().log().all()
		    .assertThat().statusCode(200)
		    .extract()
		    .response()
		    .toString();
}
}
