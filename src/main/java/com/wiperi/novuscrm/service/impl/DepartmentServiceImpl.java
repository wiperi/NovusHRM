package com.wiperi.novuscrm.service.impl;

import com.wiperi.novuscrm.exception.HttpException;
import com.wiperi.novuscrm.repository.DepartmentMapper;
import com.wiperi.novuscrm.model.Department;
import com.wiperi.novuscrm.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public void delete(Long id) throws HttpException {
        Integer deleteCount = departmentMapper.delete(id);
        if (deleteCount != 1) {
            throw new HttpException("Department id not exist", 400);
        }
    }

    @Override
    public void create(Department department) throws Exception {
        if (department.getName() == null || department.getName().trim().isEmpty()) {
            throw new HttpException("Department name cannot be empty", 400);
        }

        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        
        try {
            Integer result = departmentMapper.insert(department);
            if (result != 1) {
                throw new Exception("Failed to create department");
            }
        } catch (DuplicateKeyException e) {
            throw new HttpException("Department name already exists", 400);
        }
    }

    @Override
    public void update(Department department) throws HttpException {
        if (department.getName() == null || department.getName().trim().isEmpty()) {
            throw new HttpException("Department name cannot be empty", 400);
        }

        department.setUpdateTime(LocalDateTime.now());
        
        Integer result = departmentMapper.update(department);
        if (result != 1) {
            throw new HttpException("Department not found with id: " + department.getId(), 404);
        }
    }
}
