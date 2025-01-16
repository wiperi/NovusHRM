package com.wiperi.novuscrm.service;

import com.wiperi.novuscrm.model.Department;
import com.wiperi.novuscrm.exception.HttpException;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    void delete(Long id) throws HttpException;

    void create(Department department) throws Exception;

    void update(Department department) throws HttpException;
}
