package com.dev.enter.controller;


import com.dev.enter.entity.Result;
import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.service.impl.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@RequestMapping("/student-info-entity")
public class StudentInfoController {
    private StudentInfoServiceImpl studentInfoService;

    @Autowired
    public void setStudentInfoService(StudentInfoServiceImpl studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    /**
     * 通过学号精准查找学员的信息
     *
     * @return 返回查找学员的所有信息
     */
    @ResponseBody
    @GetMapping("/findStudentByStuNumber/{stuNumber}")
    Result<StudentInfoEntity> findStudentByStuNumber(@PathVariable String stuNumber) {
        Result<StudentInfoEntity> result = new Result<>();
        if (studentInfoService.findStudentByStuNumber((stuNumber)) != null) {
            result.setData(studentInfoService.findStudentByStuNumber(stuNumber));
            result.setCode(200);
            result.setStatus(true);
            result.setMessage("查找成功！");
        } else {
            result.setData(null);
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("未查找到此学员！");
        }
        return result;
    }

    /**
     * 通过学生姓名模糊查找学员
     *
     * @return 查找学员的全部信息
     */
    @GetMapping("/findStudentByStuName/{stuName}")
    Result<List<StudentInfoEntity>> findStudentBuStuName(@PathVariable String stuName) {
        Result<List<StudentInfoEntity>> result = new Result<>();
        if (studentInfoService.findStudentBuStuName(stuName) != null) {
            result.setData(studentInfoService.findStudentBuStuName(stuName));
            result.setStatus(true);
            result.setCode(200);
            result.setMessage("查找成功！");
        } else {
            result.setData(null);
            result.setStatus(false);
            result.setMessage("查找失败！！");
            result.setCode(404);
        }
        return result;
    }

    /**
     * 得到所有的学生的所有信息
     *
     * @return 所有学生的所有信息
     */
    @ResponseBody
    @GetMapping("/getAllStudentInfo")
    Result<List<StudentInfoEntity>> getAllStudentInfo() {
        Result<List<StudentInfoEntity>> result = new Result<>();

        result.setData(studentInfoService.getAllStudentInfo());
        result.setStatus(true);
        result.setCode(200);
        result.setMessage("查找成功！");
        return result;
    }

    /**
     * 通过学生的学生id删除学生信息
     *
     * @return 成功返回 result.Data为1
     */
    @GetMapping("/deleteStudentById/{stuId}")
    Result<Integer> deleteStudentById(@PathVariable String stuId) {
        Result<Integer> result = new Result<>();
        if (studentInfoService.deleteStudentById(stuId) == 1) {
            result.setData(studentInfoService.deleteStudentById(stuId));
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

    /**
     * 更新学生的信息
     *
     */
    @PostMapping("/updateStudent")
    Result<Integer> updateStudent(@RequestBody StudentInfoEntity studentInfo) {
        Result<Integer> result = new Result<>();
        if (studentInfoService.updateStudent(studentInfo) == 1) {
            result.setData(studentInfoService.updateStudent(studentInfo));
            result.setMessage("更新成功");
            result.setStatus(true);
            result.setCode(200);
        } else {
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("更新失败");
            result.setData(0);
        }
        return result;
    }

    @PostMapping("/insertStudentInfo")
    Result<Integer> insertStudentInfo(@RequestBody StudentInfoEntity studentInfo) {
        UUID uuid = UUID.randomUUID();
        studentInfo.setStuId(String.valueOf(uuid));
        studentInfo.setPermissions(0);
        Result<Integer> result = new Result<>();
        if (studentInfo.getStuName() == null) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("名字不能为空");
            return result;
        }
        if (studentInfo.getStuNumber() == null) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("学号不能为空");
            return result;
        }
        if (studentInfo.getTelephone() == null) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("电话不能为空");
            return result;
        }
        if (studentInfo.getAddress() == null) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("家庭住址不能为空");
            return result;
        }
        if (studentInfoService.judgeStuNumber(studentInfo.getStuNumber()) != 1) {
            result.setData(studentInfoService.insertStudentInfo(studentInfo));
            result.setCode(200);
            result.setStatus(true);
            result.setMessage("增加成功");
            return result;
        } else {
            result.setData(0);
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("学号已经存在");
            return result;
        }

    }
}
