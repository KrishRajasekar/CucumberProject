package com.omrbranch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;

public class SearchHotelPage extends Baseclass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Hotel Booking']")
	private WebElement txtHotelBookingClick;

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement txtLoginSuccessMsg;

	@FindBy(id = "state")
	private WebElement ddnState;

	@FindBy(id = "city")
	private WebElement ddnCity;

//	@FindBy(xpath = "//textarea[@class='select2-search__field']")
//	private WebElement txtRoomTypeClick;

	@FindBy(id = "room_type")
	private WebElement ddnRoomType;

	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement txtCheckIn;

	@FindBy(xpath = "//a[text()='29']")
	private WebElement txtcheckInDate;

	@FindBy(xpath = "//input[@name='check_out']")
	private WebElement txtCheckout;

	@FindBy(xpath = "//a[text()='31']")
	private WebElement txtcheckOutDate;

	@FindBy(id = "no_rooms")
	private WebElement ddnNoOfRoom;

	@FindBy(id = "no_adults")
	private WebElement ddnNoOfAdults;

	@FindBy(id = "no_child")
	private WebElement txtChild;

	@FindBy(xpath = "//iframe[@src='https://omrbranch.com/hotelsearch-iframe']")
	private WebElement txtframe;

	@FindBy(xpath = "//button[@id='searchBtn']")
	private WebElement txtSearchClick;

	@FindBy(xpath = "//div[text()='Please select state']")
	private WebElement txtStateErrorMsg;

	@FindBy(xpath = "//div[text()='Please select city']")
	private WebElement txtCityErrorMsg;

	@FindBy(xpath = "//div[text()='Please select Check-in date']")
	private WebElement txtCheckInErrorMsg;

	@FindBy(xpath = "//div[text()='Please select Check-out date']")
	private WebElement txtCheckOutErrorMsg;

	@FindBy(xpath = "//div[text()='Please select no. of rooms']")
	private WebElement txtSelectRoomsErrorMsg;

	@FindBy(xpath = "//div[text()='Please select no. of adults']")
	private WebElement txtAdultsErrorMsg;

	public String getLoginSuccessMsg() {
		String LoginSuccessMsg = elementGetText(txtLoginSuccessMsg);
		return LoginSuccessMsg;
	}

	// 1.Verify Search Hotel enter in valid credientials
	public void SearchHotels(String stateName, String cityName, String roomType, String chekcInDate,
			String checkOutDate, String noOfRooms, String adultCount, String childCount) {
		elementClick(txtHotelBookingClick);
		SelectByVisisbilityText(ddnState, stateName);
		SelectByVisisbilityText(ddnCity, cityName);
		SelectRoomType(roomType);
		elementClick(txtCheckIn);
		elementClick(txtcheckInDate);
		elementClick(txtCheckout);
		elementClick(txtcheckOutDate);
		SelectByVisisbilityText(ddnNoOfRoom, noOfRooms);
		SelectByVisisbilityText(ddnNoOfAdults, adultCount);
		elementsendkeys(txtChild, childCount);
		FrameByName(txtframe);
		elementClick(txtSearchClick);
	}

	public void SelectRoomType(String roomType) {
//		String s = "Standard/Deluxe/Suite/Luxury/Studio";
		String[] split = roomType.split("/");
		for (String c : split) {
			SelectByVisisbilityText(ddnRoomType, c);
		}
	}

	// 2.Verify Search Hotel enter in manatory fields
	public void SearchHotelManatory(String stateName, String cityName, String chekcInDate, String checkOutDate,
			String noOfRooms, String adultCount) {
		elementClick(txtHotelBookingClick);
		SelectByVisisbilityText(ddnState, stateName);
		SelectByVisisbilityText(ddnCity, cityName);
		elementClick(txtCheckIn);
		elementClick(txtcheckInDate);
		elementClick(txtCheckout);
		elementClick(txtcheckOutDate);
		SelectByVisisbilityText(ddnNoOfRoom, noOfRooms);
		SelectByVisisbilityText(ddnNoOfAdults, adultCount);
		FrameByName(txtframe);
		elementClick(txtSearchClick);
	}

//	Verify Click Search button without enter values in the fieldsClick Search
	public void ClickSearch() {
		elementClick(txtHotelBookingClick);
		FrameByName(txtframe);
		elementClick(txtSearchClick);
		ParentFrame();
	}

	// without field search Click Error Message
	public String getStateNameErrorMsg() {
		String StateErrormsg = elementGetText(txtStateErrorMsg);
		return StateErrormsg;
	}

	public String getCityNameErrorMsg() {
		String CityErrorMsg = elementGetText(txtCityErrorMsg);
		return CityErrorMsg;
	}

	public String getCheckInDateErrorMsg() {
		String CheckInErrorMsg = elementGetText(txtCheckInErrorMsg);
		return CheckInErrorMsg;
	}

	public String getCheckOutDateErrorMsg() {
		String CheckOutErrorMsg = elementGetText(txtCheckOutErrorMsg);
		return CheckOutErrorMsg;

	}

	public String getNoOfRoomErrorMsg() {
		String NoOfRoomErrorMsg = elementGetText(txtSelectRoomsErrorMsg);
		return NoOfRoomErrorMsg;

	}

	public String getNoOfAdultsErrorMsg() {
		String NoOfAdultErrorMsg = elementGetText(txtAdultsErrorMsg);
		return NoOfAdultErrorMsg;
	}
}
