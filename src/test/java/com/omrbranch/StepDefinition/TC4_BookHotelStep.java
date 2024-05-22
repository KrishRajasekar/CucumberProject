package com.omrbranch.StepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.omrbranch.PageObjectManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep {
	PageObjectManager pom = new PageObjectManager();

	@When("User add the guest details {string},{string},{string},{string} and {string},")
	public void user_add_the_guest_details_and(String ddnMr, String firstName, String lastName, String mobNo,
			String emailId) {
		pom.getBookHotelPage().AddGuestDetails(ddnMr, firstName, lastName, mobNo, emailId);

	}

	@When("User add the GST details {string}, {string} and {string},")
	public void user_add_the_gst_details_and(String RegNo, String ComName, String ComAddress) {
		pom.getBookHotelPage().AddGstDetails(RegNo, ComName, ComAddress);
	}

	@When("User add the special request {string}")
	public void user_add_the_special_request(String SplReq) {
		pom.getBookHotelPage().AddSpecialReq(SplReq);
	}

	@When("User enter the payment details,procced with cardtype {string}")
	public void user_enter_the_payment_details_procced_with_cardtype(String cardType,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();

		pom.getBookHotelPage().AddPaymentDetails(cardType, asMaps.get(0).get("SelectCard"), asMaps.get(0).get("CardNo"),
				asMaps.get(0).get("CardName"), asMaps.get(0).get("Month"), asMaps.get(0).get("Year"),
				asMaps.get(0).get("Cvv"));
	}

	@Then("User should verify after hotel booking success message {string} and save order id")
	public void user_should_verify_after_hotel_booking_success_message_and_save_order_id(String exp_bookHotelName) {
		String act_bookHotelName = pom.getBookingConfirmationPage().getOrderID();
		boolean contains = act_bookHotelName.contains(exp_bookHotelName);
		System.out.println(contains);

	}

	@Then("User should verify same selected hotel is booked or not")
	public void user_should_verify_same_selected_hotel_is_booked_or_not() {
		pom.getBookingConfirmationPage().CompareHotelName();
	}

	@When("User add the without Special Request")
	public void user_add_the_without_special_request() {
		pom.getBookHotelPage().WithOutSplReq();

	}

	@When("User without entering any field click submit button")
	public void user_without_entering_any_field_click_submit_button() {
		pom.getBookHotelPage().WithOutFiledClickSearchBtn();
	}

	@When("User add the without GST Details")
	public void user_add_the_without_gst_details() {
		pom.getBookHotelPage().WithOutGstDetails();
	}

	@Then("User should verify after payment details error message {string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_payment_details_error_message_and(String exp_paymentTypeErrorMsg,
			String exp_cardTypeErrorMsg, String exp_cardNoErrorMsg, String exp_cardNameErrorMsg,
			String exp_cardMonthErrorMsg, String exp_cardCvvErrorMsg) {

		String act_paymentTypeErrorMsg = pom.getBookHotelPage().PaymentTypeErrorMsg();
		Assert.assertEquals("verify paymentType Error Msg", exp_paymentTypeErrorMsg, act_paymentTypeErrorMsg);
		System.out.println("Payment Error Msg :" + act_paymentTypeErrorMsg);

		String act_cardTypeErrorMsg = pom.getBookHotelPage().CardTypeErrorMsg();
		Assert.assertEquals("verify CardType Error Msg", exp_cardTypeErrorMsg, act_cardTypeErrorMsg);
		System.out.println("CardType Error Msg :" + act_cardTypeErrorMsg);

		String act_cardNoErrorMsg = pom.getBookHotelPage().CardNoErrorMsg();
		Assert.assertEquals("verify CardNo Error Msg", exp_cardNoErrorMsg, act_cardNoErrorMsg);
		System.out.println("CardNo Error Msg :" + act_cardNoErrorMsg);

		String act_cardNameErrorMsg = pom.getBookHotelPage().CardNameErrorMsg();
		Assert.assertEquals("verify CardName Error Msg", exp_cardNameErrorMsg, act_cardNameErrorMsg);
		System.out.println("CardName Error Msg :" + act_cardNameErrorMsg);

		String act_cardMonthErrorMsg = pom.getBookHotelPage().CardMonthErrorMsg();
		Assert.assertEquals("verify CardMonth Error Msg", exp_cardMonthErrorMsg, act_cardMonthErrorMsg);
		System.out.println("CardMonth Error Msg :" + act_cardMonthErrorMsg);

		String act_cardCvvErrorMsg = pom.getBookHotelPage().CardCvvErrorMsg();
		Assert.assertEquals("verify CardCvv Error Msg", exp_cardCvvErrorMsg, act_cardCvvErrorMsg);
		System.out.println("CardCvv Error Msg :" + act_cardCvvErrorMsg);

	}

}
