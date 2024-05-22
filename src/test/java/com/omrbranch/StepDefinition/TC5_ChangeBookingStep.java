package com.omrbranch.StepDefinition;

import com.omrbranch.PageObjectManager.PageObjectManager;
import com.omrbranch.Pages.BookingConfirmationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_ChangeBookingStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User navigate into the my booking page")
	public void user_navigate_into_the_my_booking_page() {
		pom.getBookingConfirmationPage().NavigateIntoMyBookingPage();
	}

	@Then("User should verify the after navigating my booking success message {string}")
	public void user_should_verify_the_after_navigating_my_booking_success_message(String string) {
		String verifyBookingMsg = pom.getMyBookingPage().verifyBookingMsg();
		boolean contains = verifyBookingMsg.contains(verifyBookingMsg);
		System.out.println("Bookings Msg : " + verifyBookingMsg);
		System.out.println(contains);

	}

	@When("User search the order id")
	public void user_search_the_order_id() {
		pom.getBookingConfirmationPage().SeachOrderId();

	}

	@Then("User should verify the same booked hotelname is present or not")
	public void user_should_verify_the_same_booked_hotelname_is_present_or_not() {
//		pom.getBookingConfirmationPage().CompareHotelName();
		String printFirstHotelName = pom.getSelectHotelPage().verifyFirstHotelName();
		System.out.println("Hotel Name is Same : " + printFirstHotelName);
		String printBookHotelName = pom.getMyBookingPage().PrintBookHotelName();
		System.out.println("Hotel Name is Same : " + printBookHotelName);
		boolean contains = printFirstHotelName.contains(printBookHotelName);
		System.out.println("Hotel Name is Same : " + contains);

	}

	@Then("User should verify the hotel price")
	public void user_should_verify_the_hotel_price() {
		String printFirstHotelPrice = pom.getSelectHotelPage().PrintFirstHotelPrice();
		String printHotelPrice = pom.getMyBookingPage().PrintHotelPrice();
		boolean contains = printFirstHotelPrice.contains(printHotelPrice);
		System.out.println("Hotel Price is Same : " + printFirstHotelPrice);
		System.out.println("Hotel Price is Same : " + contains);
	}

	@Then("User should verify the order id")
	public void user_should_verify_the_order_id() {

		String printOrderID = pom.getMyBookingPage().PrintOrderID();
		boolean equals = BookingConfirmationPage.OrderId.equals(printOrderID);
		System.out.println("Order Id : " + printOrderID);
		System.out.println(BookingConfirmationPage.OrderId);
	}

	@When("User modify the Check-In Date {string}")
	public void user_modify_the_check_in_date(String string) {
		pom.getMyBookingPage().ModifyCheckInDate();
	}

	@Then("User should verify after modify Check-In Date success message {string}")
	public void user_should_verify_after_modify_check_in_date_success_message(String string) {
		String verifyBookingMsg = pom.getMyBookingPage().BookingUpdateMsg();
		System.out.println("Booking Update Success Msg : " + verifyBookingMsg);
	}

	@When("User search the order id {string}")
	public void user_search_the_order_id(String string) {
		pom.getBookingConfirmationPage().SeachOrderId();

	}

	@When("User modify the firstdisplayed order id {string}")
	public void user_modify_the_firstdisplayed_order_id(String string) {
		pom.getMyBookingPage().ModifyCheckInDate();

	}

}
