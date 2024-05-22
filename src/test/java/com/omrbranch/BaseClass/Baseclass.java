package com.omrbranch.BaseClass;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	public static WebDriver driver;

	// 1.Brower Launch
	public void browserlaunch() {
		driver = new ChromeDriver();
	}

	// 2.enterurl
	public static void enterurl(String url) {
		driver.get(url);
	}

	// 3.Maximize window
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	// 4.element Sendkeys
	public static void elementsendkeys(WebElement element, String data) {
		visiblityOf(element);
		if (IsEnabled(element) && isDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	private static void elementSend(WebElement element, String prabhu) {
		element.sendKeys(prabhu);

	}

	public void elementsendkeysEnter(WebElement element, String data) {
		visiblityOf(element);
		if (IsEnabled(element) && isDisplayed(element)) {
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public void Enterkey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// 5.Element Click
	public void elementClick(WebElement element) {
		visiblityOf(element);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if (IsEnabled(element) && isDisplayed(element)) {
			element.click();
		}
	}

	// 6.Get Title
	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

	// 7.FindLocaters ID
	public WebElement findlocaterbyID(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	// 8.FindLocaters Name
	public WebElement findlocaterbyName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	// 9.FindLocater Classname
	public WebElement findlocaterClassname(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	// 10.FindLocater Xpath
	public WebElement Findlocaterbyxpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 11.IsDisplayed
	public static boolean isDisplayed(WebElement element) {
		visiblityOf(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 12.IsEnabled
	public static boolean IsEnabled(WebElement element) {
		visiblityOf(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 13.IsSelected
	public boolean IsSelected(WebElement element) {
		visiblityOf(element);
		boolean selected = element.isSelected();
		return selected;
	}

	// 14.Get Text
	public String elementGetText(WebElement element) {
		visiblityOf(element);
		String text = null;
		if (isDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}


	// 15.Get Attribute
	public String elementGetAttribute(WebElement element) {
		visiblityOf(element);
		String text = null;
		if (isDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	// 16.Get Attribute (String)
	public String GetAttribute(WebElement element) {
		visiblityOf(element);
		String attribute = element.getAttribute("Attributename");
		return attribute;
	}

	// 17.Click OK in alert
	public Alert AlertClickok() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	// 18.Click Cancel in Alert
	public Alert AlertclickCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}

	// 19.Close All Window
	public void closeAllWindow() {
		driver.quit();
	}

	// 20.Close Current WIndow
	public static void CloseCurrentWIndow() {
		driver.close();
	}

	// 21.Get Current URL
	public String GetCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 22.Select Dropdown option by text
	public Select SelectByVisisbilityText(WebElement element, String value) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		return select;
	}

	// 23.Select Dropdown option by Int
	public Select SelectBYIndex(WebElement element, int number) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByIndex(number);
		return select;
	}

	// 24.Insert Value in textbox by JavaScript
	public void elementSendKeysJS(WebElement element, String data) {
		visiblityOf(element);

		if (IsEnabled(element) && isDisplayed(element)) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		}
	}

	// 24.1.Insert Value in textbox by JavaScript using locaters
	public WebElement JavaScriptExecutor(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement element1 = driver.findElement(By.id(data));
		executor.executeScript("value", data);
		return element1;
	}

	// 25.click button by java Script
	public void ClickjavaScript(JavascriptExecutor executor, WebElement element) {
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click()", element);
	}

	// 26.Switch to frame by index
	public void FrameByIndex(int number) {
		driver.switchTo().frame(number);
	}

	// 27.Switch to frame by name(element)
	public void FrameByName(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void ParentFrame() {
		driver.switchTo().parentFrame();

	}

	// 28.Get all option from DropDown as text
	public List<String> getAllOptionsTextDD(WebElement element) {
		visiblityOf(element);
		List<String> allOptionsText = new ArrayList<>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);
		}
		return allOptionsText;
	}

	// 29.VisibilityOf
	public static void visiblityOf(WebElement element) {
//			visiblityOf(element);
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	// 30.Get all option from DropDown as AttributeValue
	public List<WebElement> GetAllAttributeValue(WebElement element, String value) {
		visiblityOf(element);
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String attribute = webElement.getAttribute(value);
		}
		return options;
	}

	// 31.Get firstSelected Option
	public List<String> GetFirstSelected(WebElement element) {
		visiblityOf(element);
		List<String> allOptionsText = new ArrayList<>();
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return allOptionsText;
	}

	// 32.Ismultible
	public boolean IsMultible(WebElement element) {
		visiblityOf(element);
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 33.ImplicityWait
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	// 34.Deselect By Index
	public void deselectbyindex(WebElement element, int index) {
		visiblityOf(element);
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 35.Deselect By Value
	public void DeselectByValue(WebElement element, String text) {
		visiblityOf(element);
		Select select = new Select(element);
		select.deselectByValue(text);
	}

	// 36.Deselect By text
	public void DeselectByText(WebElement element, String text) {
		visiblityOf(element);
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 37.Deselect By All
	public void DeselectByAll(WebElement element) {
		visiblityOf(element);
		Select select = new Select(element);
		select.deselectAll();
	}

	// 38.Get urlPath
	public String getprojectPath() {
		return System.getProperty("user.dir");

	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(getprojectPath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	// 39.Get All Windows
	public void AllWindows() {
		Set<String> allWindows = driver.getWindowHandles();
	}

	// 40.Switch ChildWindow
	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String eachWindow : allWindows) {
			if (!pWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}
	}

	// 41.Clear Textbox
	public void cleartextbox(WebElement element) {
		visiblityOf(element);
		visiblityOf(element);
		element.clear();
	}

	// 42.Take ScreenShot
	public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(getprojectPath() + "\\screenshot\\" + name + ".png"));
	}

	// 43.Take ScreenShot for Element
	public void elementscreenshot(WebElement element, String attributevalue) throws IOException {
		visiblityOf(element);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		WebElement locaters = driver.findElement(By.xpath(attributevalue));
		File screenshotAs = locaters.getScreenshotAs(OutputType.FILE);
		File desFile = new File(attributevalue);
		FileUtils.copyFile(screenshotAs, desFile);
	}

	// 44.Mouse Over Action
	public void MouseOverAction(WebElement element) {
		visiblityOf(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// 45.RightClick
	public void RightClick(WebElement element) {
		visiblityOf(element);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// 46.Double Click
	public void DoubleClick(WebElement element) {
		visiblityOf(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// 47.Refresh Page
	public void Refresh() {
		driver.navigate().refresh();

	}

	// 48.
	public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
	}

	// 49.GetCellData
	public static String getCellData(String Sheetname, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File("C:\\Users\\HARII\\eclipse-workspace1\\MavenProject1\\Excel\\OmrBranch.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType Type = cell.getCellType();
		switch (Type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YY");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				}
			}
		default:
			break;
		}
		return res;
	}

	// 51.Update cell value
	public String UpdateCellData(String sheetname, int rownum, int cellnum, String olddata, String newdata)
			throws IOException {
		File file = new File("url");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("sheetName");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
		return value;
	}

	// 52.Create cell and insert value
	public void CreateCellAndSetCellData(String sheetname, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\HARII\\eclipse-workspace1\\MavenProject1\\Excel\\OmrBranch.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public List<WebElement> List_findLocatorByXpath(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements;

	}

	public static WebDriverWait ExplicityWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait;

	}
}
