package class2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLinkTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testFindLinkByText() {
		driver.get("http://localhost:8080/workspace/links.html");
		WebElement link = driver.findElement(By.linkText("Facebook"));
		
		assertEquals("https://www.facebook.com/", link.getAttribute("href"));
	}
	
	@Test
	public void testFindLinkByPartialText() {
		driver.get("http://localhost:8080/workspace/links.html");
		WebElement link = driver.findElement(By.partialLinkText("Digg"));
		
		assertEquals("http://www.digg.com/", link.getAttribute("href"));
	}

}
