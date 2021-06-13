package net.fakerestapi.APITestingFramework.steps;

import io.cucumber.java.en.Then;
import net.fakerestapi.APITestingFramework.apis.GetBookAPI;
import net.fakerestapi.APITestingFramework.apis.GetlistAPI;
import org.apache.http.HttpStatus;
import org.testng.Assert;

//import net.fakerestapi.APITestingFramework.apis.OrderAPI;
import net.fakerestapi.APITestingFramework.base.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BookSteps {

	GetlistAPI getlist = new GetlistAPI();
	GetBookAPI getBookAPI = new GetBookAPI();

	@When("^I want go to book API$")
	public void setUp() {
		
		BaseTest.init();
		
	}

	@Then("^I verify the status code as (.*)$")
	public void i_verify_the_status_code_as(int statusCode) {
		Assert.assertEquals(getlist.getStatusCode(), statusCode);
	}

	@Then("^I want to search '(.*)' in list$")
	public void i_want_to_search(String string) {
		if(getlist.findBook(string))
			Assert.assertTrue(true);
		else
			Assert.fail("The book doesn't exist in books list");
	}

	@Then("^I want to search '(.*)' not in list$")
	public void i_want_to_search_not(String string) {
		if(!getlist.findBook(string))
			Assert.assertTrue(true);
		else
			Assert.fail("The book exist in books list");
	}

	@Then("^I want to count total books equal (.*)$")
	public void i_want_to_count_total_books_equals(int number) {
		Assert.assertEquals(getlist.countBook(),number);
	}

	@Then("^I verify book ID \"(.*)\" the status OK$")
	public void i_verify_book_ID_the_status_OK(int bookID) {
		Assert.assertEquals(getBookAPI.getStatusCode(bookID), HttpStatus.SC_OK);
	}

	@Then("^I verify schema of book ID \"(.*)\"$")
	public void i_verify_schema_of_book_id(int bookID) {
		getBookAPI.validateJSONSchema(bookID);
	}
}
