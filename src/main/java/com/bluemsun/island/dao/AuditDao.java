package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.AuditMapper;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 审核数据持久层接口实现类
 * @author: Windlinxy
 * @create: 2021-10-25 09:25
 **/
public class AuditDao extends SqlSessionDaoSupport {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    public int insertAudit(Audit audit){
        try {
            int rowsAffected = getMapper(AuditMapper.class).insert(audit);
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

    public int updateAudit(Audit audit){
        try {
            int rowsAffected = getMapper(AuditMapper.class).updateByIdSelective(audit);
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

    public int deleteAudit(int id){
        try {
            int rowsAffected = getMapper(AuditMapper.class).deleteById(id);
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

    public int getAllAuditsCount(){
        int count;
        try {
            count = getMapper(AuditMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<Audit> queryAllAudits(int startIndex, int pageSize) {
        List<Audit> auditList;
        try {
            auditList = getMapper(AuditMapper.class).selectAll(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return auditList;
    }

    public Audit queryOneById(int auditId){
        Audit audit;
        try {
            audit = getMapper(AuditMapper.class).selectById(auditId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return audit;
    }
}
