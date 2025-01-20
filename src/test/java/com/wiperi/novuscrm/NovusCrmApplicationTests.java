package com.wiperi.novuscrm;

import com.wiperi.novuscrm.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovusCrmApplicationTests {

	@Autowired
	private DeptService deptService;

	@Test
	void findDepartments() {
		deptService.findAll().forEach(System.out::println);
	}
}
