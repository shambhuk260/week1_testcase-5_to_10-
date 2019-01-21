package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;

import com.training.pom.RETC_009_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_009_Tests {

	private WebDriver driver;
	private String baseUrl;
	private RETC_009_POM searchApartmentPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		searchApartmentPOM = new RETC_009_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {

		searchApartmentPOM.clickAppartmentMenu();
		searchApartmentPOM.sendAddressclicklistedbelow();
		
		searchApartmentPOM.selectPropertyType();
		searchApartmentPOM.selectRegions();
		searchApartmentPOM.clickSearchbtn();

	}
}
