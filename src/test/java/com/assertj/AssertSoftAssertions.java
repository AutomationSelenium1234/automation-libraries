package com.assertj;

import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AssertSoftAssertions {
	
	@Test
	public void AssertSoftlyTest() 
	{
		SoftAssertions softly = new SoftAssertions();
		
		softly.assertThat("Hello World")
			  .isNotEmpty()
			  .hasSize(5)
			  .contains("Hello");
		
		System.out.println("Soft Assertions worked");
		softly.assertAll();
			  
	}
	
	@Test
	public void AssertBDDStyleTest()
	{
		BDDAssertions.then("Hello World")
					 .hasSize(11)
					 .containsIgnoringCase("world");
		
		
		
				}

	
}
