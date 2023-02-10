package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleTest {

	WebDriver driver;

	@BeforeClass
	public void Initalization() {
		driver = new ChromeDriver();

		driver.get("https://amazon.com");

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void SelectDropDown() {

		WebElement seldropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(seldropdown);

		sel.selectByIndex(3);

		sel.selectByValue("search-alias=deals-intl-ship");

		sel.selectByVisibleText("Women's Fashion"); // HIgh priority

		

	}

	@Test(priority = 2)
	public void AdvanceDropDown() {

		WebElement seldropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(seldropdown);

		List<WebElement> li = sel.getOptions();

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) // 0 0<28
		{
			li.get(i).click();
			System.out.println(li.get(i).getText()); // [All- women].get(0).getText()
		}

		for (int i = li.size() - 1; i >= 0; i--) {
			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

		

	}
	
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}

}
