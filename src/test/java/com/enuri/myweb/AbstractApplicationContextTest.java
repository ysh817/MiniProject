package com.enuri.myweb;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public abstract class AbstractApplicationContextTest {
	
	@Autowired
	protected ApplicationContext ctx;
	
	@Test
	public void testExcute() {
		test();
	}
	
	protected abstract void test();
	@After
	public void after(){
		System.out.println("------------Test end-------------------");
	}

}
