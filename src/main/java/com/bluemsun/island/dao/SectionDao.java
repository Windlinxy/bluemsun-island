package com.bluemsun.island.dao;

import com.bluemsun.island.entity.Section;

import java.util.List;

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

    /**
     * 获取所有板块
     *
     * @date 0:24 2021/10/24
     * @param startIndex    当前页
     * @param pageSize      页面数据数量
     * @return List<Section> 板块列表
     **/
    List<Section> queryAllSections(int startIndex, int pageSize);

    /**
     * 获得板块数量
     *
     * @date 0:25 2021/10/24
     * @return int 数量
     **/
    int getAllSectionsCount();
}
