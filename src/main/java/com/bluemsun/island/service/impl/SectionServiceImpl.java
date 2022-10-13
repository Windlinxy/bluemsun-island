package com.bluemsun.island.service.impl;

import com.bluemsun.island.entity.Section;
import com.bluemsun.island.mapper.SectionMapper;
import com.bluemsun.island.service.SectionService;

import javax.annotation.Resource;

/**
 * @program: BulemsunIsland
 * @description: 板块服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-23 19:52
 **/

public class SectionServiceImpl implements SectionService {
    @Resource
    private SectionMapper sectionMapper;

    @Override
    public int addSection(Section section) {
        return sectionMapper.insert(section);
    }

    @Override
    public Section getSection(int id) {
        Section section = sectionMapper.selectOneById(id);
        if (section == null) {
            return null;
        } else {
            return section;
        }
    }


}
