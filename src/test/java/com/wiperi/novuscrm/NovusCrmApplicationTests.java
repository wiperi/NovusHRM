package com.wiperi.novuscrm;

import com.wiperi.novuscrm.mappers.DepartmentMapper;
import com.wiperi.novuscrm.mappers.UserMapper;
import com.wiperi.novuscrm.models.User;
import com.wiperi.novuscrm.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NovusCrmApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Test
	void testDepartmentMapper() {
		List<com.wiperi.novuscrm.models.Department> res = departmentMapper.findAll();
		Assertions.assertNotEquals(0, res.size());
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testHello() {
		System.out.println("Hello World!");
		Assertions.assertEquals("Hello World!", "Hello World!");
	}

	@Test
	void findUsers() {
		List<User> res = userMapper.findAllUsers();
		// assert res not empty
		Assertions.assertNotEquals(0, res.size());
		res.forEach(System.out::println);
	}

	@Test
	@Disabled("Skipping this test for now")
	void deleteUser() {
		Integer res = userMapper.deleteUser(1);
		Assertions.assertNotNull(res);
		Assertions.assertEquals(1, res);
	}

	@Test
	void addUser() {
		// 修改为双引号表示字符串，并使用返回值进行断言
		userMapper.deleteUser(1);
		User newUser = new User(1, "daqiao", "123456", "大乔", 22);
		Integer res = userMapper.addUser(newUser);
		Assertions.assertNotNull(res);
		Assertions.assertEquals(1, res); // 假设返回值为插入成功的记录数
	}

	@Test
	void updateUser() {
		Integer res = userMapper.updateUser(new User(1, "daqiao", "123456", "大乔", 36));
		Assertions.assertNotNull(res);
		Assertions.assertEquals(1, res);
	}

	@Test
	void findAllUsersXML() {
		List<User> res = userMapper.findAllUsersXML();
		Assertions.assertNotEquals(0, res.size());
		res.forEach(System.out::println);
	}

	@Autowired
	private DepartmentService departmentService;

	@Test
	void findDepartments() {
		departmentService.getAllDepartments().forEach(System.out::println);
	}
}
