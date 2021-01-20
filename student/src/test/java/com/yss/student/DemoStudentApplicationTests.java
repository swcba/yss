package com.yss.student;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoStudentApplicationTests {

	@Test
	void contextLoads() {
		String s1="ABCD";
		String s2 = "1234";

		System.out.println(s1+s2);
	}

}
