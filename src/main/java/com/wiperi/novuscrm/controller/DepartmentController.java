package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.model.Department;
import com.wiperi.novuscrm.model.Result;
import com.wiperi.novuscrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public Result getAll() {
        return Result.success(departmentService.getAll());
    }

    @DeleteMapping("/departments/{id}")
    public Result delete(@PathVariable Long id) {
        departmentService.delete(id);
        return Result.success();
    }

    @PostMapping("/departments")
    public Result create(@RequestBody Department department) {
        departmentService.create(department);
        return Result.success();
    }

    @PutMapping("/departments/{id}")
    public Result update(@PathVariable Long id, @RequestBody Department department) {
        return Result.success(departmentService.update(id, department));
    }
}
