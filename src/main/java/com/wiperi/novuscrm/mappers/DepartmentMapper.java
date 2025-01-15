package com.wiperi.novuscrm.mappers;

import com.wiperi.novuscrm.models.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM novus.departments")
    List<Department> findAll();
}
