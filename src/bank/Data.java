package bank;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Data {
	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	
	static String BankURL = "https://globalsqa.com/angularJs-protractor/BankingProject/#/login";
	
	static String FirstNames[] = { "Khadijah", "Sabah", "Eman" };
	static String LastNames[] = { "Ahmad", "Saleh", "Ali" };
	int RandomNumberForNameIndex = rand.nextInt(3);

	String first_Name = FirstNames[RandomNumberForNameIndex];
	String last_Name = LastNames[RandomNumberForNameIndex];
	
	static String PostCode[] = {"123", "345" , "567"};
	int randomPostCode = rand.nextInt(3);
	String post_Code = PostCode[randomPostCode];
	
}
