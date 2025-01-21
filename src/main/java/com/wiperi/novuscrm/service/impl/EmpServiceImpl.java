package com.wiperi.novuscrm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wiperi.novuscrm.exception.BusinessException;
import com.wiperi.novuscrm.mapper.EmpExprMapper;
import com.wiperi.novuscrm.mapper.EmpMapper;
import com.wiperi.novuscrm.pojo.*;
import com.wiperi.novuscrm.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper EmpExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> list = empMapper.list(empQueryParam);
        Page<Emp> page = (Page<Emp>) list;

        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) throws Exception {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);

        // emp expr not empty
        var exprList = emp.getExprList();
        if (exprList.isEmpty()) return;

        // insert emp expr
        exprList.forEach(expr -> expr.setEmpId(emp.getId()));
        EmpExprMapper.insertBatch(emp.getExprList());
    }

    @Override
    public void delete(List<Integer> ids) {

    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getInfo(id);
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
