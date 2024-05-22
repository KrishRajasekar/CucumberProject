package com.omrbranch.reports;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
//	Method
	public static void GenerateJvmReport(String jsonfile) {
//Mention the report location
		File file = new File(System.getProperty("user.dir")+"\\target");
// to set configuration for report

		Configuration configuration = new Configuration(file, "OMR Branch");
		// add configuration
		configuration.addClassifications("Platform", "windows");
		configuration.addClassifications("PlatformVersion", "11");
		configuration.addClassifications("Author", "Rajasekar");
		configuration.addClassifications("environment", "QA");

		List<String> list = new ArrayList<>();
		list.add(jsonfile);
		// Create object for Reportbuilder class
		ReportBuilder builder = new ReportBuilder(list, configuration);
		builder.generateReports();

	}

}
