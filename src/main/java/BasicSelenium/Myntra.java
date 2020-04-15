package BasicSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(10000);
		
		WebElement element = driver.findElementByLinkText("Women");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(element).perform();
		Thread.sleep(10000);
		
		driver.findElementByLinkText("Jackets & Coats").click();
		
		
		String text = driver.findElementByXPath("//span[@class='title-count']").getText().replaceAll("\\D", "");
		
		System.out.println(text);
		
		
		int total = Integer.parseInt(text);
		
		String text2 = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText().replaceAll("\\D","");
		
		System.out.println(text2);
		
		int Jackets = Integer.parseInt(text2);
		
		String text3 = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText().replaceAll("\\D","");
		
		System.out.println(text3);
		
		int Coates = Integer.parseInt(text3);
		 
		int total1 =  Jackets +  Coates;
		
		System.out.println(total1);
		
		if (total1== total)
			
		{
			
			System.out.println("SUM OF CATEGORIES COUNT MATCHED");
			
		}
		
		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		
		Thread.sleep(7000);
		
		driver.findElementByXPath("(//ul[@class='brand-list']/following::div)[1]").click();
		
			
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		
		Thread.sleep(6000);
		
		driver.findElementByXPath("//ul[@class='FilterDirectory-list']//label").click();
		
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		Thread.sleep(7000);
		
		List<WebElement> list1 = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
		
		System.out.println(list1.size());
	
		
	   for (int i=1 ;i<=list1.size()-1;i++)
		   
	   
	   {
		   
		 String text4 = list1.get(i).getText();
		 
		 Assert.assertEquals(text4, "MANGO");
		 
		   
		
	   }
	   
	
	   System.out.println("All brands are belongs to Mango");
	   
	  
	   WebElement element2 = driver.findElementByXPath("//div[@class='horizontal-filters-sortContainer']");
	   
	   Actions builder1 = new Actions(driver);
	   
	   builder1.moveToElement(element2).perform();
	   
	   
	  driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
	  
	  Thread.sleep(10000);
	  
	  List<WebElement> list = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
	  
	  String text4 = list.get(0).getText();
	  
	  System.out.println(text4);
	  
	  
	  Thread.sleep(10000);
	  
	  
	  WebElement ele = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1]");
	  
	  Actions builder2 = new Actions(driver);
	  
	  builder2.moveToElement(ele).perform();
	  
	  driver.findElementByXPath("(//div[@class='product-actions product-prelaunchActions']/span)[1]").click();
	  
	  driver.close();
		
	}

	}

