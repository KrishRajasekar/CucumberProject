package com.omrbranch.StepDefinition;

import org.junit.Assert;

import com.omrbranch.BaseClass.Baseclass;
import com.omrbranch.PageObjectManager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends Baseclass {

	PageObjectManager pom = new PageObjectManager();

// 1
	@When("User search hotels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotels_and(String state, String city, String RoomType, String checkIn, String checkOut,
			String NoOfRoom, String NoOfAdult, String NoOfChildern) {

		pom.getSearchHotelPage().SearchHotels(state, city, RoomType, state, checkOut, NoOfRoom, NoOfAdult,
				NoOfChildern);
	}

	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String exp_SelectHotelMsg) {
		String act_selectHotelSuccessMsg = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
		Assert.assertEquals("verify selecthotel Success Msg", exp_SelectHotelMsg, act_selectHotelSuccessMsg);
		System.out.println("Search Hotel Msg : " + act_selectHotelSuccessMsg);

	}

//2
	@When("User search hotels {string},{string},{string},{string},{string} and {string} in the fields and")
	public void user_search_hotels_and_in_the_fields_and(String state, String city, String checkIn, String checkOut,
			String NoOfRoom, String NoOfAdult) {
		pom.getSearchHotelPage().SearchHotelManatory(state, city, state, checkOut, NoOfRoom, NoOfAdult);

	}

//3
	@When("User click search button")
	public void user_click_search_button() {
		pom.getSearchHotelPage().ClickSearch();
	}

	@Then("User should verify after search hotel error message {string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_search_hotel_error_message_and(String exp_stateNameErrorMSg,
			String exp_cityNameErrorMsg, String exp_checkInDateErrorMsg, String exp_checkOutDateErrorMsg,
			String exp_noOfRoomErrorMsg, String exp_noOfAdultsErrorMsg) {

		String act_stateNameErrorMsg = pom.getSearchHotelPage().getStateNameErrorMsg();
		Assert.assertEquals("verify stateName Error Msg", exp_stateNameErrorMSg, act_stateNameErrorMsg);
		System.out.println("Error Msg :" + act_stateNameErrorMsg);

		String act_cityNameErrorMsg = pom.getSearchHotelPage().getCityNameErrorMsg();
		Assert.assertEquals("verify CityName Error Msg", exp_cityNameErrorMsg, act_cityNameErrorMsg);
		System.out.println("Error Msg :" + act_cityNameErrorMsg);

		String act_checkInDateErrorMsg = pom.getSearchHotelPage().getCheckInDateErrorMsg();
		Assert.assertEquals("verify ChechInDate Error Msg", exp_checkInDateErrorMsg, act_checkInDateErrorMsg);
		System.out.println("Error Msg :" + act_checkInDateErrorMsg);

		String act_chickOutDateErrorMsg = pom.getSearchHotelPage().getCheckOutDateErrorMsg();
		Assert.assertEquals("verify ChechOutDate Error Msg", exp_checkOutDateErrorMsg, act_chickOutDateErrorMsg);
		System.out.println("Error Msg :" + act_chickOutDateErrorMsg);

		String act_noOfRoomErrorMsg = pom.getSearchHotelPage().getNoOfRoomErrorMsg();
		Assert.assertEquals("verify NoOfRooms Error Msg", act_noOfRoomErrorMsg, exp_noOfRoomErrorMsg);
		System.out.println("Error Msg :" + act_noOfRoomErrorMsg);

		String act_noOfAdultsErrorMsg = pom.getSearchHotelPage().getNoOfAdultsErrorMsg();
		Assert.assertEquals("verify NoOfAdults Error Msg", act_noOfAdultsErrorMsg, exp_noOfAdultsErrorMsg);
		System.out.println("Error Msg :" + act_noOfAdultsErrorMsg);

	}

//4
	@Then("User should verify all hotel listed in the selected roomtype {string}")
	public void user_should_verify_all_hotel_listed_in_the_selected_roomtype(String exp_selectedRoomType) {
		boolean act_hotelNameEndsWithRoomType = pom.getSelectHotelPage().HotelNameEndsWithRoomType();
		System.out.println("RoomType EndsWith :" + act_hotelNameEndsWithRoomType);

	}

//5
	@Then("User should verify all listed hotel roomtype displayed in header {string}")
	public void user_should_verify_all_listed_hotel_roomtype_displayed_in_header(String allselectedRoomType) {
		boolean hotelNameEndsWithRoomType = pom.getSelectHotelPage().HotelNameEndsWithRoomType();
		System.out.println("All Listed RoomType : " + hotelNameEndsWithRoomType);
	}

//6
	@When("User click sorting functionality price Low to High")
	public void user_click_sorting_functionality_price_low_to_high() {

		pom.getSelectHotelPage().PriceLowToHigh();
	}

	@Then("User Should verify the displayed hotel names are in price Low to High")
	public void user_should_verify_the_displayed_hotel_names_are_in_price_low_to_high() {

		pom.getSelectHotelPage().VerifyHotelPriceLowToHigh();
	}

//7
	@When("User click sorting functionality price High to Low")
	public void user_click_sorting_functionality_price_high_to_low() {

		pom.getSelectHotelPage().PriceHighToLow();
	}

	@Then("User Should verify the displayed hotel names are in price High to Low")
	public void user_should_verify_the_displayed_hotel_names_are_in_price_high_to_low() {

		pom.getSelectHotelPage().VerifyHotelPriceHighToLow();
	}

//8
	@When("User click sorting functionality name Ascending")
	public void user_click_sorting_functionality_name_ascending() {

		pom.getSelectHotelPage().HotelNameAsc();
	}

	@Then("User Should verify the displayed hotel names are in ascending")
	public void user_should_verify_the_displayed_hotel_names_are_in_ascending() {

		pom.getSelectHotelPage().VerifyHotelNameAscending();
	}

//9
	@When("User click sorting functionality name Descending")
	public void user_click_sorting_functionality_name_descending() {
		pom.getSelectHotelPage().HotelNameDesc();
	}

	@Then("User Should verify the displayed hotel names are in descending")
	public void user_should_verify_the_displayed_hotel_names_are_in_descending() {
		pom.getSelectHotelPage().VerifyHotelNameDescending();
	}

}
