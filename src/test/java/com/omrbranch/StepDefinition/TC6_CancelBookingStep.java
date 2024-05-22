package com.omrbranch.StepDefinition;

import org.junit.Assert;

import com.omrbranch.PageObjectManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC6_CancelBookingStep {
	PageObjectManager pom = new PageObjectManager();

	@When("User cancel the New order id")
	public void user_cancel_the_new_order_id() {
		pom.getMyBookingPage().CancelBooking();
	}

	@Then("User should verify the after cancel success message {string}")
	public void user_should_verify_the_after_cancel_success_message(String exp_printBookCancelMsg) {
		String act_printBookCancelMsg = pom.getMyBookingPage().PrintBookCancelMsg();
		Assert.assertEquals("verify Book Cancel Msg", exp_printBookCancelMsg, act_printBookCancelMsg);
		System.out.println("Booking Cancel Msg : " + act_printBookCancelMsg);

	}

	@When("User cancel the Existing order id {string}")
	public void user_cancel_the_existing_order_id(String string) {
		pom.getMyBookingPage().CancelBooking();
	}

	@When("User cancel the First displayed order id")
	public void user_cancel_the_first_displayed_order_id() {
		pom.getMyBookingPage().CancelBooking();
	}

}
