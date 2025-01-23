package com.wiperi.novuscrm.mapper;

import com.wiperi.novuscrm.pojo.Emp;
import com.wiperi.novuscrm.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    // 如果使用page helper，结尾不能加';'
    // @Select("SELECT e.*, d.name as dept_name FROM emp e inner join dept d ON e.dept_id = d.id")
    List<Emp> list(EmpQueryParam empQueryParam);

    void insert(Emp emp) throws Exception;

    Emp getById(Integer id);

    Integer delete(List<Integer> ids);

    Integer update(Emp emp);

    @MapKey("job")
    List<Map<String, Object>> empJobData();

    Emp getByProvided(Emp emp);
}
