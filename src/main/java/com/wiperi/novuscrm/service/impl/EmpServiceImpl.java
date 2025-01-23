package com.wiperi.novuscrm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wiperi.novuscrm.exception.BusinessException;
import com.wiperi.novuscrm.mapper.EmpExprMapper;
import com.wiperi.novuscrm.mapper.EmpMapper;
import com.wiperi.novuscrm.pojo.*;
import com.wiperi.novuscrm.service.EmpService;
import com.wiperi.novuscrm.util.JWTUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper EmpExprMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        Integer count = empMapper.delete(ids);

        if (count != ids.size()) {
            throw new BusinessException("Emp id not exist");
        }

        count = EmpExprMapper.delete(ids);
        if (count != ids.size()) {
            throw new BusinessException("Emp expr id not exist");
        }
    }

    @Override
    public Emp getInfo(Integer id) {
        Emp res = empMapper.getById(id);
        if (res == null) {
            throw new BusinessException("Emp not exist");
        }
        return res;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) throws Exception {
        Integer affected;
        // update emp
        affected = empMapper.update(emp);
        if (affected != 1) {
            throw new BusinessException("Emp not exist");
        }

        // delete emp exp
        empExprMapper.delete(List.of(emp.getId()));

        // insert new emp exp
        if (emp.getExprList().isEmpty()) return;

        emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
        empExprMapper.insertBatch(emp.getExprList());
    }

    @Override
    public List<Emp> list() {
        return List.of();
    }

    @Override
    public LoginInfo login(Emp emp) {
        // query if emp exist

        // query username
        Emp temp = new Emp();
        temp.setUsername(emp.getUsername());

        Emp empFound = empMapper.getByProvided(temp);
        if (empFound == null) {
            throw new BusinessException("Username not exist");
        }

        // query password
        temp.setPassword(emp.getPassword());

        empFound = empMapper.getByProvided(emp);
        if (empFound == null) {
            throw new BusinessException("Password not correct");
        }

        // sign new token
        String token = JWTUtils.createToken(Map.of("empId", empFound.getId()));
        System.out.println(token);

        return new LoginInfo(
                empFound.getId(),
                empFound.getUsername(),
                empFound.getName(), token
        );
    }
}
