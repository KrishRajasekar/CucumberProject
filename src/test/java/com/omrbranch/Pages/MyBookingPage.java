package com.omrbranch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;
import lombok.Data;

public class MyBookingPage extends Baseclass {

	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	public static String HotelPrice;

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement txtClickWelcome;

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement txtClickMyAccount;

	@FindBy(xpath = "(//div[@class='col-md-5'])[1]")
	private WebElement PrintBooking;

	@FindBy(xpath = "//input[@class='form-control w-50 d-inline-block']")
	private WebElement txtSearchOrderId;

	@FindBy(xpath = "(//div[@class='room-code'])[4]")
	private WebElement PrintOrderId;

	@FindBy(xpath = "(//h5[text()='Hilton Standard'])[1]")
	private WebElement PrintBookHotelName;

	@FindBy(xpath = "(//strong[@class='total-prize'])[3]")
	private WebElement PrintHotelPrice;

	@FindBy(xpath = "(//button[@class='edit btn filter_btn'])[1]")
	private WebElement txtClickEditBtn;

	@FindBy(xpath = "//input[@name='check_in']")
	private WebElement txtClickChechInDate;

	@FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
	private WebElement txtClickCheckInDate01;

	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement txtClickConform;

	@FindBy(xpath = "//li[text()='Booking updated successfully']")
	private WebElement PrintBookingUpdateMsg;

	@FindBy(xpath = "(//a[text()='Cancel'])[1]")
	private WebElement txtClickCancel;

	@FindBy(xpath = "//li[text()='Your booking cancelled successfully']")
	private WebElement PrintBookCancelMsg;

	public void ModifyCheckInDate() {
		elementClick(txtClickWelcome);
		elementClick(txtClickMyAccount);
		elementClick(txtClickEditBtn);
		elementClick(txtClickChechInDate);
		elementClick(txtClickCheckInDate01);
		elementClick(txtClickConform);

	}

	public void CancelBooking() {
//		elementClick(txtClickWelcome);
//		elementClick(txtClickMyAccount);
//		elementsendkeys(txtSearchOrderId, SearchOrderId);
		implicitWait();
		elementClick(txtClickCancel);
		AlertClickok();
//		elementClick(txtClickConform);

	}

	public String verifyBookingMsg() {
		String BookingMsg = elementGetText(PrintBooking);
		return BookingMsg;
	}

	public String BookingUpdateMsg() {
		String BookingUpdateMsg = elementGetText(PrintBookingUpdateMsg);
		return BookingUpdateMsg;
	}

	public String PrintOrderID() {
		String OrderId = elementGetText(PrintOrderId);
		return OrderId;

	}

	public String PrintHotelPrice() {
		String HotelPrice = elementGetText(PrintHotelPrice);
		return HotelPrice;

	}

	public String PrintBookHotelName() {
		String BookHotelName = elementGetText(PrintBookHotelName);
		return BookHotelName;

	}

	public String PrintBookCancelMsg() {
		String CancelMsg = elementGetText(PrintBookCancelMsg);
		return CancelMsg;

	}

	public void compareHotelPrice() {

		String elementGetText = elementGetText(PrintHotelPrice);
		System.out.println(elementGetText);
		boolean contains = elementGetText.contains(SelectHotelPage.HotelPrice);
		if (contains = true) {
			System.out.println("Hotel price is same");
		} else {
			System.out.println("not same");
		}

	}

}
