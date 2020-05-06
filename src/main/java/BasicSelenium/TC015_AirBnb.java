package BasicSelenium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC015_AirBnb {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		
		ChromeDriver driver = new ChromeDriver(options);
		

		driver.get("https://www.airbnb.co.in/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='optanon-alert-box-button-container']/div[2]//button")));
		
        driver.findElementByXPath("//div[@class='optanon-alert-box-button-container']/div[2]//button").click();
	
	   
        // Type Coorg in location and Select Coorg, Karnataka 
        
        
        driver.findElementByXPath("//div[@class='_qiizeo']/label/div[text()='Location']/following-sibling::input").sendKeys("coorg");
	
	    driver.findElementByXPath("//ul[@role='listbox']/li/div[2]/div[text()='Coorg, Karnataka']").click();
	    
	    
	    // Select the Start Date as June 1st and End Date as June 5th 
	    
	    
	    WebElement table = driver.findElementByXPath("(//table[@class='_cvkwaj'])[3]");
	    
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    
	    WebElement firstrow = rows.get(0);
	    
	    List<WebElement> firstrowcoloumns = firstrow.findElements(By.tagName("td"));
	    
	    firstrowcoloumns.get(1).click();
	    
	    firstrowcoloumns.get(5).click();
	    
	    // Select guests as 6 adults, 3 child and Click Search
	    
	    driver.findElementByXPath("//div[@class='_qiizeo']/button/div[text()='Guests']").click();
	    
	    for (int i= 1 ;i<= 6; i++)
	    	
	    {
	    	driver.findElementByXPath("//div[@id='stepper-adults']//button[@aria-label='increase value']").click();
	    	
	    	Thread.sleep(2000);
	    	
	    }
	    	
	    
         for (int i= 1 ;i<= 3; i++)
	    	
	    {
	    	driver.findElementByXPath("//div[@id='stepper-children']//button[@aria-label='increase value']").click();
	    	
	    	Thread.sleep(2000);
	    	
	    }
	    	
	    
	    driver.findElementByXPath("//div[@class='_h6px0p']/button[@type='submit']").click();
	    
	    // Click Cancellation flexibility and enable the filter and Save 
	    
	    driver.findElementByXPath("//div[@id='menuItemButton-flexible_cancellation']").click();
	    
	    driver.findElementByXPath("//button[@id='filterItem-switch-flexible_cancellation-true']").click();
	    
	    Thread.sleep(5000);
	    
	    driver.findElementByXPath("//button[@id='filter-panel-save-button']").click();
	    
	    // Select Type of Place as Entire Place and Save 
	    
	    driver.findElementByXPath("//div[@id='menuItemButton-room_type']/button").click();
	    
	    driver.findElementByXPath("//span[@class='_6fc52n']/preceding-sibling::span").click();
	    
	    Thread.sleep(4000);
	    
	    driver.findElementByXPath("//button[@id='filter-panel-save-button']").click();
	    
	    // Set Min price as 3000 and  max price as 5000 
	    
	    driver.findElementByXPath("//div[@id='menuItemButton-price_range']/button").click();
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@dir='ltr']//input[@id='price_filter_min']")));
	    
	    WebElement element = driver.findElementByXPath("//div[@dir='ltr']//input[@id='price_filter_min']");
	    
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", element);
	    
	    driver.findElementByXPath("//div[@dir='ltr']//input[@id='price_filter_min']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"3000");
	    
	    Thread.sleep(4000);
	    
	    driver.findElementByXPath("//div[@dir='ltr']//input[@id='price_filter_max']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"5000");
	    
	    Thread.sleep(4000);
	    
	    driver.findElementByXPath("//button[@id='filter-panel-save-button']").click();
	    
	    // Click More Filters and set 3 Bedrooms and 3 Bathrooms 
	    
	    driver.findElementByXPath("//div[@id='menuItemButton-dynamicMoreFilters']/button").click();
	    
	    
	    for (int i=1;i<=3;i++)
	    	
	    {
	    	
	    	driver.findElementByXPath("//div[@id='filterItem-stepper-min_bedrooms-0']/button[2][@aria-label='increase value']").click();
	    	
	    	Thread.sleep(2000);
	    }
	    
	    
	    
	    for (int i=1;i<=3;i++)
	    	
	    {
	    	
	    	driver.findElementByXPath("//div[@id='filterItem-stepper-min_bathrooms-0']/button[2][@aria-label='increase value']").click();
	    	
	    	Thread.sleep(2000);
	    }
	    
	    
	   // Check the Amenities with Kitchen, Facilities with Free parking on premisses, Property as House and Host Language as English and click on Stays only when stays available
	    
	    
	    driver.findElementByXPath("//div[text()='Kitchen']/ancestor::span/preceding-sibling::span").click();
	    
	    Thread.sleep(3000);
	    
	    driver.findElementByXPath("//div[text()='Free parking on premises']/ancestor::span/preceding-sibling::span").click();
	    
	    Thread.sleep(2000);
	    
	    driver.findElementByXPath("//div[text()='House']/ancestor::span/preceding-sibling::span").click();
	    
	    Thread.sleep(2000);
	    
	    driver.findElementByXPath("//div[text()='English']/ancestor::span/preceding-sibling::span").click();
	    
	    Thread.sleep(2000);
	    
	    driver.findElementByXPath("//footer[@class='_zgc1p6']/button[@type='button']").click();
	    
	    Thread.sleep(4000);
	    
	    // Click Prahari Nivas, the complete house 
	    
	    WebElement element2 = driver.findElementByXPath("//div[@class='_ttw0d']/a[@aria-label='Prahari Nivas, the complete house']");
	    
	    JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		
		executor1.executeScript("arguments[0].click();", element2);
	    
	    //Click on "Show all * amenities" 
	    
	    Set<String> set = driver.getWindowHandles();
	    
	    List<String> list = new ArrayList<String>();
	    
	    list.addAll(set);
	    
	    driver.switchTo().window(list.get(1));
	    
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    
	    jse.executeScript("window.scrollBy(0,250)");
	    
	    try
	    {
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='_1p3joamp']/button[text()='Show all 19 amenities']")));
	    
	    
	    driver.findElementByXPath("//div[@class='_1p3joamp']/button[text()='Show all 19 amenities']").click();
	    
	    } catch(NoSuchElementException e)
	    
	    {
	    	driver.findElementByXPath("//a[text()='Show all 19 amenities']").click();
	    	
	    }
	    
	  // Print all the Not included amenities 
	    
	   try { 
	    List<WebElement> list2 = driver.findElementsByXPath("(//div[text()='Not included']/ancestor::section)[3]//del[@aria-hidden='true']");
	    
	    
        for (WebElement eachElement :list2)
        	
        {
        	
        	System.out.println(eachElement.getText());
        
        	
        } } catch (NoSuchElementException e)
	   
	   {
        	
        	List<WebElement> list2 = driver.findElementsByXPath("(//h3[text()='Not included']/ancestor::div)[3]//del[@aria-hidden='true']");
        	
        	for (WebElement eachElement :list2)
            	
            {
            	
            	System.out.println(eachElement.getText());
            
            	
            }
        	
	   }
        
        // Verify the Check-in date, Check-out date and Guests 
        
        driver.findElementByXPath("//div/button[@aria-label='Close']").click();
        
       try
       {
       
        String checkin  = driver.findElementByXPath("//span[@id='DateInput__screen-reader-message-checkin']/following-sibling::div").getText();
        
        String checkout = driver.findElementByXPath("//span[@id='DateInput__screen-reader-message-checkout']/following-sibling::div").getText();

        System.out.println(checkin);
        
        System.out.println(checkout);
        
        String Guests = driver.findElementByXPath("//span[@class='guest-label__text guest-label__text-guests']").getText();
        
        System.out.println(Guests);
        
       } catch (NoSuchElementException e )
       
       {
    	   
    	   String checkin = driver.findElementByXPath("//div[text()='Check-in']/following-sibling::div").getText();
    	   
    	   String checkout = driver.findElementByXPath("//div[text()='Checkout']/following-sibling::div").getText();
    	   
    	   System.out.println(checkin);
           
           System.out.println(checkout);
           
           String Guests = driver.findElementByXPath("//div[@id='GuestPicker-book_it-trigger']//span").getText();
           
           System.out.println(Guests);
    	   
       }
        
        // Read all the Sleeping arrangements and Print 
       
       Map<String,String> map = new LinkedHashMap<String,String>();
       
       List<WebElement> bedrrooms = driver.findElementsByXPath("//div[contains(text(),'Bedroom')]");
       
        List<WebElement> beds = driver.findElementsByXPath("//div[contains(text(),'Bedroom')]/following-sibling::div");
        
        
        for (int i=0 ; i <= bedrrooms.size()-1;i++ )
        	
        {
        	String text = bedrrooms.get(i).getText();
        	
        	String text2 = beds.get(i).getText();
        	
        	map.put(text, text2);
        	
        }
        
        
        for ( Entry<String,String>  eachEntry:map.entrySet())
        	
        {
        	
        	System.out.println(eachEntry.getKey() +".......>"+ eachEntry.getValue());
        	
        }
        
        
        //Close all the browsers
        
		
		  driver.close();
		  
		  driver.switchTo().window(list.get(0));
		  
		  driver.close();
		 
        
        
	   
	     
	    
	      
	    
	
	
	
	
	
	
	
	
	}

}
