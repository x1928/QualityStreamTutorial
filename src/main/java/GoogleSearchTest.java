import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchTest {

  public static WebDriver driver;

  @BeforeAll
  static void setUp() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void testGooglePage(){
    driver.get("https://www.google.com/");
    WebElement searchBox = driver.findElement(By.name("q"));

    searchBox.clear();

    searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");

    searchBox.submit();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());
  }

  @AfterAll
  static void tearDown(){
    driver.quit();
  }
}