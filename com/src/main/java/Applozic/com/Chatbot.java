package Applozic.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chatbot {
	public static void main(String[] args) throws InterruptedException, EmailException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://test.kommunicate.io/");
		driver.switchTo().frame("Kommunicate widget iframe");
		WebElement Chatbutton = driver.findElement(By.id("launcher-svg-container"));
		Chatbutton.click();
		System.out.println("Chat Button clicked successfully");
		Thread.sleep(2000);
		WebElement FAQ = driver.findElement(By.xpath("//*[@id=\"km-faq\"]"));
		FAQ.click();
		System.out.println("FAQ button clicked successfully");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int linkcount = links.size();
		System.out.println("Total number of FAQ links=" + linkcount);
		if (linkcount < 20) {
			sentEmail2.sendEmail();
		}
		Thread.sleep(2000);
		driver.close();

	}

}
