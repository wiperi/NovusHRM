package com.wiperi.novuscrm.service;

import com.wiperi.novuscrm.mappers.DepartmentMapper;
import com.wiperi.novuscrm.models.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

}
