package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.model.Department;
import com.wiperi.novuscrm.model.Result;
import com.wiperi.novuscrm.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result getAll() {
        return Result.success(departmentService.getAll());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        departmentService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result create(@RequestBody Department department) throws Exception {
        departmentService.create(department);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Department department) {
        log.info("update department: {}", department);
        departmentService.update(department);
        return Result.success();
    }
}
