package com.scrape.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenAndScrape {
	
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		
		Personal personal = new Personal();
		String username = personal.getUsername();
		String password = personal.getPassword();

		OpenAndScrape openAndScrape = new OpenAndScrape();
		openAndScrape.login(username, password);
		
		PrintPortfolio port = new PrintPortfolio();
        Thread.sleep(4000);
		
		List<Stock> stockPortfolio = new ArrayList<>();

        Thread.sleep(4000);
        for (int i = 1; i <= 10; i++) {
            Stock stock = openAndScrape.stockScrape(i);
            stockPortfolio.add(stock);
        }
        
        port.portfolioList(stockPortfolio);

        port.printPortfolio();
	
	}
	
	private void login(String username, String password) {
		String logScreen = "https://login.yahoo.com/config/login?.done=https%3A%2F%2Ffinance.yahoo.com%2Fportfolios&.intl=us&.lang=en-US&.src=finance";
		driver.get(logScreen);
		try {
			driver.findElement(By.id("login-username")).sendKeys(username);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(3000);
			pass(password);
		} catch (Exception e) {
			System.out.println("Login Failed: " + e.getMessage());
		}
	}
	
	private void pass(String password) {
		try {
			driver.findElement(By.id("login-passwd")).sendKeys(password);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(2000);
			toYahooPortfolio();
		} catch (Exception e) {
			System.out.println("Password Failed: " + e.getMessage());
		}
	}
	
	private void toYahooPortfolio() {
		try {
			driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/dialog/section/button")).click();
		} catch (Exception e) {
			System.out.println("To Portfolio Failed: " + e.getMessage());
		}
	}
	
	private Stock stockScrape(int i){
        String symbol = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[1]/span/a")).getText();
        String value = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[2]/span")).getText();
        String dayAmtChg = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/span")).getText();
        String dayPctChg = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[4]/span")).getText();
        String totalShrs = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/section[2]/div[2]/table/tbody/tr[" + i + "]/td[8]")).getText();

        return new Stock(symbol, value, dayAmtChg, dayPctChg, totalShrs);
    }

}
