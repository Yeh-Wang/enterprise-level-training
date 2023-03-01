package com.dev.enter.service.impl;

import com.dev.enter.entity.AuditTableEntity;
import com.dev.enter.mapper.AuditTableMapper;
import com.dev.enter.service.AuditTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class AuditTableServiceImpl extends ServiceImpl<AuditTableMapper, AuditTableEntity> implements AuditTableService {
    private AuditTableMapper auditTableMapper;

    @Autowired
    public void setAuditTableMapper(AuditTableMapper auditTableMapper) {
        this.auditTableMapper = auditTableMapper;
    }

    @Override
    public Integer insertAuditTable(AuditTableEntity auditTableEntity) {
        return auditTableMapper.insert(auditTableEntity);

    }
}