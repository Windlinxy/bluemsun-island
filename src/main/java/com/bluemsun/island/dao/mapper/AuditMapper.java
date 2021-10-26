package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Audit;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AuditMapper {

    int deleteById(int id);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectById(int id);

    int updateByIdSelective(Audit record);


    List<Audit> selectAll(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize);//int,int

    int getAllCount();
}
