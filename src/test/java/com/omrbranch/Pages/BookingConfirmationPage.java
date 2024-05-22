package com.omrbranch.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;

import lombok.Data;

public class BookingConfirmationPage extends Baseclass {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public static String OrderId;
	public static String FirstHotelName;

	@FindBy(xpath = "//h2[@class='couppon-code']")
	private WebElement printorderId;

	@FindBy(xpath = "(//div[@class='col-md-7 mobile-space-none']//h5)[1]")
	private WebElement printBookHotelName;

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement txtClickWelcome;

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement txtClickMyAccount;

	@FindBy(xpath = "//p[contains(text(),'Hotel ')]")
	private WebElement CompareHotelName;

	@FindBy(xpath = "(//div[@class='room-code'])[1]")
	private WebElement SearchOrderId;

	@FindBy(xpath = "//input[@class='form-control w-50 d-inline-block']")
	private WebElement SearchBox;

	public String verifySearchOrderId() {
		String SearchorderId = elementGetText(SearchOrderId);
		return SearchorderId;

	}

	public void SeachOrderId() {
		elementsendkeys(SearchBox, verifySearchOrderId());

	}

	public String getOrderID() {
		String OrderIdName = elementGetText(printorderId);
		String[] split = OrderIdName.split(" ");
		OrderId = "";
		for (int i = 0; i < 2; i++) {
			OrderId = OrderId + split[i];
		}
		return OrderId;
	}

	public boolean VerifyBookHotelName() {
		String BookHotelName = elementGetText(printBookHotelName);
		boolean equals = BookHotelName.contains(SelectHotelPage.FirstHotelName);
		return equals;

	}

	public void NavigateIntoMyBookingPage() {
		elementClick(txtClickWelcome);
		elementClick(txtClickMyAccount);
	}

	public String getBookHotelName() {
		String BookHotelName = elementGetText(printBookHotelName);
		return BookHotelName;

	}

	public void CompareHotelName() {
		String elementGetText = elementGetText(CompareHotelName);
		boolean contains = elementGetText.contains(SelectHotelPage.FirstHotelName);
		if (contains) {
			System.out.println("hotel name is same");
		} else {
//			System.out.println("not same");
		}

	}

}
