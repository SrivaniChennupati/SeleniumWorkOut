package BasicSelenium;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC012_Carwale {

	public static void main(String[] args) throws InterruptedException {
		

	       System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			
			ChromeDriver driver = new ChromeDriver(options);
			

			driver.get("https://www.carwale.com/");

			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			//Click on Used 
			
			driver.findElementByXPath("//ul[@id='newUsedSearchOption']/li[2]").click();

	
	       //Select the City as Chennai 
			
			
			driver.findElementByXPath("//div[@class='welcome-box__new-used-content']/div/input[@id='usedCarsList']").sendKeys("Chennai");
			
			Thread.sleep(4000);
			
			driver.findElementByXPath("//div[@class='welcome-box__new-used-content']/div/input[@id='usedCarsList']").sendKeys(Keys.ENTER);
			
			
	       //Select budget min (8L) and max(12L) and Click Search 
			
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='welcome-box__new-used-content']//div[2]/div/span[@id='budgetBtn']")));
			
			driver.findElementByXPath("//div[@class='welcome-box__new-used-content']//div[2]/div/span[@id='budgetBtn']").click();
			
	
			WebElement element3 = driver.findElementByXPath("//div[@id='budgetListContainer']/div/input/following::ul[@id='minPriceList']/li[text()='8 Lakh']");
			
            JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			
			executor3.executeScript("arguments[0].click();", element3);
			
			
		   WebElement element4 = driver.findElementByXPath("//div[@id='budgetListContainer']/div/input[2]/following::ul[2]/li[text()='12 Lakh']");
	
			
		    JavascriptExecutor executor4 = (JavascriptExecutor)driver;
					
		    executor4.executeScript("arguments[0].click();", element4);
			
			
	       //Select Cars with Photos under Only Show Cars With 
			
			
			driver.findElementByXPath("//div[@class='welcome-box__new-used-content']/following::button").click();
			
			Thread.sleep(6000);
			
			driver.findElementByXPath("//div[@id='locationProceed']//div[2]/div/input").sendKeys("chennai");
			
			driver.findElementByXPath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content multiselectUl']/li/a").click();
			
			driver.findElementByXPath("//div[@id='filters']//div[6]/h3/following-sibling::div/ul/li/span").click();
	
	       //Select Manufacturer as "Hyundai" --> Creta
			
			Thread.sleep(6000);
			
			//driver.navigate().refresh();
			
			WebElement element = driver.findElementByXPath("//div[@id='filters']//div[8]/h3/following::ul/li/span[text()=' Hyundai ']");
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			executor.executeScript("arguments[0].click();", element);
			
			Thread.sleep(3000);
			
			
			
			WebElement element2 = driver.findElementByXPath("//div[@id='filters']//div[8]/h3/following::ul/li/span[text()=' Hyundai ']/following::div/ul/li/span");
      
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			
			executor1.executeScript("arguments[0].click();", element2);
			
			//Select Fuel Type as Petrol 
			
			Thread.sleep(7000);

			WebElement element5 = driver.findElementByXPath("//div[@id='filters']//div[12]/h3");
			
            JavascriptExecutor executor5 = (JavascriptExecutor)driver;
			
			executor5.executeScript("arguments[0].click();", element5);
			
			WebElement element6 = driver.findElementByXPath("//div[@id='filters']//div[12]/h3/following::div/ul/li/span[text()='Petrol']");
			
			 JavascriptExecutor executor6 = (JavascriptExecutor)driver;
				
		    executor6.executeScript("arguments[0].click();", element6);
			
			
			
			//Select Best Match as "KM: Low to High" 
		    
		    WebElement element7 = driver.findElementByXPath("//div[@class='leftfloat padding-right10 grid-3 alpha position-rel']/div[2]/select[@id='sort']");
			
			
		    JavascriptExecutor executor7 = (JavascriptExecutor)driver;
			
		    executor7.executeScript("arguments[0].click();", element7);
		    
		    Select se = new Select(element7);
		    
		    se.selectByVisibleText("Price: Low to High");
		    
		    //Validate the Cars are listed with KMs Low to High
		    
		    List<WebElement> list = driver.findElementsByXPath("//table[@class='grid-12 omega alpha card-detail-block__data-table']/tbody/tr[3]/td/table/tbody/tr/td/span[@class='slkms vehicle-data__item']");
		    
		    int size = list.size();
		    System.out.println(size);
		    
		    List<Integer> list1 = new ArrayList<Integer>();
		    
		    for (int i=0;i<=list.size()-1;i++)
		    	
		    {
		    	
		    	String text = list.get(i).getText().replaceAll("\\D","");
		    	
		    	 int a = Integer.parseInt(text); 
		    	 
		    	 list1.add(a);
		    	
		    
		    	
		    }
		    
		    System.out.println(list1);
		    
		    List<Integer> list2 = new ArrayList<Integer>();
		    
		    list2.addAll(list1);
		    
		    Collections.sort(list2);
		    
		    System.out.println(list2);
		    
		    if (list2.equals(list1))
		    		
		    		{
		    	      System.out.println("Sorting happened from Low to High ");
		    	
		    		}
		    
		    else 
		    	
		    {
		    	System.out.println("Sorting didnt happen in a correct way ");
		    	
		    }
		    
		     
		    // Add the least KM ran car to Wishlist 
		    
		    
		    Integer minKM = Collections.min(list2);
		    
		    System.out.println(minKM);
		    
		    String string = Integer.toString(minKM);
		    
		    StringBuilder builder = new StringBuilder(string).insert(string.length()-3,",");
		    
		    System.out.println(builder);
		    
		    
		    WebElement element8 = driver.findElementByXPath("//span[contains(text(),'"+builder+"')]/ancestor::div[@class='stock-detail']//div[@class='image-wrapper__container']//a/following-sibling::span[@class='shortlist-icon--inactive shortlist']");
            JavascriptExecutor executor8 = (JavascriptExecutor)driver;
			
		    executor8.executeScript("arguments[0].click();",element8);
		    
		    //Go to Wishlist and Click on More Details 
		    
		    
		    WebElement element9 = driver.findElementByXPath("//div[@class='usedsearch-floating-strip float']/ul/li");
		    
           JavascriptExecutor executor9 = (JavascriptExecutor)driver;
			
		    executor9.executeScript("arguments[0].click();",element9);
		    
		    driver.findElementByXPath("//div[@class='shortlistCardetails']//p[6]/a").click();
		    
		    //) Print all the details under Overview  
		    
		    Set<String> set = driver.getWindowHandles();
	     	 
	     	 List<String> list4 = new ArrayList<String>();
	     	 
	     	 list4.addAll(set);
	     	 
	     	 driver.switchTo().window(list4.get(1));
	     	 
	     	 Map<String,String> map = new LinkedHashMap<String,String>();
	     	 
	     	 
	     	 List<WebElement> list3 = driver.findElementsByXPath("//div[@id='overview']//li/div[@class='equal-width text-light-grey']");
	     	 
                  List<WebElement> list5 = driver.findElementsByXPath("//div[@id='overview']//li/div[@class='equal-width text-light-grey']/following-sibling::div[@class='equal-width dark-text']");
	     	 
	     	 for (int i=0;i<=list3.size()-1;i++)
	     	 {
	     		 
	     		 String text = list3.get(i).getText();
	     		 
	     		 String text2 = list5.get(i).getText();
	     		 
	     		 
	     		 
	     		map.put(text, text2);
	     		 
	     		 
	     		 
	     	 }
	     	 
	     	 
	     	 for (Entry<String,String> eachEntry:map.entrySet())
	     		 
	     	 {
	     		 System.out.println(eachEntry.getKey() +"........>"+  eachEntry.getValue());
	     		 
	     	 }
	     	 
		    //Close the browser.
	     	 
		/*
		 * driver.close();
		 * 
		 * driver.switchTo().window(list4.get(0));
		 * 
		 * driver.close();
		 */
		    
		    
	
	}

}
