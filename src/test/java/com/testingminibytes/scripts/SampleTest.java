package com.testingminibytes.scripts;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;
import com.tmb.utils.ReadPropertyFile;

public class SampleTest extends BaseTest{
	
	
	@Test
	public void test3() throws Exception
	{
		
		DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		
		Assertions.assertThat(title)
				  .as(" Object is not Null").isNotNull()
				  .containsIgnoringCase("google search")
				  .hasSizeBetween(15, 200);
		
				  
		Assert.assertTrue(Objects.nonNull(title));
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search")); // \\w is same as [a-zA-Z0-9]
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
		Assert.assertEquals(elements.size(), 10);
		
		boolean isElementPresent = false;
		for(WebElement element: elements)
		{
			if(element.getText().equalsIgnoreCase("Testing Mini Bytes - Youtube"))
			{
				isElementPresent = true;
				break;
				
			}
		}
		Assert.assertTrue(isElementPresent, "Testing Mini Bytes not found");
		
		
	}

}
