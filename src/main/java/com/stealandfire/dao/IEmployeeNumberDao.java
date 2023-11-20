package com.stealandfire.dao;

import com.stealandfire.pojo.entity.EmployeeNumberEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IEmployeeNumberDao {
    Integer save(EmployeeNumberEntity entity);

    List<Long> listPersonIdByEmployeeLatestNumber(List<String> employeeNumberList);
}
