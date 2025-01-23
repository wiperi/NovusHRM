package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.pojo.Result;
import com.wiperi.novuscrm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData() {
        var empJobData = reportService.getEmpJobData();
        return Result.success(empJobData);
    }
}
