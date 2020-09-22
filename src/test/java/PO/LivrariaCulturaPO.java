package PO;

import org.openqa.selenium.By;

public class LivrariaCulturaPO {
	
	public static final By CAMPO_PESQUISA = By.name("query");
	
	public static final By ITEM = By.cssSelector(".lazy");
	public static final By LBL_ISBN = By.xpath("//*[@id=\"ISBN\"]/span[2]");
	public static final By LBL_AUTOR = By.xpath("//*[@id=\"Autor\"]/span[2]");
}
