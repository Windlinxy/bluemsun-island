package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.SectionDao;
import com.bluemsun.island.dao.mapper.SectionMapper;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 板块数据持久层接口实现类
 * @author: Windlinxy
 * @create: 2021-10-22 19:34
 **/
public class SectionDaoImpl extends SqlSessionDaoSupport implements SectionDao {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    @Override
    public int insertSection(Section section){
        try {
            int rowsAffected = getMapper(SectionMapper.class).insert(section);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    @Override
    public List<Section> queryAllSections(int startIndex, int pageSize){
        List<Section> sectionList;
        try {
            sectionList = getMapper(SectionMapper.class).selectAll(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sectionList;
    }

    @Override
    public int getAllSectionsCount(){
        int count;
        try {
            count = getMapper(SectionMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
