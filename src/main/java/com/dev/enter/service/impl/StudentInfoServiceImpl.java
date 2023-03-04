package com.dev.enter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * 服务实现类
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

    @Override
    public int judgeStuNumber(String stuNumber) {
        StudentInfoEntity studentInfo;
        studentInfo = studentInfoMapper.selectOne(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getStuNumber, stuNumber));
        if (studentInfo != null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 得到评价学习能力为参数的人数
     * @param learningAbility
     * @return
     */
    @Override
    public int getAverageLearningAbility(String learningAbility) {
        int aNum;
        aNum=studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getLearningAbility,learningAbility)).size();

       return aNum;
    }

    @Override
    public double getFemaleProp() {
        List<StudentInfoEntity> list = studentInfoMapper.selectList(new QueryWrapper<StudentInfoEntity>().eq("sex","女"));
        List<StudentInfoEntity> list_all = studentInfoMapper.selectList(null);
        return ((list.size()*1.00/list_all.size())*100);
    }

    @Override
    public double getMaleProp() {
        List<StudentInfoEntity> list = studentInfoMapper.selectList(new QueryWrapper<StudentInfoEntity>().eq("sex","男"));
        List<StudentInfoEntity> list_all = studentInfoMapper.selectList(null);
        return (float) ((list.size()*1.00/list_all.size())*100);
    }
}
