package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.exception.BusinessException;
import com.wiperi.novuscrm.pojo.Emp;
import com.wiperi.novuscrm.pojo.EmpQueryParam;
import com.wiperi.novuscrm.pojo.PageResult;
import com.wiperi.novuscrm.pojo.Result;
import com.wiperi.novuscrm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        return Result.success(empService.page(empQueryParam));
    }

    @PostMapping
    public Result insert(@RequestBody Emp emp) throws Exception {
        empService.save(emp);
        return Result.success("Success");
    }

}
