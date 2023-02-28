package com.dev.enter.controller;

import com.dev.enter.mapper.AuditTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
      @Autowired
       AuditTableMapper auditTableMapper;
}
