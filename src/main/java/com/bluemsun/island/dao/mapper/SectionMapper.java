package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity generator.domain.TbSection
 */
public interface SectionMapper {

    int deleteById(Long id);

    int insert(Section record);

    Section selectById(Long id);

    int updateSelective(Section record);

    List<Section> selectAll(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    int getAllCount();
}
