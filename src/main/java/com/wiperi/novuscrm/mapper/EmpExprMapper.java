package com.wiperi.novuscrm.mapper;

import com.wiperi.novuscrm.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList) throws Exception;

    Integer delete(List<Integer> empIds);

}
