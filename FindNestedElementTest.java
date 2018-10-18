package class2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindNestedElementTest {
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
	public void testFindElementInElement() {
		driver.get("http://localhost:8080/workspace/links.html");
			WebElement li1 = driver.findElement(By.tagName("li"));
			WebElement li2 = driver.findElement(By.tagName("ol")).findElement(By.tagName("li"));
			
			assertEquals("Google site",li1.getText());
			assertEquals("Testing purpose", li2.getText());
			
			List<WebElement> lis = driver.findElements(By.tagName("li"));
			WebElement li3 = lis.get(1);
			
			assertEquals(lis.size(), 8);
			assertEquals("Contract draft", li3.getText());
		
	}

}
