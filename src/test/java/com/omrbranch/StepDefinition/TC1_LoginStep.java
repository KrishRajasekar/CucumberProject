package com.omrbranch.StepDefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.BaseClass.Baseclass;
import com.omrbranch.PageObjectManager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends Baseclass {

	PageObjectManager pom = new PageObjectManager();

//1
	@Given("User is on the omr branch page")
	public void user_is_on_the_omr_branch_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browser"));
		enterurl(getPropertyFileValue("url"));
		maximizewindow();
		implicitWait(10);
	}

	@When("User login {string} and {string}")
	public void user_login_and(String username, String password) {
		pom.getLoginPage().Login(username, password);

	}

	@Then("User should verify the after login success message as {string}")
	public void user_should_verify_the_after_login_success_message_as(String expLoginSuccessMsg) {
		String actloginSuccessMsg = pom.getSearchHotelPage().getLoginSuccessMsg();
		System.out.println("Welcome Msg :" + actloginSuccessMsg);
		Assert.assertEquals("verify after Login Success Msg", expLoginSuccessMsg, actloginSuccessMsg);
	}

//2
	@When("User login {string} and {string} using enter key")
	public void user_login_and_using_enter_key(String username, String password) throws AWTException {
		pom.getLoginPage().LoginEnterKey(username, password);

	}

//3
	@Then("User should verify the after login error message as {string}")
	public void user_should_verify_the_after_login_error_message_as(String expLoginErrorMsg) {
		String loginErrorMsg = pom.getLoginPage().LoginErrorMsg();
		System.out.println("LoginError Msg :" + loginErrorMsg);
		boolean contains = loginErrorMsg.contains(expLoginErrorMsg);
		Assert.assertTrue("Verify Login Error Msg", contains);

	}

}
