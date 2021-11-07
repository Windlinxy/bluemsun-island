package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.MasterForSection;
import com.bluemsun.island.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterForSectionMapper {

    int deleteByUserId(int masterId);

    int selectByUserIdForSectionName(MasterForSection record);

    int insert(MasterForSection record);

    List<Section> selectByUserId(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize, @Param("id")int id);

    int getCountbyUserId(int id);
}
