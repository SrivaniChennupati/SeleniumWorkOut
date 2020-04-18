package BasicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HP {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://store.hp.com/in-en/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Mouse over on Laptops Menu and click on Pavilion 
		
		WebElement ele = driver.findElementByXPath("(//span[text()='Laptops'])[1]");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(ele).perform();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("(//span[text()='Pavilion'])[1]").click();
		
		//under Shopping options ...> Processor...>Select Intel Core i7
		
		
		driver.findElementByXPath("//button[text()='Accept Cookies']").click();
		
		
        WebDriverWait wait1 = new WebDriverWait(driver,120);
        
        wait1.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='inside_notify_content']")));
		
	    driver.findElementById("inside_holder").click();
	     

		WebDriverWait mywait = new WebDriverWait(driver,140);
	        
	    mywait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[text()='Processor'])[2]")));
		
		driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
		
		// if the Element not getting clicked due to JavaScript or AJAX calls present use Actions Class
		
		 WebElement element2 = driver.findElementByXPath("//span[text()='Intel Core i7']");
		 
		 Actions	 builder1 = new Actions(driver);
		  
		 builder1.moveToElement(element2).click().build().perform();
		 
		
		// Hard Drive Capacity ...> More than 1 TB
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//span[text()='More than 1 TB']").click();
		
		// Select Sort By : Price : Low to High 
		
		Thread.sleep(4000);
		
		WebElement element = driver.findElementById("sorter");
		
		Select se = new Select(element);
		
		se.selectByVisibleText("Price : Low to High");
		
		// Print the First Resulting Product Name and Price 
		
		
		String name = driver.findElementByXPath("(//a[@class='product-item-link'])[1]").getText();
		
		System.out.println(name);
		
		String Price = driver.findElementByXPath("(//span[@class='price-wrapper '])[1]").getText().replaceAll("\\D","");
		
		System.out.println(Price);
		
		//Click on Add to Cart 
	
		   WebElement ele2 = driver.findElementByXPath("//span[text()='Add To Cart'][1]");
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", ele2);
		 
		 // click on shopping cart icon..> click on view and edit cart 
		
		 WebElement element4 = driver.findElementByXPath("//a[@class='action showcart']");
		
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", element4);
		
		driver.findElementByXPath("//span[text()='View and edit cart']").click();
		
		//check the shipping option...> check availability at pincode 
		
		driver.findElementByName("pincode").sendKeys("600119");
		
		driver.findElementByXPath("//button[text()='check']").click();
		
		
		//verify the order Total against the Product price 
		
		String OrderTotal = driver.findElementByXPath("//tr[@class='grand totals']//span").getText().replaceAll("\\D","");
		System.out.println(OrderTotal);
		
		Assert.assertEquals(Price, OrderTotal);
		
		System.out.println("Order total and Price matches");
		
		//Proceed to checkout if order total and price matches 
		
		
		driver.findElementById("sendIsCAC").click();
		
		//click on place order
		
		driver.findElementByXPath("(//span[text()='Place Order'])[4]").click();
		
		//Capture the error message and print 
		
		String error = driver.findElementByXPath("//div[@class='message notice']/span").getText();
		
		System.out.println(error);
		
		// close the Browser
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
