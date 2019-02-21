package com.hid.step;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MultiplicationBDD {
	private String url;
	private Response R;
	@Given("^calculator multiply resource url$")
	public void calculator_multiply_resource_url(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);

		this.url = list.get(0).get("GET");
	 
	}

	@When("^user provide input for multiply \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_provide_input_for_multiply_and(String arg1, String arg2) throws Throwable {
		String resource = url + "/" + arg1 + "/" + arg2;

		R = RestAssured.given().when().get(resource).thenReturn();
		System.out.println(R.asString());

	}

	@Then("^user verify multiply api response:$")
	public void user_verify_multiply_api_response(DataTable dt) throws Throwable {
		 List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		 String rCode= new Integer(R.statusCode()).toString();
		 boolean status=false;
		 if(list.get(0).get("ResponseCode").equals(rCode))
		 {
			 status=true;
		 }
		 Assert.assertTrue(status);
		 Assert.assertArrayEquals(new String[] {list.get(0).get("Output")}, new String[] {R.asString()});
	}

}
