package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.SectionDao;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 板块服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-23 19:52
 **/
public class SectionServiceImpl implements SectionService{
    private int operationJudCode;
    @Autowired
    private SectionDao sectionDao;

    @Override
    public int addSection(Section section){
        operationJudCode = sectionDao.insertSection(section);
        return operationJudCode;
    }
}
