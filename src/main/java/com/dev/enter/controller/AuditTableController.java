package com.dev.enter.controller;

import com.dev.enter.entity.AuditTableEntity;
import com.dev.enter.entity.MailInfo;
import com.dev.enter.entity.Result;
import com.dev.enter.entity.StuToAuditorEntity;
import com.dev.enter.mapper.StuToAuditorMapper;
import com.dev.enter.service.AuditTableService;
import com.dev.enter.service.impl.SendMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@CrossOrigin
@RequestMapping("/audit-table-entity")
public class AuditTableController {
    private AuditTableService auditTableService;

    private SendMessageServiceImpl sendMessageService;

    @Resource
    private StuToAuditorMapper stuToAuditorMapper;

    @Autowired
    public void setSendMessageService(SendMessageServiceImpl sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setAuditTableService(AuditTableService auditTableService) {
        this.auditTableService = auditTableService;
    }

    @ResponseBody
    @GetMapping("/find-audit-table-by-id/{id}")
    Result<AuditTableEntity> findAuditTableByid(@PathVariable int id) {
        Result<AuditTableEntity> result = new Result<>();
        if (auditTableService.findAuditTableByid((id)) != null) {
            result.setData(auditTableService.findAuditTableByid(id));
            result.setCode(200);
            result.setStatus(true);
            result.setMessage("查找成功！");
        } else {
            result.setData(null);
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("未查找到此信息！");
        }
        return result;
    }

    @GetMapping("/delete-Audit-table-By-Id/{id}")
    Result<Integer> deleteAuditTableByid(@PathVariable int id) {
        Result<Integer> result = new Result<>();
        if (auditTableService.deleteAuditTableByid(id) == 1) {
            result.setData(auditTableService.deleteAuditTableByid(id));
            result.setMessage("删除成功");
            result.setStatus(true);
            result.setCode(200);
        } else {
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("删除失败");
            result.setData(0);
        }
        return result;
    }

    @ResponseBody
    @PostMapping("/update-audit-table")
    Result<String> updateQuestion(@RequestBody AuditTableEntity auditTableEntity) {
        Result<String> result = new Result<>();
        if (auditTableService.updateAuditTable(auditTableEntity) == 1) {
            result.setData("Update successfully");
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        } else {
            result.setData("Update failed");
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    @PostMapping("/insertAuditTable")
    Result<Integer> insertAuditTable(@RequestBody AuditTableEntity auditTableEntity) {
        Result<Integer> result1 = new Result<>();
        if (auditTableService.insertAuditTable(auditTableEntity) == 1) {
            result1.setData(1);
            result1.setCode(200);
            result1.setMessage("OK");
            result1.setStatus(true);
        } else {
            result1.setData(0);
            result1.setCode(404);
            result1.setMessage("fail");
            result1.setStatus(false);
        }
        return result1;
    }

    @GetMapping("/changePermissionById/{id},{administratorId}")
    Result<Integer> changePermissionById(@PathVariable int id, @PathVariable String administratorId) {
        Result<Integer> result = new Result<>();
        if (auditTableService.changePermissionById(id, administratorId) == 1) {
            result.setData(1);
            result.setCode(200);
            result.setMessage("已批准");
            result.setStatus(true);

        } else {
            result.setData(0);
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 发送邮件
     */
    @ResponseBody
    @GetMapping("/sendEmailToUser/{id}")
    Result<String> sendEmailToUser(@PathVariable int id){
        Result<String> result = new Result<>();
        AuditTableEntity auditTableEntity = auditTableService.findAuditTableByid(id);
        StuToAuditorEntity auditorEntity = stuToAuditorMapper.selectById(id);
        MailInfo mailInfo = new MailInfo();
        mailInfo.setReceiver(new String[]{auditTableEntity.getContact()});
        mailInfo.setSubject("申请通过通知");
        mailInfo.setContent("亲爱的"+auditorEntity.getApplicant()+"同学，"+"您提交的申请已经通过，如果您想修改自己的信息请点击下方链接进入修改。\n http://1.15.62.89/update \n 祝您生活愉快！");
        sendMessageService.sendSimpleTextEmail(mailInfo);
        result.setData("successful");
        result.setCode(200);
        result.setMessage("successful");
        result.setStatus(true);
        return result;
    }
}
