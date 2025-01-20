package com.wiperi.novuscrm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wiperi.novuscrm.mapper.EmpMapper;
import com.wiperi.novuscrm.pojo.Emp;
import com.wiperi.novuscrm.pojo.EmpQueryParam;
import com.wiperi.novuscrm.pojo.LoginInfo;
import com.wiperi.novuscrm.pojo.PageResult;
import com.wiperi.novuscrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> list = empMapper.list();
        Page<Emp> page = (Page<Emp>) list;

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void save(Emp emp) throws Exception {

    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public Emp getInfo(Integer id) {
        return null;
    }

    @Override
    public void update(Emp emp) {

    }

    @Override
    public List<Emp> list() {
        return List.of();
    }

    @Override
    public LoginInfo login(Emp emp) {
        return null;
    }
}
