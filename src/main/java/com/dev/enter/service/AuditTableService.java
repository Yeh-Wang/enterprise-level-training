package com.dev.enter.service;

import com.dev.enter.entity.AuditTableEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface AuditTableService extends IService<AuditTableEntity> {

   Integer    insertAuditTable(@RequestBody  AuditTableEntity auditTableEntity);
}
