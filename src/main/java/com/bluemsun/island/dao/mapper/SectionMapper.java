package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SectionMapper {

    int deleteById(Long id);

    int insert(Section record);

    Section selectById(int id);

    Section searchByName(String name);

    List<Section> selectBySectionName(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize, @Param("sectionName") String sectionName);

    int getCountBySectionName(@Param("sectionName")String sectionName);

    int updateSelective(Section record);

    List<Section> selectAll(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    int getAllCount();

    int getAllCount(@Param("col")String col,@Param("order")String order);

    Section selectOneById(int sectionId);
}
