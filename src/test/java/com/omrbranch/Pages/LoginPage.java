package com.omrbranch.Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;

public class LoginPage extends Baseclass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// 1.Login Feature
	@FindBy(id = "email")
	private WebElement txtusername;

	@FindBy(id = "pass")
	private WebElement txtpassword;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement LoginBtn;

	@FindBy(id = "errorMessage")
	private WebElement txtLoginErrorMsg;

	// 1,-->,3 Login to hotel booking page with valid credientials
	public void Login(String username, String password) {
		elementsendkeys(txtusername, username);
		elementsendkeys(txtpassword, password);
		elementClick(LoginBtn);
	}

	// 2.Login to hotel booking page with valid credientials useing enter key
	public void LoginEnterKey(String username, String password) throws AWTException {
		elementsendkeys(txtusername, username);
		elementsendkeys(txtpassword, password);
		Enterkey();
	}

	// 3.Login to hotel booking page with Invalid credientials
	public String LoginErrorMsg() {
		String LoginErrorMsg = elementGetText(txtLoginErrorMsg);
		return LoginErrorMsg;
	}

}
