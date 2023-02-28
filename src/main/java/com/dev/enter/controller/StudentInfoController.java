package com.dev.enter.controller;


import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.service.impl.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@RequestMapping("/student-info-entity")
public class StudentInfoController {
     private StudentInfoServiceImpl studentInfoService;
    @Autowired
    public void setStudentInfoService(StudentInfoServiceImpl studentInfoService){
        this.studentInfoService=studentInfoService;
    }
        @ResponseBody
        @GetMapping("/findStudentByStuNumber/{stuNumber}")//通过学号精准查找学员的信息，返回学员的所有信息
        StudentInfoEntity findStudentByStuNumber(@PathVariable String stuNumber) {

            return studentInfoService.findStudentByStuNumber(stuNumber);
        }
        @GetMapping("/findStudentByStuName/{stuName}")//通过学生姓名模糊查找学员
     List<StudentInfoEntity> findStudentBuStuName(@PathVariable String stuName){
           return studentInfoService.findStudentBuStuName(stuName);
    }
    @PostMapping ("/getAllStudentInfo")//得到所有的学生的所有信息
      List<StudentInfoEntity> getAllStudentInfo (){
           return studentInfoService.getAllStudentInfo();
    }
    @GetMapping ("/deleteStudentById/{stuId}")//通过学生的学生id删除学生信息
      int  deleteStudentById(@PathVariable String stuId){
           return studentInfoService.deleteStudentById(stuId);
    }
    @PostMapping ("/updateStudent")//更新学生的信息
      int updateStudent(@RequestBody StudentInfoEntity studentInfo){
           return studentInfoService.updateStudent(studentInfo);
    }
    @PostMapping("/insertStudentInfo")
     int insertStudentInfo(@RequestBody StudentInfoEntity studentInfo){
            return studentInfoService.insertStudentInfo(studentInfo);
    }
}
