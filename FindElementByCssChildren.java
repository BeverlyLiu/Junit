package class2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByCssChildren {
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
	public void testFindElementInForm() {
		driver.get("http://localhost:8080/workspace/xpath.html");
			WebElement input = driver.findElement(By.cssSelector("form input:first-of-type"));
			assertEquals("username2307", input.getAttribute("name"));
			
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testFindElementInForm2() {
		driver.get("http://localhost:8080/workspace/xpath.html");
			WebElement input = driver.findElement(By.cssSelector("form input:second-of-type"));
			assertEquals("password2307", input.getAttribute("name"));
			
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testFindNoElement() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		driver.findElement(By.cssSelector("form input:first-child"));
	}

}
