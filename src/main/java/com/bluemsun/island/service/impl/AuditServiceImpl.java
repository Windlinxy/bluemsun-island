package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.AuditDao;
import com.bluemsun.island.dao.SectionDao;
import com.bluemsun.island.dao.UserForSectionDao;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 审核服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-25 19:55
 **/
public class AuditServiceImpl implements AuditService {
    @Autowired
    private AuditDao auditDao;
    @Autowired
    private SectionDao sectionDao;
    @Autowired
    private UserForSectionDao userForSectionDao;
    private int operationJudCode = 0;

    @Override
    public int addAudit(Audit audit){
        System.out.println(audit.getSectionName());
        if(sectionDao.queryOneByName(audit.getSectionName())==null){
            operationJudCode = auditDao.insertAudit(audit);
        }else {
            operationJudCode = 0;
        }

        return operationJudCode;
    }

    @Override
    public int deleteAudit(int id){
        operationJudCode = auditDao.deleteAudit(id);
        return operationJudCode;
    }

    @Override
    public int updateAudit(Audit audit){
        operationJudCode = auditDao.updateAudit(audit);
        return operationJudCode;
    }

    @Override
    public int agreeAudit(int auditId, int status){
        Audit audit ;
        audit =  auditDao.queryOneById(auditId);
        audit.setStatus(status);
        updateAudit(audit);
        operationJudCode = sectionDao.insertSection(new Section(audit.getSectionName(),audit.getDescription(),audit.getImageUrl()));
        if(operationJudCode == 1){
            int userId = audit.getUserId();
            operationJudCode = userForSectionDao.insert(userId,sectionDao.queryOneByName(audit.getSectionName()).getSectionId());
        }else {
            operationJudCode =0;
        }
        return operationJudCode;
    }

}
