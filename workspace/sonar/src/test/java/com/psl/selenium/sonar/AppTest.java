package com.psl.selenium.sonar;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void TestApp(){
		App a=new App();

		assertEquals(12,a.sum());
		assertEquals(6,a.sub());
	}
	
	@Test
	public void TestHappy(){
		App b=new App();
		b.happy();
	}
	
	

}
