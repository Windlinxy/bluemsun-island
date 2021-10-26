package com.bluemsun.island.service;

import com.bluemsun.island.entity.Audit;

/**
 * @program: BulemsunIsland
 * @description: 审核
 * @author: Windlinxy
 * @create: 2021-10-25 19:55
 **/
public interface AuditService {
    int addAudit(Audit audit);

    int deleteAudit(int id);

    int updateAudit(Audit audit);

    int agreeAudit(int auditId,int status);

}
