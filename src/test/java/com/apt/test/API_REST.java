package com.apt.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class API_REST {
public static void main(String[] args) {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String PostResponse=given().log().all().queryParam("key","qaclick123")
	.header("Content-Type", "application/json;charset=UTF-8")
	.body("{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"Frontline house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"French-IN\"\r\n"
			+ "}").when().post("maps/api/place/add/json")
	        .then().log().all().statusCode(200).extract().response().asString();
	        System.out.println(PostResponse);
	        JsonPath js=new JsonPath(PostResponse);
			String placeid=js.getString("place_id");
			System.out.println(placeid);
			
			//put
			given()
			   .log().all()
			   .queryParam("Place_id", placeid)
			   .queryParam("key","qaclick123")
			   .header("Content-Type", "application/json;charset=UTF-8")
			   .body("{\r\n"
			   		+ "\"place_id\":\"cbeef2741cce7486303e61bbc3df2945\",\r\n"
			   		+ "\"address\":\"70 winter walk, USA\",\r\n"
			   		+ "\"key\":\"qaclick123\"\r\n"
			   		+ "}")
			.when().put("(\"maps/api/place/add/json\")")
		    .then()
		    .assertThat().statusCode(200);
			
			//get
			given()
			   .log().all()
			   .queryParam("Place_id", placeid)
			   .queryParam("key","qaclick123")
			   .header("Content-Type", "application/json;charset=UTF-8")
            .when().get("(\"maps/api/place/add/json\")")
		    .then()
		    .assertThat().statusCode(200)
		    .extract()
		    .response()
		    .toString();
}
}
