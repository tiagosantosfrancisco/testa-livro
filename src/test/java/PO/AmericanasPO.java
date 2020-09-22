package PO;

import org.openqa.selenium.By;

public class AmericanasPO {
	public static final By OK_LGPD = By.id("lgpd-accept");
	public static final By CAMPO_PESQUISA = By.id("h_search-input");
	public static final By ITEM = By.cssSelector(".row > .product-grid-item:nth-child(1)");
	public static final By LBL_ISBN = By.xpath("//*[@id=\"info-section\"]//*/tr[15]/td[2]");
	public static final By LBL_AUTOR = By.xpath("//*[@id=\"info-section\"]//*/tr[16]/td[2]");
}
