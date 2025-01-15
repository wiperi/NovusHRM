package com.wiperi.novuscrm.service;

import com.wiperi.novuscrm.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();

    Integer delete(Long id);

    Integer create(Department department);

    Integer update(Long id, Department department);
}
