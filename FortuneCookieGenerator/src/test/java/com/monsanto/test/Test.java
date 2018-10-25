package com.monsanto.test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.monsanto.interview.FortuneCookieGenerator.FortuneCookie;
import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieBuilder;
import com.monsanto.interview.FortuneCookieGenerator.FortuneCookieController;
import com.monsanto.interview.FortuneCookieGenerator.QuoteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {FortuneCookieController.class, QuoteRepository.class, FortuneCookieBuilder.class})
public class Test {
	
	@Autowired
	private FortuneCookieController controller;
	
	@org.junit.Test
	public void testSameCookies() {
		FortuneCookie cookie1 = controller.generateFortuneCookie("Barney", "SuperStore");
		FortuneCookie cookie2 = controller.generateFortuneCookie("Sarah", "MegaMarket");
		
		assertNotEquals(cookie1.getMessage(), cookie2.getMessage());
		
		FortuneCookie cookie3 = controller.generateFortuneCookie("Sarah", "MegaMarket");
		
		assertEquals(cookie2.getMessage(), cookie3.getMessage());
		
		FortuneCookie cookie4 = controller.generateFortuneCookie("Barney", "SuperStore");
		
		assertNotEquals(cookie3.getMessage(), cookie4.getMessage());
		
		FortuneCookie cookie5 = controller.generateFortuneCookie("Barney", "SuperStore");
		
		assertEquals(cookie4.getMessage(), cookie5.getMessage());
	}
}
