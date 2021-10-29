package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionMapper {

    int deleteById(int id);

    int insert(Section record);

    Section selectById(int id);

    Section searchByName(String name);

    List<Section> selectBySectionName(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("sectionName") String sectionName);
    List<Section> selectByUser(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("sectionName") String sectionName);

    int getCountBySectionName(@Param("sectionName") String sectionName);

    int updateSelective(Section record);

    int postNumberAdd(int sectionId);

    List<Section> selectAll(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    int getAllCount();

    List<Section> selectAllHot(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);


    int getAllCount(@Param("col") String col, @Param("order") String order);

    Section selectOneById(int sectionId);
}
