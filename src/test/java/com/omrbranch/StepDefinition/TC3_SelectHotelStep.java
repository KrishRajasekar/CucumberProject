package com.omrbranch.StepDefinition;

import org.junit.Assert;

import com.omrbranch.PageObjectManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

//1
	@When("User save the first hotel name and price")
	public void user_save_the_first_hotel_name_and_price() {
		String printFirstHotelName = pom.getSelectHotelPage().PrintFirstHotelName();
		String printFirstHotelPrice = pom.getSelectHotelPage().PrintFirstHotelPrice();
		System.out.println("Save First Hotelprice : " + printFirstHotelPrice);
	}

	@When("User click the first hotel")
	public void user_click_the_first_hotel() {
		pom.getSelectHotelPage().ClickContinueBtn();
	}

	@When("User click Ok the Alert")
	public void user_click_ok_the_alert() {
		pom.getSelectHotelPage().AlertOk();
	}

	@Then("User should verify after select hotel success message {string}")
	public void user_should_verify_after_select_hotel_success_message(String exp_BookHotelSuccessMsg) {
		String act_printBookHotelName = pom.getBookHotelPage().PrintBookHotelName();
		boolean contains = act_printBookHotelName.contains(exp_BookHotelSuccessMsg);
		System.out.println("Select Hotel Msg :" + act_printBookHotelName);
		Assert.assertTrue(contains);
		System.out.println(contains);
	}

//2.
	@When("User click Cancel the Alert")
	public void user_click_cancel_the_alert() {
		pom.getSelectHotelPage().AlertCancel();
	}

	@Then("User should verify after same search hotel success message {string}")
	public void user_should_verify_after_same_search_hotel_success_message(String exp_SameSelectHotelSuccessMsg) {
		String act_SameSelectHotelSuccessMsg = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
		Assert.assertEquals("Verify Same Select Hotel Success Msg", act_SameSelectHotelSuccessMsg,
				exp_SameSelectHotelSuccessMsg);

	}

}
