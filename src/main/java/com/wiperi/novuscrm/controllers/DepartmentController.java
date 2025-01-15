package com.wiperi.novuscrm.controllers;

import com.wiperi.novuscrm.mappers.DepartmentMapper;
import com.wiperi.novuscrm.models.Department;
import com.wiperi.novuscrm.models.Result;
import com.wiperi.novuscrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public Result getDepartments() {
        return Result.success(departmentService.getAllDepartments());
    }
}
