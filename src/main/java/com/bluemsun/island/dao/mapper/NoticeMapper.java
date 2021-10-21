package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Notice;

/**
 * 消息映射
 *
 * @program: BulemsunIsland
 * @description: 消息映射
 * @author: Windlinxy
 * @create: 2021-10-21 17:23
 **/
public interface NoticeMapper {

    int deleteById(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectById(Long id);

    int updateByIdSelective(Notice record);

    int updateById(Notice record);

}
