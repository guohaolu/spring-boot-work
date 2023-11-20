package com.stealandfire.dao;

import com.stealandfire.pojo.entity.QualifySpecialListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IQualifySpecialListDao {
    Integer insertOrUpdate(@Param("entityList") List<QualifySpecialListEntity> entityList);

    Integer save(QualifySpecialListEntity entity);
}
