package bank;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends Data {

	@BeforeTest
	public void setup() {
		driver.get(BankURL);
		driver.manage().window().maximize();
		
	}
	
	@Test()
	public void firstTest() {
		
	}
	
	@AfterTest()
	public void afterTest() {
		
	}
}
