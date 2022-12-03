package com.json;

import io.restassured.path.json.JsonPath;

public class JsonSample {
	public static void main(String[] args) {
		int sum=0;
		JsonPath js = new JsonPath(PayLoad.payLoad1());
		int count = js.getInt("courses.size()");
		System.out.println("No of courses returned by API:"+count);
		int amt=js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount:"+amt);
		String title=js.getString("courses[0].title");
		System.out.println("Title of the first course:"+title);
		System.out.println("All course titles and their respective Prices:");
		for(int i=0;i<count;i++) {
			String alltitles=js.get("courses["+i+"].title");
			int allprices=js.getInt("courses["+i+"].price");
			System.out.println(alltitles +"=>"+ allprices);
		}
		String copies=js.getString("courses[2].copies");
		System.out.println("No of copies sold by RPA Course:"+copies);
		for(int i=0;i<count;i++) {
			int price=js.getInt("courses["+i+"].price");
			sum=sum+price;
			}
		System.out.println("Sum of all Course prices:"+ sum);
		if(sum==amt) {
			System.out.println("Sum of all Course prices matches with Purchase Amount: True");
		}
		else
		{
			System.out.println("Sum of all Course prices matches with Purchase Amount: False");
		}
		
		
		
//		String amt = js.getString("board.amount");
//		System.out.println(amt);
//		String web = js.getString("board.website");
//		System.out.println(web);
//		String object = js.getString("courses[0]");
//		System.out.println(object);
//		for (int i = 0; i < count; i++) {
//			String data = js.get("courses[" + i + "].price");
//			System.out.println(data);
		
	}
}
