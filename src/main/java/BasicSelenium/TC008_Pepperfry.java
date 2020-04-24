package BasicSelenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC008_Pepperfry {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		     // Go to https://www.pepperfry.com/
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions() ;
			
			options.addArguments("--disable-notifications");
			
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);

			ChromeDriver driver = new ChromeDriver();

			driver.get("https://www.pepperfry.com/");

			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			Thread.sleep(40000);
			
			Set<String> set = driver.getWindowHandles();
			
			System.out.println(set);

			List<String> list = new ArrayList<String>();

			list.addAll(set);

			driver.switchTo().window(list.get(0));
			
		 wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]")));
		  
		  WebElement element = driver.findElementByXPath("(//div[@id='reg_login_box']//a[@class='popup-close'])[1]");
		  
		  Actions builder = new Actions(driver);
		  
		  builder.moveToElement(element).click().build().perform();
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
			
			//Mouseover on Furniture and click Office Chairs under Chairs
		  
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@id='menu_wrapper']//a[text()='Furniture']")));
		  
		  WebElement furniture = driver.findElementByXPath("//div[@id='menu_wrapper']//a[text()='Furniture']");
		  Actions builder1 = new Actions(driver);
		  
		  builder1.moveToElement(furniture).perform();
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  
		  jse.executeScript("window.scrollBy(0,250)");
		  
		  driver.findElementByXPath("//a[text()='Office Chairs']").click();
		  
		  //click Executive Chairs
		  
		  driver.findElementByXPath("//div[@class='cat-wrap-ttl']/h5[text()='Executive Chairs']").click();
		  
		  //Change the minimum Height as 50 in under Dimensions
		  
		 
		  
		  WebElement element2 = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]")));
		  
		  JavascriptExecutor js2 =  (JavascriptExecutor)driver;
		  
		  js2.executeScript("arguments[0].click();", element2);
		  
		  element2.clear();
		  
		  element2.sendKeys("50",Keys.ENTER); 
		
		 
		  //Add "Poise Executive Chair in Black Colour" chair to Wishlist
		  
		   driver.navigate().refresh();
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@class='clip-dtl-ttl row']/following::div[@class='clip-prd-hrt pf-col xs-2'])[1]")));
		  
		   driver.findElementByXPath("(//div[@class='clip-dtl-ttl row']/following::div[@class='clip-prd-hrt pf-col xs-2'])[1]").click();
		  
		  
	      //Mouseover on Homeware and Click Pressure Cookers under Cookware
		  
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//a[text()='Homeware'])[1]")));
		  
		   WebElement element3 = driver.findElementByXPath("(//a[text()='Homeware'])[1]");
		  
           Actions builder3 = new Actions(driver);
		  
		  builder3.moveToElement(element3).perform();
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='Pressure Cookers']")));
		  
		  driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
		  
		  
		  //Select Prestige as Brand
		  
		    driver.findElementByXPath("//div[@id='mCSB_1_container']/li/label[text()='Prestige']").click();
		  
		  Thread.sleep(10000);
		  
		  //Select Capacity as 1-3 Lt
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//label[text()='1 Ltr - 3 Ltr']"))); 
		  
		  driver.findElementByXPath("//label[text()='1 Ltr - 3 Ltr']").click();
		  
		  //Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
		  
		  Thread.sleep(6000);
		  
		  driver.navigate().refresh();
		  
        driver.findElementByXPath("//div[@class='clip-prd-hrt pf-col xs-2']/a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']").click();
		  
		  //Verify the number of items in Wishlist
		  
		  String count = driver.findElementByXPath("//div[@class='wishlist_bar']//span[text()='2']").getText();
		  
		  System.out.println("Wishlist count is" +count);
		  
		  // Navigate to Wishlist
		  
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='wishlist_bar']/a[@data-tooltip='Wishlist']")));
		  
		  driver.findElementByXPath("//div[@class='wishlist_bar']/a[@data-tooltip='Wishlist']").click();
		  
		  //Move Pressure Cooker only to Cart from Wishlist
		  
		  
		  wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//div[@class='action_block']/a[text()='Add to Cart'])[2]")));
		  
          JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		  
		  jse1.executeScript("window.scrollBy(0,250)");
		  
		  driver.findElementByXPath("(//div[@class='action_block']/a[text()='Add to Cart'])[2]").click();
		  
		  //Check for the availability for Pincode 600128
		  
		  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='pin_block']/input[@type='text']")));
		  
		  driver.findElementByXPath("//div[@class='pin_block']/input[@type='text']").sendKeys("600119");
		  
		  driver.findElementByXPath("//a[text()='Check']").click();
		  
		  //Click Proceed to Pay Securely
		  
		  driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
		  
		  
		  //Click Proceed to Pay
		  
		  driver.findElementByXPath("(//span[@class='ck-proceed-btn-wrap']/a[text()='PLACE ORDER'])[1]").click();
		  
		 //Capture the screenshot of the item under Order Item
		  
		  
		  driver.findElementByXPath("//div[@id='ordersummary_accordian_header']//span[text()='(1 Items)']").click();
		  
		  Thread.sleep(10000);
		  
		    File src = driver.findElementByXPath("//ul[@class='nCheckout__accrodian-section-product slick-initialized slick-slider']//li[@id='payment_cart_1676140']").getScreenshotAs(OutputType.FILE);
		    
		    File dst = new File("./snaps/PressureCookerScreenshot.jpg");
		    
		    
		    FileUtils.copyFile(src,dst );
		    
			}

}
