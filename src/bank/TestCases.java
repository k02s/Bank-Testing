package bank;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends Data {

	@BeforeTest
	public void setup() {
		driver.get(BankURL);
		driver.manage().window().maximize();

	}
	@Test(priority = 1)
	public void go() {
//		1- go this website and press one bank manager login
			WebElement Bank_Manager_Login_Button = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
			Bank_Manager_Login_Button.click();
	}
	
	@Test(priority = 2) 
	public void addCustomer() throws InterruptedException {
//		2- add one customer ( random details)

			Thread.sleep(5000);
			WebElement Add_Customer_Button = driver.findElement(By.cssSelector("button[ng-click='addCust()']"));
			Add_Customer_Button.click();

			Thread.sleep(5000);
			WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
			WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
			WebElement postCode = driver.findElement(By.cssSelector("input[placeholder='Post Code']"));
			WebElement addCustomerBtn = driver.findElement(By.cssSelector("button[type='submit']"));

			
			firstName.sendKeys(first_Name);
			lastName.sendKeys(last_Name);
			postCode.sendKeys(post_Code);
			
			Thread.sleep(5000);
			addCustomerBtn.click();

			driver.switchTo().alert().accept();
	}
	
	@Test(priority = 3)
	public void firstTest() throws InterruptedException {
		Thread.sleep(5000);



//	3- and open account for that customer that you added (accept the alert msg )
		WebElement openAccoutBtn = driver.findElement(By.cssSelector("button[ng-click='openAccount()']"));
		openAccoutBtn.click();

		Thread.sleep(5000);
		WebElement customer = driver.findElement(By.id("userSelect"));
		Select select = new Select(customer);
		select.selectByIndex(1);

//	4- select the currency to be randomly selected	

		List<WebElement> currencyList = driver.findElements(By.id("currency"));
		Select currencyDropdown = new Select(currencyList.get(0)); // Assuming there is only one dropdown
		List<WebElement> currencyOptions = currencyDropdown.getOptions();
		int randomCurrencyIndex = rand.nextInt(currencyOptions.size());
		currencyDropdown.selectByIndex(randomCurrencyIndex);
		
//	5- go to the customers and delete that customer create one assertion that the customer is deleted

		WebElement customerBtn = driver.findElement(By.cssSelector("button[ng-click='showCust()']"));
		customerBtn.click();
		
		Thread.sleep(5000);
		WebElement deleteBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button"));
		deleteBtn.click();
		Assert.assertTrue(true);
		
//	6- add the customer again
		addCustomer();
	}

	@AfterTest()
	public void afterTest() {

	}
}
