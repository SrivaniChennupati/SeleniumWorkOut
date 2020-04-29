package BasicSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC011_Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		
		
		
	       System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			
			ChromeDriver driver = new ChromeDriver(options);
			

			driver.get("https://www.snapdeal.com/");

			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			// Mouse Hover on Toys,Kids' Fashion & more and click on toys
			
			
			WebElement element = driver.findElementByXPath("//div[@class='leftNavigationLeftContainer expandDiv']//div/following::li[9]//a/span");
			
			Actions builder = new Actions(driver);
			
			builder.moveToElement(element).perform();
			
			driver.findElementByXPath("//span[text()='Toys']").click();
			
			// Click Educational Toys in Toys & Games 
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='Toys & Games']/following::ul/li[2]/a/div[text()='Educational Toys']")));
			
			driver.findElementByXPath("//div[text()='Toys & Games']/following::ul/li[2]/a/div[text()='Educational Toys']").click();
			
			//Click the Customer Rating 4 star and Up
			
			
			Thread.sleep(7000);
			
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-filtername='avgRating']//div[@class='filters-list sdRadio  ']/input/following-sibling::label")));
			
			driver.findElementByXPath("//div[@data-filtername='avgRating']//div[@class='filters-list sdRadio  ']/input/following-sibling::label").click();
			
			//click the offer as 40-50
			
			
			Thread.sleep(10000);
			
			driver.navigate().refresh();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-filtername='discount']/div[@class='filter-content ']//div[5]/input/following-sibling::label")));
			
	     	driver.findElementByXPath("//div[@data-filtername='discount']/div[@class='filter-content ']//div[5]/input/following-sibling::label").click();
			
			
	     	//Check the availablity for the pincode 
	     	
	     	
	     	Thread.sleep(12000);
	     	
	     	
	     	driver.findElementByXPath("//div[@class='pincode-serviceability-check']/div[2]/input[@placeholder='Enter your pincode']").sendKeys("600119");
	     	
	     	driver.findElementByXPath("//div[@class='pincode-serviceability-check']/div[2]/input/following-sibling::button").click();
	     	
	     	//Click the Quick View of the First Product
	     	
	     	Thread.sleep(7000);
	     	
	     	driver.navigate().refresh();
	     	
	     	WebElement element2 = driver.findElementByXPath("//div[@class='product-tuple-image ']//picture/img[@title='INVENTO 4Pcs DC 3.7V 716 7x16mm Micro Coreless Motor With 4Pcs 30mm Propeller High Speed Mini Drones']");
	     	
	     	builder.moveToElement(element2).perform();
	     	
	     	driver.findElementByXPath("//div[@class='product-tuple-image ']//picture/following-sibling::input/following::div[2]").click();
	     	
	     	//Click on View Details
	     	
	     	
	     	driver.findElementByXPath("//div[@class='modal-wrapper col-xs-24  reset-padding mainWidgetquickView']/div/following-sibling::div//div[4]/following-sibling::a").click();
	     	
	     	
	     	//Capture the price of the product and Delivery Charge 
	     	
	     	String price = driver.findElementByXPath("//div[@class='row reset-margin']//following-sibling::div//span/span").getText();
	     	
	     	System.out.println(price);
	     	
	     	int price1 = Integer.parseInt(price);
	     	
	     	String DelivaryCharge = driver.findElementByXPath("//div[@id='deliveryOptionsTooltip']/div/div//span[@class='availCharges']").getText().replaceAll("\\D","");
	     	
	     	System.out.println(DelivaryCharge);
	     	
	     	int DeliverCharge1 = Integer.parseInt(DelivaryCharge);
	     	
	     	//Validate the you pay amount matches the sum of (price+deliver charge)
	     	
	     	driver.findElementByXPath("//div[@id='pdp-buynow-rp']//div[1]/span[text()='add to cart']").click();
	     	
	     	Thread.sleep(5000);
	     	
	     	 int TotalAmount = price1+DeliverCharge1;
	     	 
	     	String Total = Integer.toString(TotalAmount);
	     	 
	     	 String text3 = driver.findElementByXPath("//div[@class='col-xs-9 info-container']//div[2]/span").getText().replaceAll("\\D","");
	     	 
	     	 System.out.println(text3);
	     	 
	     	 if (Total.equals(text3))
	     	 {
	     		 
	     		 System.out.println("pay amount matches the sum of (price+deliver charge)");
	     		 
	     	 }
	     	 
	     	 
	     	 driver.findElementByXPath("//div[@id='cartProductContainer']//div[1]/div/span[3]").click();
	     	 
	     	 //search for sanitizer 
	     	 
	     	 driver.findElementById("inputValEnter").sendKeys("Sanitizer");
	     	 
	     	 driver.findElementByXPath("//div[@class='overlap']/following-sibling::input/following::button").click();
	     	 
	     	 //click on Product "Bio Ayurveda Neem Power Hand Sanitizer"
	     	 
	     	 driver.findElementByXPath("//div[@class='product-tuple-description ']/div/a/p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']").click();
	     	 
	     	 
	     	 Set<String> set = driver.getWindowHandles();
	     	 
	     	 List<String> list = new ArrayList<String>();
	     	 
	     	 list.addAll(set);
	     	 
	     	 driver.switchTo().window(list.get(1));
	     	 
	     	 //Capture the Prize and Delivery Charge
	     	 
	     	 String SecondProductPrice = driver.findElementByXPath("//div[@class='row reset-margin']//div//div[@class='pdpCutPrice ']/following::span").getText().replaceAll("\\D","");
	     	
			 String DeliveryCharge2 = driver.findElementByXPath("//div[@id='deliveryOptionsTooltip']/div/div//span[@class='availCharges']").getText().replaceAll("\\D","");
			 
			 
			//Click on Add to cart 
			 
			 wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='add-cart-button-id']/span[text()='ADD TO CART']")));
			 
			driver.findElementByXPath("//div[@id='add-cart-button-id']/span[text()='ADD TO CART']").click();
			 
			 Thread.sleep(10000);
			 
			 //Validate the Proceed to pay matches the total amount of both the products
			 
			 driver.findElementByXPath("//div[@class='col-xs-5 reset-padding header-right rfloat']/div/div/span").click();
			 
			 Thread.sleep(10000);
			 
			
			 
			 
			 String checkOutPrice = driver.findElementByXPath("//div[@class='cart-bill-wrapper ']/div/div//span").getText().replaceAll("\\D","");
			 
			 System.out.println(checkOutPrice);
			 
			int c = Integer.parseInt(checkOutPrice);
			
			String delivry = driver.findElementByXPath("//div[@class='clearfix sub-total-charges']/div[2]/label/following-sibling::span").getText().replaceAll("\\D","");
			 
			int d = Integer.parseInt(delivry);
			
			int E= c+d;
			
			System.out.println(E);
		
			 String firstitemtotal = driver.findElementByXPath("//li[@class='clearfix cart-item']//div[7]/div[@class='text-right']//p/span").getText().replaceAll("\\D","");
			 
			 int a = Integer.parseInt(firstitemtotal);
			 
			 
			 String seconditemtotal = driver.findElementByXPath("//li[@class='clearfix cart-item']//div[7]/div[@class='text-right']//p/span[text()='Rs. 276']").getText().replaceAll("\\D","");

	         int b = Integer.parseInt(seconditemtotal);
	
	        int c1 = a+b ;
	
	         if (c1==E)
		
	        {
		      System.out.println("the Proceed to pay matches the total amount of both the products");
		
	
	       }
	         
	         // Close all the browsers 
	         
	         driver.close();
	         
	         driver.switchTo().window(list.get(0));
	         
	         driver.close();
	
	}
	
	
	

}

	
