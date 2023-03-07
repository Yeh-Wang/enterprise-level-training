package com.dev.enter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dev.enter.entity.AuditTableEntity;
import com.dev.enter.entity.MailInfo;
import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.mapper.AuditTableMapper;
import com.dev.enter.mapper.StudentInfoMapper;
import com.dev.enter.service.AuditTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class AuditTableServiceImpl extends ServiceImpl<AuditTableMapper, AuditTableEntity> implements AuditTableService {
    private AuditTableMapper auditTableMapper;

    private StudentInfoMapper studentInfoMapper;

    private SendMessageServiceImpl sendMessageService;

    @Autowired
    public void setSendMessageService(SendMessageServiceImpl sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setAuditTableMapper(AuditTableMapper auditTableMapper) {
        this.auditTableMapper = auditTableMapper;
    }

    @Autowired
    public void setStudentInfoMapper(StudentInfoMapper studentInfoMapper) {
        this.studentInfoMapper = studentInfoMapper;
    }

    @Override
    public Integer insertAuditTable(AuditTableEntity auditTableEntity) {
        return auditTableMapper.insert(auditTableEntity);

    }

    @Override
    public AuditTableEntity findAuditTableByid(Integer id) {
        return auditTableMapper.selectOne(new QueryWrapper<AuditTableEntity>().eq("id", id));
    }

    @Override
    public int deleteAuditTableByid(Integer id) {
        return auditTableMapper.deleteById(id);


    }

    @Override
    public int updateAuditTable(AuditTableEntity auditTableEntity) {
        return auditTableMapper.updateById(auditTableEntity);
    }

    /**
     * 通过申请，将result修改为“已通过”，以及将stuInfo的permission改为1
     */
    @Override
    public int changePermissionById(int id, String administratorId) {
        AuditTableEntity auditTableEntity = auditTableMapper.selectById(id);
        auditTableEntity.setAuditor(administratorId);
        auditTableEntity.setResult("已通过");
        auditTableMapper.updateById(auditTableEntity);
        StudentInfoEntity studentInfo = studentInfoMapper.selectById(auditTableEntity.getApplicant());
        studentInfo.setPermissions(1);
        studentInfoMapper.updateById(studentInfo);
        MailInfo mailInfo = new MailInfo();
        mailInfo.setReceiver(new String[]{auditTableEntity.getContact()});
        System.out.println(auditTableEntity.getContact());
        mailInfo.setSubject("申请通过通知");
        mailInfo.setContent("您提交的申请已经通过，如果您想修改自己的信息请点击下方链接进入修改。\n http://1.15.62.89/update \n 祝您生活愉快！");
        sendMessageService.sendSimpleTextEmail(mailInfo);
        return 1;
    }

}