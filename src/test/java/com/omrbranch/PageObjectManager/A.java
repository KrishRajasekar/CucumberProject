package com.omrbranch.PageObjectManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A {
	public static WebDriver driver;

	public static void main(String[] args) {
		List<WebElement> txtTotalPrice = driver.findElements(By.xpath("//strong[@class='total-prize']"));
		// Create a list to store prices as numbers
		List<Double> prices = new ArrayList<>();

		// Extract prices from web elements and convert them to numbers
		for (WebElement element : txtTotalPrice) {
			String priceText = element.getText().replaceAll("[^0-9.]", ""); // Extracting numeric characters
			double price = Double.parseDouble(priceText);
			prices.add(price);
		}

		// Check if prices are sorted in ascending order
		boolean isSorted = true;
		for (int i = 1; i < prices.size(); i++) {
			if (prices.get(i - 1) > prices.get(i)) {
				isSorted = false;
				break;
			}
		}

		System.out.println("Prices are sorted low to high: " + isSorted);
	}
}
