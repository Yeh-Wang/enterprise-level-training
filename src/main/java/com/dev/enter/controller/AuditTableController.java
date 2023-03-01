package com.dev.enter.controller;

import com.dev.enter.entity.AuditTableEntity;
import com.dev.enter.service.AuditTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@RequestMapping("/audit-table-entity")
public class AuditTableController {
      private AuditTableService auditTableService;
      @Autowired
    public void setAuditTableService(AuditTableService auditTableService){
          this.auditTableService=auditTableService;
      }

      @PostMapping("/sadjhashd")
    public  int ashdkjasd (@RequestBody AuditTableEntity auditTableEntity){
         return auditTableService.insertAuditTable(auditTableEntity);

      }
}
