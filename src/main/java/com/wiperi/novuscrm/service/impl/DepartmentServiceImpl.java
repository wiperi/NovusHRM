package com.wiperi.novuscrm.service.impl;

import com.wiperi.novuscrm.repository.DepartmentMapper;
import com.wiperi.novuscrm.model.Department;
import com.wiperi.novuscrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> getAll() {
        return departmentMapper.findAll();
    }

    @Override
    public Integer delete(Long id) {
        return departmentMapper.delete(id);
    }

    @Override
    public Integer create(Department department) {
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        return departmentMapper.insert(department);
    }

    @Override
    public Integer update(Long id, Department department) {
        return 1;
    }

}
