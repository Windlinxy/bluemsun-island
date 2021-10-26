package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.MasterForSection;

public interface MasterForSectionMapper {

    int deleteByUserId(int userId);

    int insert(MasterForSection record);

    MasterForSection selectByUserId(int userId);


}
