package com.wiperi.novuscrm.service.impl;

import com.wiperi.novuscrm.mapper.EmpMapper;
import com.wiperi.novuscrm.pojo.ClazzCountOption;
import com.wiperi.novuscrm.pojo.JobOption;
import com.wiperi.novuscrm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {

        var maps = empMapper.empJobData();
        var jobList = maps.stream().map(map -> map.get("job")).toList();
        var countList  = maps.stream().map(map -> map.get("count")).toList();

        return new JobOption(jobList, countList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return List.of();
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return List.of();
    }

    @Override
    public ClazzCountOption getStudentCountData() {
        return null;
    }
}
