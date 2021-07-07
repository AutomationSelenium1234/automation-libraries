package com.assertj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

public class AssertJDemo {
	
	@Test
	public void StringTest()
	{
		String temp = "Hello World";
		
		Assertions.assertThat(temp)
				  .isNotEmpty()
				  .isNotNull()
				  .isNotBlank()
				  .isEqualTo("Hello World")
				  .contains("Hello")
				  .doesNotContain("Hi")
				  .as("Expecting String to contain whitespaces").containsWhitespaces() //same description can be used for all types of Assertions
				  .containsIgnoringCase("world")
				  .matches("\\w.*"+" World")
				  .doesNotMatch("\\d.*")
				  .hasSize(11)
				  .hasSizeGreaterThan(5)
				  .hasSizeLessThan(20)
				  .hasSizeBetween(10, 20)
				  .endsWith("World");
	}
	
	@Test
	public void NumbersTest()
	{
		int a=10;
		
		Assertions.assertThat(a)
				  .isEqualTo(10)
				  .isCloseTo(15, Offset.offset(5))
				  .isInstanceOf(Integer.class)
				  .as("Value is not in the expected interval").isBetween(8, 15)
				  .isCloseTo(12, Percentage.withPercentage(30))
				  .isNotCloseTo(15, Percentage.withPercentage(30))
				  .isPositive()
				  .isEven()
				  .isGreaterThanOrEqualTo(5)
				  .isLessThanOrEqualTo(20);
	}
	
	@Test
	public void ListTest()
	{
		
		List<String> list= Arrays.asList("Testing","Mini","Bytes");
		List<String> list2= Arrays.asList("Testing","Mini");
		List<String> list3= Arrays.asList("Automation","Selenium");
		
		Assertions.assertThat(list)
				  .hasSize(3)
				  .hasAtLeastOneElementOfType(String.class)
				  .isNotEmpty()
				  .contains("Mini")
				  .doesNotContain("Automation")
				  .startsWith("Testing")
				  .containsExactlyInAnyOrder("Mini","Testing","Bytes")
				  .containsExactly("Testing","Mini","Bytes")
				  .withFailMessage(()->"String is not having size less than 3").allMatch(s->s.length()<3) // refer 10th video
				  .containsAll(list2)
				  .doesNotContainAnyElementsOf(list3);
	}
	
	@Test
	public void MapTest()
	{
		Map<String, String> map = new HashMap<>();
		
		map.put("Sampath", "Testing");
		map.put("Company", "Infor");
		map.put("Role", "QA");
		
		Assertions.assertThat(map)
				  .containsEntry("Sampath", "Testing")
				  .hasSize(3)
				  .isNotEmpty()
				  .doesNotContainEntry("sports", "Cricket")
				  .doesNotContainKey("VASAVI")
				  .containsKey("Company")
				  .containsValue("Testing");
	}
	
	@Test
	public void CustomClassTest()
	{
		Employees emp = new Employees(25,"sampath",100);
		Employees emp2 = new Employees(25,"sampath",100);
		
		Assertions.assertThat(emp)
				  .isEqualToComparingFieldByField(emp2)
				  .isNotNull()
				  .isInstanceOf(Employees.class)
				  .hasFieldOrProperty("age")
				  .hasFieldOrPropertyWithValue("name", "sampath")
				  .extracting(e->e.age).isNotEqualTo(24);
	}

}
