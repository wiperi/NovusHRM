package com.wiperi.novuscrm;

import com.wiperi.novuscrm.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovusCrmApplicationTests {

	@Autowired
	private DepartmentService departmentService;

	@Test
	void findDepartments() {
		departmentService.getAllDepartments().forEach(System.out::println);
	}
}
