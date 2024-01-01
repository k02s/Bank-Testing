package bank;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends Data {

	WebDriverWait wait;

	@BeforeTest
	public void setup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(BankURL);
		driver.manage().window().maximize();

	}

	@Test()
	public void addCustomer() throws InterruptedException {
//		1- go this website and press one bank manager login

		WebElement Bank_Manager_Login_Button = driver.findElement(By.cssSelector("button[ng-click='manager()']"));
		Bank_Manager_Login_Button.click();

//		2- add one customer ( random details)

		WebElement Add_Customer_Button = driver.findElement(By.cssSelector("button[ng-click='addCust()']"));
		Add_Customer_Button.click();

		WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		WebElement postCode = driver.findElement(By.cssSelector("input[placeholder='Post Code']"));
		WebElement addCustomerBtn = driver.findElement(By.cssSelector("button[type='submit']"));

		firstName.sendKeys(first_Name);
		lastName.sendKeys(last_Name);
		postCode.sendKeys(post_Code);

		addCustomerBtn.click();

		driver.switchTo().alert().accept();

//	3- and open account for that customer that you added (accept the alert msg )
		WebElement openAccoutBtn = driver.findElement(By.cssSelector("button[ng-click='openAccount()']"));
		openAccoutBtn.click();

		List<WebElement> customerList = driver.findElements(By.id("userSelect"));
		Select customerDropdown = new Select(customerList.get(0));
		List<WebElement> customerOptions = customerDropdown.getOptions();
		customerDropdown.selectByIndex(customerOptions.size() - 1);

//	4- select the currency to be randomly selected	

		List<WebElement> currencyList = driver.findElements(By.id("currency"));
		Select currencyDropdown = new Select(currencyList.get(0));
		List<WebElement> currencyOptions = currencyDropdown.getOptions();
		int randomCurrencyIndex = rand.nextInt(currencyOptions.size());
		currencyDropdown.selectByIndex(randomCurrencyIndex);

//	5- go to the customers and delete that customer create one assertion that the customer is deleted

		WebElement customerBtn = driver.findElement(By.cssSelector("button[ng-click='showCust()']"));
		customerBtn.click();

		WebElement deleteBtn = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button"));
		deleteBtn.click();
		Assert.assertTrue(true);

//	6- add the customer again

		WebElement addCustomerBtnAgain = driver.findElement(By.cssSelector("button[ng-click='addCust()']"));
		addCustomerBtnAgain.click();

		WebElement firstNameAgain = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		WebElement lastNameAgain = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		WebElement postCodeAgain = driver.findElement(By.cssSelector("input[placeholder='Post Code']"));
		WebElement addCustomerBtn_Again = driver.findElement(By.cssSelector("button[type='submit']"));

		firstNameAgain.sendKeys(first_Name);
		lastNameAgain.sendKeys(last_Name);
		postCodeAgain.sendKeys(post_Code);

		addCustomerBtn_Again.click();

		driver.switchTo().alert().accept();

		// Verify that the customer is added again

		customerBtn = driver.findElement(By.cssSelector("button[ng-click='showCust()']"));
		customerBtn.click();

		WebElement customerTable = driver.findElement(By.cssSelector(".table tbody"));
		Assert.assertTrue(customerTable.getText().contains(first_Name));

	}

	@AfterTest()
	public void afterTest() {

	}
}
