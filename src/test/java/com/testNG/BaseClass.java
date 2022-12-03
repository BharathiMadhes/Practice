package com.testNG;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BaseClass {
public static String jsonRead() throws IOException {
	RestAssured.baseURI="https://rahulshettyacademy.com";
	byte[] inputByte=Files.readAllBytes(Paths.get("src\\\\test\\\\resources\\\\Json\\\\Test.json"));
	return new String(inputByte);
	
}
}
