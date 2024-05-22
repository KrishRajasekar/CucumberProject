package com.omrbranch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;
import lombok.Data;

public class BookHotelPage extends Baseclass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "own")
	private WebElement txtclickMr;

	@FindBy(id = "user_title")
	private WebElement ddnSelectMr;

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "user_phone")
	private WebElement txtMobNo;

	@FindBy(id = "user_email")
	private WebElement txtEmailId;

	@FindBy(id = "gst")
	private WebElement txtClickGst;

	@FindBy(id = "gst_registration")
	private WebElement txtGstRegNo;

	@FindBy(id = "company_name")
	private WebElement txtComName;

	@FindBy(id = "company_address")
	private WebElement txtComAddress;

	@FindBy(id = "step1next")
	private WebElement txtClickGstNext;

	@FindBy(xpath = "//input[@id='high']")
	private WebElement txtClickSplReq;

	@FindBy(id = "other_request")
	private WebElement txtSplReq;

	@FindBy(id = "step2next")
	private WebElement txtSplReqNext;

	@FindBy(xpath = "//div[@class='credit-card pm']")
	private WebElement txtClickCreditCard;

	@FindBy(id = "payment_type")
	private WebElement ddnPaymentType;

	@FindBy(id = "card_type")
	private WebElement ddnCardType;

	@FindBy(id = "card_no")
	private WebElement txtCardNo;

	@FindBy(id = "card_name")
	private WebElement txtCardName;

	@FindBy(id = "card_month")
	private WebElement ddnCardMonth;

	@FindBy(id = "card_year")
	private WebElement ddnCardYear;

	@FindBy(xpath = "(//input[@class='form-control'])[5]")
	private WebElement txtCvv;

	@FindBy(id = "submitBtn")
	private WebElement txtSubmitBtn;

	@FindBy(xpath = "//h2[text()=' Booking is Confirmed ']")
	private WebElement PrintBookConform;

	@FindBy(xpath = "//h2[contains(text(),'Book Hotel')]")
	private WebElement PrintBookHotelName;

	@FindBy(xpath = "//div[text()='Please select your card type']")
	private WebElement printPaymentTypeErrorMsg;

	@FindBy(xpath = "//div[text()='Please select your card']")
	private WebElement printCardTypeErrorMsg;

	@FindBy(xpath = "//div[text()='Please provide your card number']")
	private WebElement printCardNoErrorMsg;

	@FindBy(xpath = "//div[text()='Please provide name on your card']")
	private WebElement printCardNameErrorMsg;

	@FindBy(xpath = "//div[text()='Please provide your Card Expiry Date']")
	private WebElement printCardMonthErrorMsg;

	@FindBy(id = "invalid-cvv")
	private WebElement printCardCvvErrorMsg;

	public void AddGuestDetails(String SelectMr, String firstname, String lastname, String MobNo, String EmailId) {
		implicitWait(400);
		elementClick(txtclickMr);
		SelectByVisisbilityText(ddnSelectMr, SelectMr);
		elementsendkeys(txtFirstName, firstname);
		elementsendkeys(txtLastName, lastname);
		elementsendkeys(txtMobNo, MobNo);
		elementsendkeys(txtEmailId, EmailId);

	}

	public void AddGstDetails(String GstRegNo, String ComName, String ComAddress) {
		elementClick(txtClickGst);
		elementsendkeys(txtGstRegNo, GstRegNo);
		elementsendkeys(txtComName, ComName);
		elementsendkeys(txtComAddress, ComAddress);
		elementClick(txtClickGstNext);
	}

	public void AddSpecialReq(String SplReq) {
		elementClick(txtClickSplReq);
		elementsendkeys(txtSplReq, SplReq);
		elementClick(txtSplReqNext);
	}

	public void AddPaymentDetails(String PaymentType, String CardType, String CardNo, String CardName, String Month,
			String CardYear, String Cvv) {
		elementClick(txtClickCreditCard);
		SelectByVisisbilityText(ddnPaymentType, PaymentType);
		SelectByVisisbilityText(ddnCardType, CardType);
		elementsendkeys(txtCardNo, CardNo);
		elementsendkeys(txtCardName, CardName);
		SelectByVisisbilityText(ddnCardMonth, Month);
		SelectByVisisbilityText(ddnCardYear, CardYear);
		elementsendkeys(txtCvv, Cvv);
		elementClick(txtSubmitBtn);

	}

	public String PrintBookConform() {
		String BookConform = elementGetText(PrintBookConform);
		return BookConform;

	}

	public String PrintBookHotelName() {
		String HotelName = elementGetText(PrintBookHotelName);
		return HotelName;

	}

	public String PaymentTypeErrorMsg() {
		String PaymentTypeError = elementGetText(printPaymentTypeErrorMsg);
		return PaymentTypeError;

	}

	public String CardTypeErrorMsg() {
		String CardTypeError = elementGetText(printCardTypeErrorMsg);
		return CardTypeError;

	}

	public String CardNoErrorMsg() {
		String CardNoError = elementGetText(printCardNoErrorMsg);
		return CardNoError;
	}

	public String CardNameErrorMsg() {
		String CardNameError = elementGetText(printCardNameErrorMsg);
		return CardNameError;

	}

	public String CardMonthErrorMsg() {
		String CardMonthError = elementGetText(printCardMonthErrorMsg);
		return CardMonthError;
	}

	public String CardCvvErrorMsg() {
		String CardCvvError = elementGetText(printCardCvvErrorMsg);
		return CardCvvError;
	}

	public void WithOutFiledClickSearchBtn() {
		elementClick(txtClickCreditCard);
		elementClick(txtSubmitBtn);

	}

	public void WithOutSplReq() {
		elementClick(txtSplReqNext);

	}

	public void WithOutGstDetails() {
		elementClick(txtClickGstNext);

	}
}
