package com.wiperi.novuscrm.service.impl;

import com.wiperi.novuscrm.mappers.DepartmentMapper;
import com.wiperi.novuscrm.models.Department;
import com.wiperi.novuscrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.findAll();
    }
}
