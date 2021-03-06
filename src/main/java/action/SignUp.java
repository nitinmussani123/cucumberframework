package action;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Base;

public class SignUp extends Base {

	public String navigateToPage(String url) {
		driver.navigate().to(url);
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public void generateValidUsernameAndSave(String key) {
		key = key.substring(1);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		String value = saltStr + randomInt + "@abc.com";

		my_dict.put(key, value);
	}

	public void enterText(String val, String locator) throws InterruptedException {
		if (val.startsWith("$")) {
			val = val.substring(1);
			val = my_dict.get(val);
		}
		getWebElement(locator).clear();
		getWebElement(locator).sendKeys(val);

	}

	public static WebElement getWebElement(String locator) {
		WebElement we = null;
		if (locator.contains("xpath")) {
			we = driver.findElement(By.xpath(p.getProperty(locator)));
		} else if (locator.contains("id")) {
			we = driver.findElement(By.id(p.getProperty(locator)));
		} else if (locator.contains("name")) {
			we = driver.findElement(By.name(p.getProperty(locator)));
		}
		return we;
	}

	public void clickOn(String string) throws InterruptedException {
		try {
			getWebElement(string).click();
		} catch (Exception E) {
			WebElement we = getWebElement(string);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", we);
			we.click();
		}
	}

	public String getText(String locator) throws InterruptedException {
		Thread.sleep(1000);
		String text = getWebElement(locator).getText();
		return text;
	}

	public String navigateToPageAndVerifyText(String locator) throws InterruptedException {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		Set<String> handles = driver.getWindowHandles();
		driver.switchTo().window(newTab.get(1));
		String textDisplayed = getWebElement(locator).getText();
		driver.close();
		driver.switchTo().window(parent);
		return textDisplayed;

	}

	public String getPageTitle() throws InterruptedException {
		Thread.sleep(10000);
		return driver.getTitle();
	}

	public void popUpHandle() {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		Set<String> handles = driver.getWindowHandles();
		driver.switchTo().window(newTab.get(1));
	}
}
