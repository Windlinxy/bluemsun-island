package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.SectionMapper;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 板块数据持久层接口实现类
 * @author: Windlinxy
 * @create: 2021-10-22 19:34
 **/
public class SectionDao extends SqlSessionDaoSupport {
    private int operationCode = 0;

    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }


    public int deleteById(int sectionId){
        try {
            int rowsAffected = getMapper(SectionMapper.class).deleteById(sectionId);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
        }

        return operationCode;
    }
    /**
     * 添加板块
     *
     * @param section 板块
     * @return int 影响行数
     * @date 19:49 2021/10/23
     **/

    public int insertSection(Section section) {
        try {
            int rowsAffected = getMapper(SectionMapper.class).insert(section);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
        }

        return operationCode;
    }

    public int updateSectionPostNumber(Section section) {
        try {
            int rowsAffected = getMapper(SectionMapper.class).updateSelective(section);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public int updateSectionPostNumber(int sectionId) {
        try {
            int rowsAffected = getMapper(SectionMapper.class).postNumberAdd(sectionId);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    /**
     * 获取所有板块
     *
     * @param startIndex 当前页
     * @param pageSize   页面数据数量
     * @return List<Section> 板块列表
     * @date 0:24 2021/10/24
     **/
    public List<Section> queryAllSections(int startIndex, int pageSize) {
        List<Section> sectionList;
        try {
            sectionList = getMapper(SectionMapper.class).selectAll(startIndex, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sectionList;
    }

    public List<Section> queryAllHotSections(int startIndex, int pageSize) {
        List<Section> sectionList;
        try {
            sectionList = getMapper(SectionMapper.class).selectAllHot(startIndex, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sectionList;
    }

    /**
     * 获得板块数量
     *
     * @return int 数量
     * @date 0:25 2021/10/24
     **/

    public int getAllSectionsCount() {
        int count;
        try {
            count = getMapper(SectionMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    public Section queryOneById(int id) {
        Section section;
        try {
            section = getMapper(SectionMapper.class).selectOneById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return section;
    }

    public Section queryOneByName(String name) {
        Section section;
        try {
            section = getMapper(SectionMapper.class).searchByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return section;
    }

    public int getSectionCountByName(String name) {
        int count;
        try {
            count = getMapper(SectionMapper.class).getCountBySectionName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<Section> querySectionsByName(int startIndex, int pageSize, String name) {
        List<Section> sectionList;
        try {
            sectionList = getMapper(SectionMapper.class).selectBySectionName(startIndex, pageSize, name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sectionList;
    }
}
