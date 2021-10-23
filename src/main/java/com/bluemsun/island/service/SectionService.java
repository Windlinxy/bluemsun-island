package com.bluemsun.island.service;

import com.bluemsun.island.entity.Section;

/**
 * @program: BulemsunIsland
 * @description: 板块服务接口
 * @author: Windlinxy
 * @create: 2021-10-23 19:51
 **/
public interface SectionService {
    /**
     * 添加板块
     *
     * @date 20:02 2021/10/23
     * @param section 板块
     * @return int 操作判断
     **/
    int addSection(Section section);
}
