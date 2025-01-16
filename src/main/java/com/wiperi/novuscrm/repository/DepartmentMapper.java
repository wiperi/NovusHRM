package com.wiperi.novuscrm.repository;

import com.wiperi.novuscrm.model.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM novus.departments")
    List<Department> findAll();

    @Insert("INSERT INTO novus.departments (name, create_time, update_time) VALUES (#{name}, #{createTime},#{updateTime})")
    Integer insert(Department department);

    @Delete("DELETE FROM novus.departments WHERE id = #{id}")
    Integer delete(Long id);

    @Update("UPDATE novus.departments SET name=#{name}, update_time=#{updateTime} WHERE id=#{id}")
    Integer update(Department department);
}
