package com.dev.enter.service;

import com.dev.enter.entity.AuditTableEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.enter.mapper.AuditTableMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface AuditTableService extends IService<AuditTableEntity> {

   Integer insertAuditTable(AuditTableEntity auditTableEntity);
   void setAuditTableMapper(AuditTableMapper auditTableMapper);
   AuditTableEntity findAuditTableByid(Integer  id);
   int deleteAuditTableByid(Integer id);
   int updateAuditTable(AuditTableEntity auditTableEntity);
}
