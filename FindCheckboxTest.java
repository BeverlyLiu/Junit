package class2;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCheckboxTest {
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
	public void testFindCheckedLanguages() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		
		//invalid findElement b/c the code does not simulate user's behavior.
		
		//List<WebElement> languages = driver.findElements(By.cssSelector("#languages li input:checked"));
		
		List<WebElement> languages = driver.findElements(By.cssSelector("#languages li input:checked + label"));
		
		String[] expected = {"English","Spanish"};
		List<String> actual = new ArrayList<String>();
		//for(WebElement ckbox: languages) {
			//actual.add(ckbox.getAttribute("name"));
		//}
		
		for(WebElement label:languages) {
			actual.add(label.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testFindCheckedCode() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> languages = driver.findElements(By.xpath("//*[@id='skills']//input[@checked='checked']/.."));
		String[] expected = {"Java","C#"};
		List<String> actual = new ArrayList<String>();
		
		for(WebElement entry:languages) {
			actual.add(entry.getText());
		}
		assertArrayEquals(expected,actual.toArray());
		}
}
