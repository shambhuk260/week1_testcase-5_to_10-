package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_007_POM {
	private WebDriver driver;

	public RETC_007_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//A[@title=''])[4]")
	private WebElement click_appartment;

	public void clickAppartmentMenu() {

		WebElement element = driver.findElement(By.linkText("APARTMENTS"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

		driver.findElement(By.linkText("prestige")).click();

	}

	@FindBy(name = "your-name")
	private WebElement yourName;

	public void sendYourName(String userName) {
		this.yourName.clear();
		this.yourName.sendKeys(userName);
	}

	@FindBy(name = "your-email")
	private WebElement yourEmail;

	public void sendYourEmail(String email) {
		this.yourEmail.clear();
		this.yourEmail.sendKeys(email);
	}

	@FindBy(name = "your-subject")
	private WebElement your_Subject;

	public void sendYourSubject(String subject) {
		this.your_Subject.clear();
		this.your_Subject.sendKeys(subject);
	}

	@FindBy(name = "your-message")
	private WebElement your_Message;

	public void sendYourMessage(String message) {
		this.your_Message.clear();
		this.your_Message.sendKeys(message);
	}

	@FindBy(xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[5]/input")
	private WebElement click_send;

	public void sendClick() {

		this.click_send.click();
	}

	@FindBy(xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/div[2]")
	public WebElement getSuccessMessage;

	public void getMailSended() throws InterruptedException {

		String s1 = getSuccessMessage.getText();

	}

}