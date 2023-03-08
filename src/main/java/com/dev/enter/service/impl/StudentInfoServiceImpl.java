package com.dev.enter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.mapper.StudentInfoMapper;
import com.dev.enter.service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
    public void setStudentInfoMapper(StudentInfoMapper studentInfoMapper) {
        this.studentInfoMapper = studentInfoMapper;
    }

    @Override
    public StudentInfoEntity findStudentByStuNumber(String stuNumber) {
        return studentInfoMapper.selectOne(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getStuNumber, stuNumber));

    }

    @Override
    public List<StudentInfoEntity> findStudentBuStuName(String stuName) {
        return studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().like(StudentInfoEntity::getStuName, stuName));
    }

    @Override
    public List<StudentInfoEntity> getAllStudentInfo() {
        return studentInfoMapper.selectList(null);
    }

    @Override
    public int deleteStudentById(String stuId) {
        return studentInfoMapper.deleteById(stuId);
    }

    @Override
    public int updateStudent(StudentInfoEntity studentInfo) {
        return studentInfoMapper.updateById(studentInfo);
    }

    @Override
    public int insertStudentInfo(StudentInfoEntity studentInfo) {
        return studentInfoMapper.insert(studentInfo);
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

    @Override
    public double getFemaleProp() {
        List<StudentInfoEntity> list = studentInfoMapper.selectList(new QueryWrapper<StudentInfoEntity>().eq("sex","女"));
        List<StudentInfoEntity> list_all = studentInfoMapper.selectList(null);
        DecimalFormat df = new DecimalFormat("#.00");
        return (Double.parseDouble(df.format((list.size()*1.00/list_all.size())*100)));
    }

    @Override
    public double getMaleProp() {
        List<StudentInfoEntity> list = studentInfoMapper.selectList(new QueryWrapper<StudentInfoEntity>().eq("sex","男"));
        List<StudentInfoEntity> list_all = studentInfoMapper.selectList(null);
        DecimalFormat df = new DecimalFormat("#.0");
        return (Double.parseDouble(df.format((list.size()*1.00/list_all.size())*100)));
    }

    @Override
    public int getCountByAge(int begin_age,int end_age) {
        return studentInfoMapper.selectList(new QueryWrapper<StudentInfoEntity>().between("age",begin_age,end_age)).size();
    }

    @Override
    public int getAllStudentCount() {
        return studentInfoMapper.selectList(null).size();
    }

    /**
     * 得到评价学习能力为参数的人数
     */
    @Override
    public int getLearningAbilityNumber(String learningAbility) {
        int aNum;
        aNum=studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getLearningAbility,learningAbility)).size();

        return aNum;
    }
    /**
     * 得到评价学习能力为参数的人数
     */
    @Override
    public int getExpressAbilityNumber(String expressAbility) {
        int aNum;
        aNum=studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getExpressAbility,expressAbility)).size();

        return aNum;
    }
    /**
     * 得到评价学习能力为参数的人数
     */
    @Override
    public int getThinkingAbilityNumber(String thinkingAbility) {
        int aNum;
        aNum=studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getThinkingAbility,thinkingAbility)).size();

        return aNum;
    }
    /**
     * 得到评价执行能力为参数的人数
     */
    @Override
    public int getExecuteAbilityNumber(String executeAbility) {
        int aNum;
        aNum=studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().eq(StudentInfoEntity::getExecuteAbility,executeAbility)).size();

        return aNum;
    }

    /**
     * 输入已报名人的所有的省份，统计所有在对应省份里面的人数
     */
    @Override
    public List<Integer> getStudentAddressNumber(List<String> Address) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<Address.size();i++){
            list.add(i,studentInfoMapper.selectList(Wrappers.<StudentInfoEntity>lambdaQuery().like(StudentInfoEntity::getAddress,Address.get(i))).size());
        }

        return list;
    }
}
