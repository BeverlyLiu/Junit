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

public class FindElementByCssAttributeTest {
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
	public void testFindElementByName() {
		driver.get("http://localhost:8080/workspace/search.html");
			WebElement input = driver.findElement(By.cssSelector("[name='keyword']"));
			String inputText = input.getAttribute("value");
			assertEquals("Type in your keyword", inputText);
	}
	
	@Test
	public void testFindLinkWithTargetAttribute() {
		driver.get("http://localhost:8080/workspace/links.html");
			List<WebElement> links = driver.findElements(By.cssSelector("a[target]"));
			String[] expected = {"Google site","MSN Link"};
			List<String> actual = new ArrayList<String>();
			for (WebElement link:links) {
				actual.add(link.getText());
			}
			assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testFindLinkThatOpensNewTab() {
		driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("a[target='_blank']"));
			assertEquals("MSN Link",link.getText());
	}
	
	@Test
	public void testFindSecureLink() {
		driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("#list2 a[href^='https:']"));
			assertEquals("Facebook", link.getText());
	}
	
	@Test
	public void testFindPdfLink() {
		driver.get("http://localhost:8080/workspace/links.html");
			WebElement link = driver.findElement(By.cssSelector("a[href$='.pdf']"));
			assertEquals("https://www.example.com/contract.pdf", link.getAttribute("href"));
	}
	
	@Test
	public void testFindPasswordField() {
		driver.get("http://localhost:8080/workspace/xpath.html");
			WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
			assertEquals("secret", password.getAttribute("value"));
	}
}
