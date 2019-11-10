import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Modular {
	static ArrayList<String>itemList= new ArrayList<String>();
	static ArrayList<String>itemListPurchased= new ArrayList<String>();
	static ArrayList<Integer>productPrice= new ArrayList<Integer>();
	static ArrayList<String>itemListCheckedOut= new ArrayList<String>();
	public static float sum = 0;

    //Creating a driver object referencing WebDriver interface
   static WebDriver driver;
   static WebDriverWait wait;
   static String fName = "test";
   static String lName = "test1";
   static String zipCode = "22031";
    
   
   @Test (priority = 1)
	public static void login()
	{
		String uname = "standard_user";
		String password = "secret_sauce";
		
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@class='btn_action']")).click();
		
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();	
		WebElement sortItem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[@class='product_sort_container']//option[1]"))));
		sortItem.click();
	}
   
	
   @Test (priority = 2)
   public static void  itemToPurchase()
   {
	for(int i = 1; i < 4 ; i++)
	{
	  WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_list']//div["+i+"]//div[2]//a[1]//div[1]")));	
      String itemName = element.getText();
	  itemList.add(itemName);
	}
	
	System.out.println("Item  to Purchase :"+ itemList);
	}
	
	
   @Test (priority = 4)
   public static void itemPurchased() throws InterruptedException
	{
	  itemListPurchased.clear();	
	  for(int i = 3; i < 6 ; i++)
	  {
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='cart_list']//div["+i+"]//div[2]/a[1]/div[1]"))));
	    String itemNamePurchased=element.getText();	
	    itemListPurchased.add(itemNamePurchased);
	  }
	
	  System.out.println("Item Purchased :"+itemListPurchased);
	}
   
	
   @Test (priority = 5)
	public static void removeElement() throws InterruptedException
	{   
	  WebElement removeItem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='cart_list']//div[3]//button[1]"))));   
	  
	  if (removeItem.isDisplayed() & removeItem.isEnabled() & removeItem.isSelected()) 
	  {
		 removeItem.click();		 
	  }
	  else
	  {
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='cart_list']//div[3]//button[1]"))));
		 removeItem.click();
	  }
	
	  WebElement cartBtn = driver.findElement(By.xpath("//a[@class='btn_secondary']"));	
	  cartBtn.click();
	 
	  driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS );
	  WebElement newItem = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[6]//div[3]//button[1]"))));

	  if (newItem.isDisplayed() & newItem.isEnabled() & newItem.isSelected()) 
	  {
		 newItem.click();
	  }
	  else
	  {
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[6]//div[3]//button[1]"))));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]//div[3]//button[1]")));
			
		 newItem.click();
	  }
			
      WebElement shoppingCart =driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
    
      
      
      Thread.sleep(3000);	
      newItem.click();
      shoppingCart.click();
	}
	
   
   
   @Test (priority = 3)
	public static void itemToAdd() 
	{	
	  for(int i = 1; i < 4 ; i++)
	  {	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_list']//div["+i+"]//div[3]//button[1]")));
		element.click(); 
	  }
	 
	  WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shopping_cart_container']")));
	  element1.click();	
	}
   
   
   @Test (priority = 6)
   public static void verifying_Items() throws InterruptedException
   {
	   itemPurchased();   
   }
   
   
	@Test (priority = 7)
	public static void  totalPrice()
	{	
	  productPrice.clear();
	  float a = 0 ;
	  for(int i = 3; i < 6 ; i++)
	  {
	
	    String price=driver.findElement(By.xpath("//div[@class='cart_list']//div["+i+"]//div[2]/div[2]/div[1]")).getText();	
	    float result = Float.parseFloat(price);
	    a= a + result;	
	  }
	  
	  modular.sum = a;
	  System.out.println("sum is :" + modular.sum);	
	}
	
	
	@BeforeClass
	public void init()
	{
		  //Setting the webdriver.chrome.driver property to its executable's location
        System.setProperty("webdriver.chrome.driver", "C:/Users/Sumit/chromedriver.exe");
	   
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    
        //Using get() method to open a webpage
        driver.get("https://www.saucedemo.com/");
        
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS );
	}
	
	
	 @Test (priority = 10)
	 public static void starting() throws InterruptedException{
	   try {
	             
	        String totalPurchasedPrice =driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
	        String[] parts = totalPurchasedPrice.split(Pattern.quote("$"));
	        System.out.println(totalPurchasedPrice);
	       
	        String sum_next = parts[1]; // 034556
	       
	    	float sum_final = Float.parseFloat(sum_next);
	    	System.out.println(modular.sum);
	    	System.out.println(sum_final);
	    	Assert.assertEquals(modular.sum, sum_final);
	      
	        System.out.println("Total price before and after checkout matches");
			WebElement finishBtn = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
			finishBtn.click();
			
			WebElement finalMsg = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2"));
			System.out.println(finalMsg.getText()); 
			
	    }
	    catch (AssertionError error) 
	    {
	            // Output expected AssertionErrors.
	        System.out.println("Total price before and after checkout does not match. Assertion error");
	    }
	 }
	 
	 
	 @AfterClass
	 public void quit()
	 {
	//Closing the browser
       driver.quit();
	 }
	 
	 
	 @Test (priority = 8)
	 public static void checkoutInfo() throws InterruptedException
	 {
		 driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS );
		 Thread.sleep(2000);
	     WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn_action checkout_button']")));
		 checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
		
	     checkoutBtn.click();
	     Thread.sleep(2000);
	     
	     WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@id='first-name']")));
	     fname = driver.findElement(By.xpath( "//input[@id='first-name']"));
	      
	     WebElement lname  =driver.findElement(By.xpath( "//input[@id='last-name']"));
	     WebElement zipcode  =driver.findElement(By.xpath( "//input[@id='postal-code']"));
	     
	     fname.sendKeys(fName);
	     lname.sendKeys(lName);
	     zipcode.sendKeys(zipCode);
	        
	     WebElement continueBtn  =driver.findElement(By.xpath( "//input[@class='btn_primary cart_button']"));
	     continueBtn.click();
	 }
	 
	 
	 @Test (priority = 9)
	
	 public static void  itemCheckedOut()
	 {
		itemListCheckedOut.clear();	
		for(int i = 3; i < 6 ; i++)
		{
		  String itemNameCheckedOut=driver.findElement(By.xpath("//div[@class='cart_list']//div["+i+"]//div[2]/a[1]/div[1]")).getText();	
		  itemListCheckedOut.add(itemNameCheckedOut);
		}
		System.out.println("Item Purchased :"+itemListCheckedOut);
		
	 }
  }
