package Teste;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PO.AmericanasPO;
import PO.LivrariaCulturaPO;
import PO.SubmarinoPO;

public class TesteLivros {
	WebDriver driver;
	@Before
	public void antes() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver85.exe");
		driver = new ChromeDriver();
		
	}
	@Test
	public void testeLivros() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(ConfigProjeto.URL_SUBMARINO);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SubmarinoPO.CAMPO_PESQUISA));
	    driver.findElement(SubmarinoPO.CAMPO_PESQUISA).sendKeys("Livros");
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(SubmarinoPO.LBL_LIVRO));
	    driver.findElement(SubmarinoPO.LBL_LIVRO).click();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(SubmarinoPO.ITEM));
	    driver.findElement(SubmarinoPO.ITEM).click();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(SubmarinoPO.LBL_ISBN));
		String isbn =driver.findElement(SubmarinoPO.LBL_ISBN).getText();
		String autor =driver.findElement(SubmarinoPO.LBL_AUTOR).getText();
		Thread.sleep(1000);
		driver.get(ConfigProjeto.URL_AMERICANAS);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericanasPO.CAMPO_PESQUISA));
	    driver.findElement(AmericanasPO.CAMPO_PESQUISA).sendKeys(isbn);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(SubmarinoPO.ITEM));
	    driver.findElement(AmericanasPO.ITEM).click();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(AmericanasPO.LBL_ISBN));
	    Assert.assertTrue(autor.equals(driver.findElement(AmericanasPO.LBL_AUTOR).getText()));
	    Thread.sleep(1000);
	    driver.get(ConfigProjeto.URL_LIVRARIA_CULTURA);
	    Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LivrariaCulturaPO.CAMPO_PESQUISA));
	    driver.findElement(LivrariaCulturaPO.CAMPO_PESQUISA).sendKeys(isbn);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(LivrariaCulturaPO.ITEM));
	    driver.findElement(LivrariaCulturaPO.ITEM).click();
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(LivrariaCulturaPO.LBL_ISBN));
	    Assert.assertTrue(autor.toUpperCase().equals(driver.findElement(LivrariaCulturaPO.LBL_AUTOR).getText()));
	    Thread.sleep(1000);
	}
	@After
	public void depois() {
		driver.close();
		driver.quit();
	}
	
}
