package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.MasterForSectionMapper;
import com.bluemsun.island.dto.MasterForSection;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

/**
 * @program: BulemsunIsland
 * @description: 用户与板块关系
 * @author: Windlinxy
 * @create: 2021-10-26 18:15
 **/
public class UserForSectionDao extends SqlSessionDaoSupport {
    private int operationCode = 0;

    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    public int insert(int userId, String sectionName) {
        try {
            int rowsAffected = getMapper(MasterForSectionMapper.class).insert(new MasterForSection(userId, sectionName));
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

}
