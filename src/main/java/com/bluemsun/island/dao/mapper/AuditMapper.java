package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Audit;

/**
 * @Entity generator.domain.TbAudit
 */
public interface AuditMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Audit record);

    int insertSelective(Audit record);

    Audit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Audit record);

    int updateByPrimaryKey(Audit record);

}
