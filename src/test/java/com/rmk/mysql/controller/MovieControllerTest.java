package com.rmk.mysql.controller;

import com.rmk.mysql.MysqlApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MysqlApplication.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

	private MockMvc mockMvc;

	@Test
	public void test() {
		Assert.assertEquals("Test","Test");
	}
}
