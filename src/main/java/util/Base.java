package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Base {
	public static WebDriver driver = null;
	public static Properties p = null;
	public static Map<String, String> my_dict = new HashMap();

	public static void readObjectRepository() throws IOException {
		FileInputStream reader = new FileInputStream(System.getProperty("user.dir") + "\\objectRepository.properties");
		p = new Properties();
		p.load(reader);

	}

	public static void setUp() throws IOException {
		readObjectRepository();
		if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (System.getProperty("browser").equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void tearDown() {
		driver.quit();
	}

}
