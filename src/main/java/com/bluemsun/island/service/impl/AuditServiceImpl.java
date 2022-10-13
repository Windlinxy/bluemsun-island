package com.bluemsun.island.service.impl;

import com.bluemsun.island.dto.MasterForSection;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.mapper.AuditMapper;
import com.bluemsun.island.mapper.MasterForSectionMapper;
import com.bluemsun.island.mapper.SectionMapper;
import com.bluemsun.island.service.AuditService;

import javax.annotation.Resource;

/**
 * @program: BulemsunIsland
 * @description: 审核服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-25 19:55
 **/

public class AuditServiceImpl implements AuditService {
    @Resource
    private MasterForSectionMapper masterForSectionMapper;
    @Resource
    private AuditMapper auditMapper;
    @Resource
    private SectionMapper sectionMapper;

    private int operationJudCode = 0;

    @Override
    public int addAudit(Audit audit) {
        System.out.println(audit.getSectionName());
        if (sectionMapper.searchByName(audit.getSectionName()) == null) {
            operationJudCode = auditMapper.insert(audit);
        } else {
            operationJudCode = 0;
        }

        return operationJudCode;
    }

    @Override
    public int deleteAudit(int id) {
        operationJudCode = auditMapper.deleteById(id);
        return operationJudCode;
    }

    @Override
    public int updateAudit(Audit audit) {
        operationJudCode = auditMapper.updateByIdSelective(audit);
        return operationJudCode;
    }

    @Override
    public int agreeAudit(int auditId, int status) {
        Audit audit;
        audit = auditMapper.selectById(auditId);
        audit.setStatus(status);
        updateAudit(audit);
        operationJudCode = sectionMapper.insert(new Section(audit.getSectionName(), audit.getDescription(), audit.getImageUrl()));
        if (operationJudCode == 1) {
            int userId = audit.getUserId();
            operationJudCode = masterForSectionMapper.insert(new MasterForSection(userId, audit.getSectionName()));
        } else {
            operationJudCode = 0;
        }
        return operationJudCode;
    }

}
