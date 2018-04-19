package com.luv2code.springdemo.controller;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenAndScrape {
	
	//private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();	
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		
		System.out.println("Hello moto");
		driver.get("http://google.com");
	
	}
	
	
//	private void testDriver() {
//		try {
//			driver.get("https://www.google.com/");
//		} 
//		catch(Exception e) {
//			System.out.println("Not working: " + e.getMessage());
//		}
//	}

}
