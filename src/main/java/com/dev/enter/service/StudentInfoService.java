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

     List<StudentInfoEntity> findStudentBuStuName(@PathVariable String stuName);
     List<StudentInfoEntity> getAllStudentInfo ();
     int  deleteStudentById(@PathVariable String stuId);
     int updateStudent(@RequestBody StudentInfoEntity studentInfo);
     int insertStudentInfo(@RequestBody StudentInfoEntity studentInfo);
     int judgeStuNumber(@PathVariable String stuNumber);

     /**
      * 获取女生性别比例
      */
     double getFemaleProp();
     /**
      * 获取男生性别比例
      */
     double getMaleProp();
}
