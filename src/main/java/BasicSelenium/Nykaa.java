package BasicSelenium;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		
		WebElement element = driver.findElementByXPath("//a[text()='brands']");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(element).perform();
		
		Thread.sleep(7000);
		
		
		WebElement ele = driver.findElementByXPath("//a[text()='Popular']");
	

		Actions builder1 = new Actions(driver);
		
		builder1.moveToElement(ele).perform();
		
		
		driver.findElementByXPath("(//a[@target='_blank'])[9]").click();
		
		
		Set<String> set = driver.getWindowHandles();
		
		System.out.println(set);
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.addAll(set);
		
		driver.switchTo().window(list.get(1));
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		if (title.contains("L'Oreal"))
			
		{
			
			System.out.println("Title contains LOreal Paris ");
		}
		
		
		driver.findElementByXPath("(//span[text()='popularity'])[1]").click();
		
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		
		Thread.sleep(4000);
		
		driver.findElementByXPath("//div[text()='Category']").click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//span[text()='Shampoo (21)']").click();

		
		String text = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']").getText();
		
		System.out.println(text);
		
		if (text.contains("Shampoo"))
			
		{
			
			System.out.println("Filter Applied with shampoo");
		}
		 
		 
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[4]").click();
		 
		 
		  Set<String> set2 = driver.getWindowHandles();

	    ArrayList<String> list2 = new ArrayList<String>();
			
			list2.addAll(set2);
			
			System.out.println(set2);
			
			driver.switchTo().window(list2.get(2));
		  
		  
		 
		 driver.findElementByXPath("//span[text()='175ml']").click();
		 
		 String text2 = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText().replaceAll("\\D","");
		 
		 System.out.println("MRP OF THE PRODUCT IS :"  +text2);
		 
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("(//div[@class='pull-left'])[1]").click();
		 
		 driver.findElementByXPath("//div[@class='AddToBagbox']").click();
		 
		 String text3 = driver.findElementByXPath("//div[@class='value medium-strong']").getText().replaceAll("\\D","" );
		 
		 System.out.println("GRAND TOTAL IS :"  +text3);
		 
		 driver.findElementByXPath("(//button[@type='button'])[5]").click();
		 
		 Thread.sleep(3000);
		 
		 driver.findElementByXPath("(//button[@type='button'])[2]").click();
		 
		 String text4 = driver.findElementByXPath("//div[text()='Please expect delay in shipments because of the national lockdown']").getText();
		 
		 System.out.println("Warning Message:"  +text4);
		 
		 driver.close();
		 
		 driver.switchTo().window(list.get(1));
		 
		 driver.close();
		 
		 driver.switchTo().window(list.get(0));
		 
		 driver.close();
		 
		 
	}

}
