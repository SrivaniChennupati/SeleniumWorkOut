package BasicSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class TC006_BigBasket {

	public static void main(String[] args) throws InterruptedException {
	
		
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		 ChromeDriver driver = new ChromeDriver();
		
		 driver.get("https://www.bigbasket.com/");
		    
		 driver.manage().window().maximize();
		    
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 // Changing location to chennai
		    
	     driver.findElementByXPath("//input[@value='Change Location']").click();
			  
	    driver.findElementByXPath("(//div[@placeholder='Select your city'])[1]").click();
			  
	    driver.findElementByXPath("(//span[text()='Chennai'])[1]").click();
			  
	    driver.findElementByXPath("(//input[@placeholder='Enter your area / apartment / pincode'])[1]").sendKeys("600119");
			  
	    driver.findElementByXPath("//button[text()='Continue']").click();
			  
			  
	     //mouse over on  Shop by Category 
			  
	    WebElement element = driver.findElementByXPath("//a[text()=' Shop by Category ']");
			  
		Actions builder = new Actions(driver);
			  
		builder.moveToElement(element).perform();
			  
	   // Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
			  
	   WebElement element2 = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[1]");
			  
	   JavascriptExecutor executor = (JavascriptExecutor)driver ;
			  
	   executor.executeScript("arguments[0].click();", element2);
			     
	   Thread.sleep(4000);
			    
	   driver.findElementByXPath("(//span[text()='Rice & Rice Products'])[1]").click();
			     
			     
	   // Click on Boiled & Steam Rice
			     
	    WebElement element3 = driver.findElementByXPath("(//span[text()='Boiled & Steam Rice'])[1]");
			     
	    JavascriptExecutor executor1 =  (JavascriptExecutor)driver ;
				    
	    executor.executeScript("arguments[0].click();", element3);
			     
		//Choose the Brand as bb Royal
				    
		driver.findElementByXPath("(//div[@class='col-xs-12 checkbox ng-scope']/following::span[text()='bb Royal'])[1]").click();
			    
	     // Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
			     
		//when  the DOM has changed e.g. through the update action, you are receiving a StaleElementReference Error.
			    
			     
			     WebElement element4 = driver.findElementByXPath("(//a[contains(text(),'Ponni Boiled Rice - Super Premium')]/following::button[@class='btn btn-default dropdown-toggle form-control'])[1]");
			  
			    Actions builder1 = new Actions(driver);
			    
			    builder1.moveToElement(element4).click().build().perform();
			     
			     WebElement element5 = driver.findElementByXPath("(//a[contains(text(),'Ponni Boiled Rice - Super Premium')]/following::span[text()='5 kg'])[1]");
			  
			     JavascriptExecutor executor3 =  (JavascriptExecutor)driver ;
				    
			     executor.executeScript("arguments[0].click();", element5);
			     
			   //print the price of Rice
			     
			     String text =driver.findElementByXPath("(//a[contains(text(),'Ponni Boiled Rice - Super Premium')]/following::span[@class='discnt-price'])[1]").getText().replaceAll("\\D","");
			     
			     System.out.println(text);
			     
			     int RicePrice = Integer.parseInt(text);
			     
			   //Click Add button
			     
			     WebElement element6 = driver.findElementByXPath("(//a[contains(text(),'Ponni Boiled Rice - Super Premium')]/following::button[@qa='add'])[1]");
			     
			     JavascriptExecutor executor2 =  (JavascriptExecutor)driver ;
				    
			     executor.executeScript("arguments[0].click();", element6);
			     
			   
			     
			    //  Type Dal in search filed and enter
			     
			     
			     driver.findElementById("input").sendKeys("dal",Keys.ENTER);
			     
			     //Go to Toor/Arhar Dal and select 2kg & set Qty 2 
			     
			     driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::button[@type='button'])[1]").click();
			     
			     Thread.sleep(3000);
			     
			     driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::span[text()='2 kg'])[1]").click();
			     
			     //driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::input[@type='text'])[1]").click();
			     
			     driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::input[@type='text'])[1]").clear();
			     
			     driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::input[@type='text'])[1]").sendKeys("2");
			     
			     
			     //Print the price of Dal
			     
			     
			      String text2 = driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::span[@class='discnt-price'])[1]").getText().replaceAll("\\D","");
			     
			      System.out.println(text2);   
			       
			      int dalprice = Integer.parseInt(text2);
			     
			      int total =  dalprice + RicePrice;
			     
			       System.out.println(total);
			     
			     String string = Integer.toString(total);
			         
			          
			     
			 	// Click Add button    
			   driver.findElementByXPath("(//a[contains(text(),'Toor/Arhar Dal/Thuvaram Paruppu')]/following::button[text()='Add '])[1]").click();
			   
			    WebDriverWait wait = new WebDriverWait (driver,30) ;
			    
			    try {
			    
			    wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='toast-title']")));
			    
				String dal = driver.findElementByXPath("//div[@class='toast-title']").getText();
				
				System.out.println(dal);
				
			    } catch(Exception e)
			    
			    {
			    	System.out.println("Dal added message disappered");
			    	
			    }
			   
			   Thread.sleep(10000);
			   
			   
			   		   
			   // Mouse hover on My Basket
			    
			    WebElement element7 = driver.findElementByXPath("//div[@class='dropdown checkout-section hvr-drop hidden-xs hidden-sm']");
			    Actions builder3 = new Actions(driver);
			    
			    builder3.moveToElement(element7).perform();
			    
			    //Validate the Sub Total displayed for the selected items
		  
			    WebDriverWait wait1 = new WebDriverWait (driver,30) ;
			    
			    wait1.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@qa='subTotalMB']")));
			     
			     String text3 = driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
			     
			     System.out.println(text3);
			     
			     if (string.equals(text3))
			    	 
			     {
			    	 
			    	 System.out.println("Subtotal is matching with the prices of the products ");
			     }
			     
			     else 
			    	 
			     {
			    	 System.out.println("Subtotal is not  matching with the prices of the products ");
			     }
			     
			     
			     
               // Reduce the Quantity of Dal as 1 
			     
			     
			     wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@class='btn-counter row']/button[@qa='decQtyMB'])[2]")));
			     
			     driver.findElementByXPath("(//div[@class='btn-counter row']/button[@qa='decQtyMB'])[2]").click();
			     
			     // validate the subtotal for current items
			     
			     
			     driver.navigate().refresh();
			     
			     WebElement element8 = driver.findElementByXPath("//div[@class='dropdown checkout-section hvr-drop hidden-xs hidden-sm']");
				    Actions builder4 = new Actions(driver);
				    
				    builder3.moveToElement(element8).perform();
			     
			     
			     WebDriverWait wait2 = new WebDriverWait(driver,40);
			     
                 wait2.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@qa='subTotalMB']")));
			     
			     String text5 = driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
			     
			     String string2 = text5.substring(0, 3);
			     
			     System.out.println(string2);
			     
		
			     Assert.assertEquals(string2, string);
			  
			     
			     System.out.println("Subtotal is getting matched with  total amount of the Products after decresing the dal count by 1");
			     
			       
	}
			   
	}


			 
			 
		    
		   