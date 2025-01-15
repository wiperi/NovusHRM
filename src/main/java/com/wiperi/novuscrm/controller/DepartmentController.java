package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.model.Result;
import com.wiperi.novuscrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public Result getDepartments() {
        return Result.success(departmentService.getAllDepartments());
    }
}
