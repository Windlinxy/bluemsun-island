package com.bluemsun.island.dao;

import com.bluemsun.island.entity.Section;

/**
 * @program: BulemsunIsland
 * @description: 板块持久层接口
 * @author: Windlinxy
 * @create: 2021-10-22 19:34
 **/
public interface SectionDao {
    /**
     * 添加板块
     *
     * @date 19:49 2021/10/23
     * @param section 板块
     * @return int 影响行数
     **/
    int insertSection(Section section);
}
