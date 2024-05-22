package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.omrbranch.reports.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = false, tags = "@Login or @Select or @selectHotel or @BookHotel or @ChangeBooking or @CancelBooking", dryRun = false, plugin = {
		"pretty",
		"json:target\\index.json" }, monochrome = false, glue = "com.omrbranch.StepDefinition", features = "C:\\Users\\HARII\\eclipse-workspace1\\OMRBranchHotelAutomation\\src\\test\\resources\\Feature")
public class TestRunner_Class {
	
	@AfterClass
	public static void afterexecution() {

		JVMReport.GenerateJvmReport(System.getProperty("user.dir") + "\\target\\index.json");

	}

}
