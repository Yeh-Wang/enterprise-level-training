package com.dev.enter.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.mapper.StudentInfoMapper;
import com.dev.enter.service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfoEntity> implements StudentInfoService {
   private StudentInfoMapper studentInfoMapper;
   @Autowired
   public  void  setStudentInfoMapper(StudentInfoMapper studentInfoMapper)
   {
       this.studentInfoMapper=studentInfoMapper;
   }

    @Override
    public StudentInfoEntity findStudentByStuNumber(String stuNumber) {
        return studentInfoMapper.selectOne(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getStuNumber,stuNumber));

    }

    @Override
    public List<StudentInfoEntity> findStudentBuStuName(String stuName) {
        return studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().like(StudentInfoEntity::getStuName,stuName));
    }

    @Override
    public List<StudentInfoEntity> getAllStudentInfo() {
        return studentInfoMapper.selectList(null);
    }

    @Override
    public int deleteStudentById(String stuId) {
        return  studentInfoMapper.deleteById(stuId);
    }

    @Override
    public int updateStudent(StudentInfoEntity studentInfo) {
        return  studentInfoMapper.updateById(studentInfo);
    }

    @Override
    public int insertStudentInfo(StudentInfoEntity studentInfo) {
        return  studentInfoMapper.insert(studentInfo);
    }
}
