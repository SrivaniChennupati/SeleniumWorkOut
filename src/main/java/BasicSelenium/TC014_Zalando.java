package BasicSelenium;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC014_Zalando {
	
	

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		
	     ChromeDriver driver = new ChromeDriver(options);
		

		driver.get("https://www.zalando.com");
		
      Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		System.out.println(text);
		
		alert.accept();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		//close the Alert box and Click on Zalando.uk 
		
		
		
		driver.findElementByXPath("//div[@class='wrapper wrapper_content content']//ul/li/a[text()='Zalando.uk']").click();
		
		//click Women.> clothing and click coat
		
		Thread.sleep(7000);
		
		
	  wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='uc-banner-content ']//div[1]/span/div[@class='z-uc-head']/following::div[5]/button[@class='uc-btn uc-btn-primary']")));

	  driver.findElementByXPath("//div[@class='uc-banner-content ']//div[1]/span/div[@class='z-uc-head']/following::div[5]/button[@class='uc-btn uc-btn-primary']").click();
	
	  driver.findElementByXPath("//div[@class='z-navicat-header_topRow']/div//ul/li/a/span[text()='Women']").click();
	  
	  WebElement element = driver.findElementByXPath("//div[@class='z-navicat-header_bottomRow']//nav/ul/li[3]/a/span[text()='Clothing']");
	
	 Actions builder = new Actions(driver);
	 
	 builder.moveToElement(element).perform();
	 
	 driver.findElementByXPath("//z-grid[@spacing='gutter']//z-grid-item//a[3]/span[text()='Coats']").click();
	 
	 //Choose Material as cotton (100%) and length as thigh -length 
	 
	  driver.findElementByXPath("(//div[@class='cat_container-2yN_D']//ul/li[5]/div/button/span)[1]").click();
	  
	  Thread.sleep(4000);
	  
	  driver.findElementByXPath("//ul[@class='content cat_list-1KY6Z']/li[4]/span[text()='cotton (100%)']").click();
	  
	  //driver.findElementByXPath("//div[@class='cat_countWrapper-j43n4']").click();
	
	  driver.findElementByXPath("(//div[@class='cat_container-2yN_D']//ul/li[8]/div/button/span)[1]").click();
	  
	  Thread.sleep(6000);
	 
	  driver.findElementByXPath("(//div[@class='cat_container-2yN_D']//ul/li[8]/div/button/span)[1]").click();
	  
	  driver.findElementByXPath("//ul[@class='content cat_list-1KY6Z']/li[2]/span[text()='thigh-length']").click();
	  
	  driver.findElementByXPath("//div[@class='cat_countWrapper-j43n4']").click();
	  
	  //Click on Q/S desinged ny MANTAL-Parka coat 
	  
	  WebElement element2 = driver.findElementByXPath("//div[@class='cat_cardWrap-2UHT7']//div[@class='cat_labels-2pOCU']/div[text()='Q/S designed by']");
	  
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", element2);
	  
	  
	  //check the availability for color as Olive and size as 'M'
	  
	    driver.findElementByXPath("//div[@class='C-HkOd qtYMnP']//div[2]/div/div//div//img").click();
	    
	   boolean b = false;
	   
	    
	    try {
		   
		   
		   b = driver.findElementByXPath("//div[@class='Wqd6Qu']/h2").isDisplayed();
		   
	   } catch (NoSuchElementException e)
	   
	   {
		   
	   }
	   
	   if (b==true)
	    	
	    {
	    	
	    	 driver.findElementByXPath("(//div[@class='C-HkOd qtYMnP']//div/div/div//div/img)[2]").click();
	    	 
	    	 Thread.sleep(5000);
	    	 driver.navigate().refresh();
			   
			 driver.findElementByXPath("//div[@class='v9RC-i']//button[@id='picker-trigger']").click();
			   
			 driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']").click();
			 
			 
			try { 
				if (driver.findElementByXPath("//div[@role='dialog']//h2").isDisplayed())
				{
					System.out.println(" M size in Navy is Unavailable");
					
			} }
				catch (NoSuchElementException e)
			{
					
			}
			
			System.out.println(" Navy with M size is selcted as Olive is out of stock ");
		
			
			
			 
	}	 
				 
		     
	
			  else 
			 
	    	
	    {
	    	driver.findElementByXPath("//div[@class='v9RC-i']//button[@id='picker-trigger']").click();
			   
			 driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']").click();
			
			  if (driver.findElementByXPath("//div[@role='dialog']//h2").isDisplayed())
			  
			  { 
				  
				System.out.println(" M size in Olive  is Unavailable");
			  
			    driver.findElementByXPath("//div[@class='UyCaZm JLY-ap _4ypdpr _561T1r _2TPICz mAhwAe']/button//span[text()='close']").click();
			   
			    driver.findElementByXPath("//div[@class='v9RC-i']//button[@id='picker-trigger']").click();
				   
				 driver.findElementByXPath("//ul[@role='listbox']/li[2]/div/span[text()='S'] ").click();
				 

					System.out.println(" S size in Olive  is selected ");
			    
			    
			  }
			  
			  else
			  
			  { System.out.println("  Olive with M size is Selected ");
			  
			  }
			  
			 
	    	
	    }
		   
		   
		   
		//add the bag only if standard    Delivery is Free
	   
	   
	   String text2 = driver.findElementByXPath("//div[@class='UyCaZm']/span/following-sibling::div/div//span").getText();
	    
	    if (text2.equals("Free"))
	    	
	    {
	    	
	    	driver.findElementByXPath("//div[@class='h-container z-pdp__dx_cta_container h-align-left']/button/span[text()='Add to bag']").click();
	    	
	    }
		   
		  
	    //Mouse over on bag and click on go to bag 
	    
	    WebElement element3 = driver.findElementByXPath("//div[@class='z-navicat-header_navTools']//div[3]/a/div");
	    
	    Actions builder1 = new Actions (driver);
	    
	    builder1.moveToElement(element3).perform();
	    
	    driver.findElementByXPath("//a/div[text()='Go to bag']").click();
	    
	    //Capture the Estimated Delivery date and print
	    
	    String text3 = driver.findElementByXPath("//div[@class='z-coast-base__tile-title']/h2[text()='Estimated delivery']/following::div/span[@class='z-2-text z-2-text-body z-2-text-black']").getText();
	    
	    System.out.println(text3);
	    
	    //Mouse hover on Free Dekivery and Returns ,get the tool tip text and print 
	    
	    Thread.sleep(5000);
	    
	    driver.navigate().refresh();
	    
	   WebElement element4 = driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled'])[2]/a");
		   
		   
	   Actions builder2 = new Actions (driver);
	    
	    builder2.moveToElement(element4).perform();
	    
	    String string = driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled'])[2]").getAttribute("title");
	   
	    System.out.println(string);
	    
	    //Click on the strat chat in the start chat and go the new window 
	    
	    
	    driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled'])[2]/a").click();
	    
	    WebElement element5 = driver.findElementByXPath("//div[@class='channel__button']//button/span[text()='Start chat']");
	    
	    
	    JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		
		executor3.executeScript("arguments[0].click();", element5);
	    
	    
		
		  Set<String> set = driver.getWindowHandles();
		  
		  List<String> list = new ArrayList<String>();
		  
		  list.addAll(set);
		  
		  driver.switchTo().window(list.get(1));
		 
	    
	    //Enter your first name and a dummy email and click start chat 
	    
	    driver.findElementById("prechat_customer_name_id").sendKeys("Srivani");
	    
	    driver.findElementById("prechat_customer_email_id").sendKeys("srivanichennupati@gmail.com");
	    
	    driver.findElementByXPath("//button[@id='prechat_submit']/span").click();
	    
	    //Type Hi , Click send and print the reply message and close the chat window 
	    
	    Thread.sleep(10000);
	    
	    driver.findElementById("liveAgentChatTextArea").sendKeys("Hi");
	    
	    driver.findElementByXPath("//button[text()='Send']").click();
	    
	    String text4 = driver.findElementByXPath("//span[@class='name']/following::span[@class='messageText' and text()='Hi there! How can I help you?']").getText();
	    
	    System.out.println(text4);
	    
	  
	    
	  
	   
	   
	   
	   
	   }
	   
	    
	   
	
	}


