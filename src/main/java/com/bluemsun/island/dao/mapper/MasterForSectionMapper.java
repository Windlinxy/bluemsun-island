package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.MasterForSection;

public interface MasterForSectionMapper {

    int deleteByUserId(int masterId);

    int selectByUserIdForSectionName(MasterForSection record);

    int insert(MasterForSection record);

    MasterForSection selectByUserId(int masterId);


}
