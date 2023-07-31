package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.PropertyUtils;

public class BaseClass {

	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	public static Logger log = Logger.getLogger(BaseClass.class);

	public void initialiazation() throws Exception {
		System.out.println("Initializing a browser");
		log.info("Initializing a browser");

		String browserName = PropertyUtils.readProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Browser Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/Browser Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("file:///D:/PM/zip%20files/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
	}

	public static void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport.html");
		report.attachReporter(spark);

	}
}
