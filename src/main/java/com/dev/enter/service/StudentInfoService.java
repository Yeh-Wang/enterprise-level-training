package com.dev.enter.service;

import com.dev.enter.entity.StudentInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface StudentInfoService extends IService<StudentInfoEntity> {
     StudentInfoEntity findStudentByStuNumber( String stuNumber);

     List<StudentInfoEntity> findStudentBuStuName(String stuName);
     List<StudentInfoEntity> getAllStudentInfo ();
     int  deleteStudentById(String stuId);
     int updateStudent(StudentInfoEntity studentInfo);
     int insertStudentInfo(StudentInfoEntity studentInfo);
     int judgeStuNumber(String stuNumber);

     /**
      * 获取女生性别比例
      */
     double getFemaleProp();
     /**
      * 获取男生性别比例
      */
     double getMaleProp();

     /**
      * 学生年龄人数
      */
     int getCountByAge(int begin_age , int end_age);

     /**
      * 获取学生总人数
      */
     int getAllStudentCount();

     /**
      * 得到学习能力为参数的学生的数量
      */
     int getLearningAbilityNumber( String learningAbility);

     /**
      * 得到表达能力为参数的学生的数量
      */
     int getExpressAbilityNumber( String expressAbility);
     /**
      * 得到逻辑思维为参数的学生的数量
      */
     int getThinkingAbilityNumber( String expressAbility);

     /**
      * 得到执行能力评价为参数的学生的数量
      */
     int getExecuteAbilityNumber( String executeAbility);
     /**
      * 输入已报名人的所有的省份，统计所有在对应省份里面的人数
      */
     List<Integer> getStudentAddressNumber(List<String> Address);
}
