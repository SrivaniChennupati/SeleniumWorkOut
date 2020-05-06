package BasicSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC016_Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		int dispriceforcoupon = 0;
		
		
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		
		ChromeDriver driver = new ChromeDriver(options);
		

		driver.get("https://www.ajio.com/shop/sale");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		
	    // Enter Bags in the Search field and Select Bags in Women Handbags   
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='locale']//button")));
		
		driver.findElementByXPath("//div[@class='locale']//button").click();
		
		driver.findElementByXPath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input").sendKeys("bags");
		
		driver.findElementByXPath("//ul[@class='rilrtl-list ']/li[3]/a").click();
		
		//Click on five grid and Select SORT BY as "What's New"   
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='grid-container']/div[2]")));
		
		driver.findElementByXPath("//div[@class='grid-container']/div[2]").click();

		WebElement element = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		
		Select se = new Select(element);
		
		se.selectByVisibleText("What's New");
		
		//Enter Price Range Min as 2000 and Max as 5000   
		
		driver.findElementByXPath("//ul[@class='rilrtl-list ']/li[@class='rilrtl-list-item']//div/span[2][text()='price']").click();
		
		driver.findElementByXPath("//div[@class='input-price-filter']//input[@id='minPrice']").sendKeys("2000");
		
		driver.findElementByXPath("//div[@class='input-price-filter']//input[@id='maxPrice']").sendKeys("5000");
		
		driver.findElementByXPath("//div[@class='input-price-filter']//button").click();
		
		//Click on the product "Puma Ferrari LS Shoulder Bag"  
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='contentHolder']/div[text()='Puma']/following-sibling::div[text()='Ferrari LS Shoulder Bag']")));
		
		driver.findElementByXPath("//div[@class='contentHolder']/div[text()='Puma']/following-sibling::div[text()='Ferrari LS Shoulder Bag']").click();
		
		 Set<String> set = driver.getWindowHandles();
		    
		 List<String> list = new ArrayList<String>();
		    
		 list.addAll(set);
		    
		 driver.switchTo().window(list.get(1));
		 
		 //Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon  
		
		String text = driver.findElementByXPath("//div[@class='promo-desc-block']//div[2]").getText();
		
		String text1 = text.replaceAll("[^0-9.]","");
		
		String discountprice = text1.substring(2);
		
		System.out.println("Discount price is "+ discountprice);
		
		int discountprice1 = Integer.parseInt(discountprice);
		
		String productprice = driver.findElementByXPath("//div[@class='prod-price-section']/div").getText().replaceAll("\\D","");
		
		System.out.println("Product Price is " +productprice);
		
		int productprice1 = Integer.parseInt(productprice);
		
		if (productprice1> discountprice1)
			
		{
			
			System.out.println("Coupon code for the price above 2690 is applicable for Ferrari LS Shoulder Bag product");
			
			
		
			String couponcode = driver.findElementByXPath("//div[@class='promo-title-blck']/div/br").getText();
			
			System.out.println("Coupo code is " +couponcode);
			
			// calculate discount price for coupon 
			
			String GetitforPrice = driver.findElementByXPath("//div[@class='promo-desc-block']/div/span").getText().replaceAll("\\D","");
			
			System.out.println("GetitforPrice is " +GetitforPrice);
			
			int GetitforPrice1 = Integer.parseInt(GetitforPrice);
			
			
			 dispriceforcoupon= productprice1-GetitforPrice1;
			
			System.out.println("DiscountPriceForCoupon is " +dispriceforcoupon);
			
			
		}
			
		
		//Check the availability of the product for pincode 560043, print the expected delivery date if it is available  
		
		driver.findElementByXPath("//div[@class='edd-pincode-msg-container']").click();
		
		driver.findElementByXPath("//div[@class='edd-pincode-modal-form-container']/input").sendKeys("560043");
		
		driver.findElementByXPath("//div[@class='edd-pincode-modal-form-container']/button[@type='submit']").click();
		
		//Click on Other Informations under Product Details and Print the Customer Care address, phone and email 
		
		driver.findElementByXPath("//section[@class='prod-desc']//ul/div").click();
		
		String customercareaddress = driver.findElementByXPath("(//li[@class='detail-list mandatory-info'])[6]/span/following-sibling::span[2]").getText();

		System.out.println("customercareaddress is " +customercareaddress);
		
		// Click on ADD TO BAG and then GO TO BAG  
		
		driver.findElementByXPath("//div[@class='pdp-addtocart-button']").click();
		
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='pdp-addtocart-button']//div/span[2]")));
		
		WebElement element2 = driver.findElementByXPath("//div[@class='pdp-addtocart-button']//div/span[2]");
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
			
	    executor.executeScript("arguments[0].click();", element2);
		
		//Check the Order Total before apply coupon  
	    
	    Thread.sleep(7000);
		
		String ordertotal = driver.findElementByXPath("//section[@id='orderTotal']/span/following-sibling::span").getText();
		
		System.out.println("ordertotal is" +ordertotal);
		
		//Enter Coupon Code and Click Apply  
		
		driver.findElementByXPath("//div[@class='input-box-div']/input[@id='couponCodeInput']").sendKeys("EPIC");
		
		driver.findElementByXPath("//div[@class='input-box-div']/button[text()='Apply']").click();
		
		//Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details  
		
		String Couponsavings = driver.findElementByXPath("//section[@id='couponDiscount']/span/following-sibling::span").getText();
		
		String Couponsavings1 = Couponsavings.replaceAll("[^0-9.]","");
		
		String[] split = Couponsavings1.split(".",2);
		
		System.out.println(split);
		
		System.out.println(split[1]);
		System.out.println(split[0]);
		
		System.out.println("Couponsavings is " +split[1]);
		
	
		double d = Double.parseDouble(split[1]);
		
		int roundOff =(int) Math.round(d);  
		
		System.out.println("Couponsavings round of value" +roundOff);
		
		
		  
		 if (dispriceforcoupon == roundOff)
		  
		  { System.out.println("Coupon Savings amount under Order Summary matches with  the amount calculated in Product details");
		  
		  }
		  
		  else
		  
		  { System.out.
		  println("Coupon Savings amount under Order Summary does not with  the amount calculated in Product details");
		  
		  
		  }
		  
		  //Click on Delete and Delete the item from Bag
		  
		  driver.findElementByXPath("//div[@class='product-delete']/div[text()='Delete']").click();
		  
		  driver.findElementByXPath("//div[@class='card-delete-button']/div[2]").click();
		  
		  System.out.println("The Product was Successfully Removed from the Bag");
		  
		  //Close all the browsers
		  
		 
		
		
		
		
		
		
		

	}

}
