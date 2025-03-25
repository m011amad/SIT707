package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Mason");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement element2 = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element2);
		// Send last name
		element2.sendKeys("Nia");
		
		
		WebElement element7 = driver.findElement(By.id("organisation"));
		System.out.println("Found element: " + element7);
		// Send organisation
		element7.sendKeys("Deakin");
		
		WebElement element3 = driver.findElement(By.id("username_verify"));
		System.out.println("Found element: " + element3);
		// Send username_verify
		element3.sendKeys("test@test.com");
		
		WebElement element4 = driver.findElement(By.id("username"));
		System.out.println("Found element: " + element4);
		// Send username
		element4.sendKeys("test@test.com");
		
		WebElement element5 = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element5);
		// Send password
		element5.sendKeys("123??M45");
		
		
		WebElement element6 = driver.findElement(By.id("password_verify"));
		System.out.println("Found element: " + element6);
		// Send password_verify
		element6.sendKeys("123??45");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		
		WebElement createAccountButton = driver.findElement(By.cssSelector("input.btn.btn-primary[type='submit']"));
		System.out.println("Found Create Account button: " + createAccountButton);
		createAccountButton.click();

		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		    FileUtils.copyFile(scrFile, new File("./screenshot.png"));
		    System.out.println("Screenshot saved as 'screenshot.png'.");
		} catch (IOException e) {
		    System.out.println("Failed to save screenshot: " + e.getMessage());
		}
		
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
