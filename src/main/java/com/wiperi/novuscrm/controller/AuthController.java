package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.pojo.Emp;
import com.wiperi.novuscrm.pojo.Result;
import com.wiperi.novuscrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        return Result.success(empService.login(emp));
    }
}
