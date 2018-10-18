package class2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementDemo {
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
	public void testFindElementById() {
		driver.get("http://localhost:8080/workspace/helloworld.html");
			WebElement h1 = driver.findElement(By.id("title"));
			assertEquals("Hello World", h1.getText());
	}
	
	@Test
	public void testFindElementByName() {
		driver.get("http://localhost:8080/workspace/search.html");
			WebElement input = driver.findElement(By.name("keyword"));
			String inputText = input.getAttribute("value");
			assertEquals("Type in your keyword", inputText); 
	}
	
	@Test
	public void testFindElementByClassName() {
		driver.get("http://localhost:8080/workspace/search.html");
			WebElement label = driver.findElement(By.className("label"));
			assertEquals("Search", label.getText());
	}
	
	@Test
	public void testFindElementByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
			WebElement label = driver.findElement(By.tagName("label"));
			assertEquals("Search2", label.getText());
	}
	
	@Test
	public void testFindElementsByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
			List<WebElement> labels = driver.findElements(By.tagName("label"));
			assertEquals(2, labels.size());
			String[] expected = {"Search2", "Search"};
			List<String> actual = new ArrayList<String>();
			for (WebElement label:labels) {
				actual.add(label.getText());
			}
			assertArrayEquals(expected, actual.toArray());
	}
}
