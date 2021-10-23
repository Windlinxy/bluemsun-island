package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Section;

/**
 * @Entity generator.domain.TbSection
 */
public interface SectionMapper {

    int deleteById(Long id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectById(Long id);

    int updateSelective(Section record);


}
