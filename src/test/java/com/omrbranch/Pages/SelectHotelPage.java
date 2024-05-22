package com.omrbranch.Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.BaseClass.Baseclass;

public class SelectHotelPage extends Baseclass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public static String FirstHotelName;
	public static String HotelPrice;

	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement SelectHotelSuccessMsg;

	@FindBy(xpath = "(//h5[text()='Hilton Standard'])[1]")
	private WebElement print1stHotelName;

	@FindBy(xpath = "(//strong[@class='total-prize'])[3]")
	private WebElement print1stHotelPrice;

	@FindBy(xpath = "//h2[@class='px-3 py-2']")
	private WebElement txtBookHotelName;

	@FindBy(xpath = "(//a[text()='Continue'])[1]")
	private WebElement txtClickContinue;

	@FindBy(xpath = "//div[@class='col-md-5 hotel-suites']//h5")
	private List<WebElement> txthotelnameEndswith;

	@FindBy(xpath = "//label[text()='Price low to high']")
	private WebElement txtClickPriceLowToHigh;

	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement txtClickPriceHighToLow;

	@FindBy(xpath = "//label[text()='Name Ascending']")
	private WebElement txtClickNameAsc;

	@FindBy(xpath = "//label[text()='Name Descending']")
	private WebElement txtClickNameDesc;

	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> txtTotalPrice;

	@FindBy(xpath = "//div[@class='col-md-5 hotel-suites']//h5")
	private List<WebElement> txtTotalHotelName;

	public String getSelectHotelSuccessMsg() {
		String SelectHotelMsg = elementGetText(SelectHotelSuccessMsg);
		return SelectHotelMsg;
	}

	public void ClickContinueBtn() {
		elementClick(txtClickContinue);

	}

	public void AlertOk() {
		AlertClickok();
	}

	public void AlertCancel() {
		AlertclickCancel();
	}

	public boolean HotelNameEndsWithRoomType() {
		String roomtype = "Standard";
		for (WebElement element : txthotelnameEndswith) {
			String HotelName = elementGetText(element);
			List<String> asList = Arrays.asList(HotelName);
			List<Boolean> l1 = new ArrayList<>();
			for (String HotelName1 : asList) {
				boolean endsWith = HotelName1.endsWith(roomtype);
				l1.add(endsWith);
			}
			boolean contains = l1.contains(false);

		}
		return false;
	}

	public void VerifyHotelPriceLowToHigh() {

		List<WebElement> price = driver.findElements(By.xpath("//strong[@class='total-prize']"));
		List<String> Qa = new ArrayList<>();
		for (WebElement string : price) {
			String text = string.getText();
			String substring = text.substring(1);
			String replace = substring.replace(", ", "");
			Qa.add(replace);
		}
		System.out.println(Qa);
		Collections.sort(Qa);
		System.out.println(Qa);
		List<String> Dev = new ArrayList<>();
		Dev.addAll(Qa);
		boolean equals = Qa.equals(Dev);
		if (equals) {
			System.out.println("Hotel price is low to high");
		} else {
			System.out.println("Hotel price is not correct");
		}
	}

	public void VerifyHotelPriceHighToLow() {

		List<WebElement> price = driver.findElements(By.xpath("//strong[@class='total-prize']"));
		List<String> Qa = new ArrayList<>();
		for (WebElement string : price) {
			String text = string.getText();
			String substring = text.substring(1);
			String replace = substring.replace(", ", "");
			Qa.add(replace);
		}
		System.out.println(Qa);
		Collections.reverse(Qa);
		System.out.println(Qa);
		List<String> Dev = new ArrayList<>();
		Dev.addAll(Qa);
		boolean equals = Qa.equals(Dev);
		if (equals) {
			System.out.println("Hotel price is high to low");
		} else {
			System.out.println("Hotel price is not correct");
		}
	}

	public void VerifyHotelNameAscending() {
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='col-md-5 hotel-suites']//h5"));
		List<String> Qa = new ArrayList<>();
		for (WebElement string : price) {
			String text = string.getText();
			Qa.add(text);
		}
		Collections.sort(Qa);
		System.out.println(Qa);
		List<String> Dev = new ArrayList<>();
		Dev.addAll(Qa);
		boolean equals = Qa.equals(Dev);
		if (equals) {
			System.out.println("HotelName is Ascending");
		} else {
			System.out.println("HotelName is not correct");
		}
	}

	public void VerifyHotelNameDescending() {
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='col-md-5 hotel-suites']//h5"));
		List<String> Qa = new ArrayList<>();
		for (WebElement string : price) {
			String text = string.getText();
			Qa.add(text);
		}
		Collections.sort(Qa);
		System.out.println(Qa);
		Collections.reverse(Qa);
		System.out.println(Qa);
		List<String> Dev = new ArrayList<>();
		Dev.addAll(Qa);
		boolean equals = Qa.equals(Dev);
		if (equals) {
			System.out.println("HotelName is Descending");
		} else {
			System.out.println("HotelName is not correct");
		}
	}

	public void PriceHighToLow() {
		elementClick(txtClickPriceHighToLow);
	}

	public void PriceLowToHigh() {
		elementClick(txtClickPriceLowToHigh);
	}

	public void HotelNameAsc() {
		elementClick(txtClickNameAsc);
	}

	public void HotelNameDesc() {
		elementClick(txtClickNameDesc);
	}

	public String PrintFirstHotelPrice() {
		String FirstHotelName = elementGetText(print1stHotelPrice);
		return FirstHotelName;
	}

	public String PrintFirstHotelName() {
		String HotelName = elementGetText(print1stHotelName);
		String[] split = HotelName.split(" ");
		FirstHotelName = "";
		for (int i = 0; i < 1; i++) {
			FirstHotelName = FirstHotelName + split + " ";
//			System.out.println(FirstHotelName);
		}
		return FirstHotelName;

	}

	public String verifyFirstHotelName() {
		String HotelName = elementGetText(print1stHotelName);
		String[] split = HotelName.split(" ");
		FirstHotelName = "";
		for (int i = 0; i < 1; i++) {
			FirstHotelName = FirstHotelName + split + " ";
//			System.out.println(FirstHotelName);
		}
		return HotelName;

	}

	public String printHotelPrice() {
		String HotelPrice = elementGetText(print1stHotelPrice);
		return HotelPrice;

	}

}
