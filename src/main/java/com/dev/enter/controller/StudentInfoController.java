package com.dev.enter.controller;


import com.dev.enter.entity.Point;
import com.dev.enter.entity.Result;
import com.dev.enter.entity.StudentInfoEntity;
import com.dev.enter.service.impl.StudentInfoServiceImpl;
import com.dev.enter.utils.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@CrossOrigin
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
    @ResponseBody
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
    @PostMapping("/getAllStudentInfo")
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
    @ResponseBody
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
    @ResponseBody
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

    /**
     *  增加学生信息
     *
     */
    @ResponseBody
    @PostMapping("/insertStudentInfo")
    Result<Integer> insertStudentInfo(@RequestBody StudentInfoEntity studentInfo) {
        UUID uuid = UUID.randomUUID();
        studentInfo.setStuId(String.valueOf(uuid));
        studentInfo.setPermissions(0);


        if(!Objects.equals(studentInfo.getExecuteAbility(), "")&&studentInfo.getExecuteAbility()!=null){
            if(Integer.parseInt(studentInfo.getExecuteAbility())>8){
                studentInfo.setExecuteAbility("优");
            }else if(Integer.parseInt(studentInfo.getExecuteAbility())>6){
                studentInfo.setExecuteAbility("良");
            }else {
                studentInfo.setExecuteAbility("中");
            }
        }
        if(!Objects.equals(studentInfo.getLearningAbility(), "")&&studentInfo.getLearningAbility()!=null){
            if(Integer.parseInt(studentInfo.getLearningAbility())>8){
                studentInfo.setLearningAbility("优");
            }else if(Integer.parseInt(studentInfo.getLearningAbility())>6){
                studentInfo.setLearningAbility("良");
            }else {
                studentInfo.setLearningAbility("中");
            }
        }

        if(!Objects.equals(studentInfo.getExpressAbility(), "")&&studentInfo.getExpressAbility()!=null){
            if(Integer.parseInt(studentInfo.getExpressAbility())>8){
                studentInfo.setExpressAbility("优");
            }else if(Integer.parseInt(studentInfo.getExpressAbility())>6){
                studentInfo.setExpressAbility("良");
            }else {
                studentInfo.setExpressAbility("中");
            }
        }

        if(!Objects.equals(studentInfo.getThinkingAbility(), "")&&studentInfo.getThinkingAbility()!=null){
            if(Integer.parseInt(studentInfo.getThinkingAbility())>8){
                studentInfo.setThinkingAbility("优");
            }else if(Integer.parseInt(studentInfo.getThinkingAbility())>6){
                studentInfo.setThinkingAbility("良");
            }else {
                studentInfo.setThinkingAbility("中");
            }
        }

        Result<Integer> result = new Result<>();
        if (Objects.equals(studentInfo.getStuName(), "")) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("名字不能为空");
            return result;
        }
        if (Objects.equals(studentInfo.getStuNumber(), "")) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("学号不能为空");
            return result;
        }
        if (Objects.equals(studentInfo.getTelephone(), "")) {
            result.setData(0);
            result.setCode(401);
            result.setStatus(false);
            result.setMessage("电话不能为空");
            return result;
        }
        if (Objects.equals(studentInfo.getAddress(), "")) {
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
        } else {
            result.setData(0);
            result.setCode(404);
            result.setStatus(false);
            result.setMessage("学号已经存在");
        }
        return result;
    }
    @ResponseBody
    @GetMapping("/getSexNumber")
    List<Map<Object,Object>> getSexNumber(){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("name","女");
        map.put("value",studentInfoService.getFemaleProp());
        list.add(map);
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("name","男");
        map1.put("value",100-studentInfoService.getFemaleProp());
        list.add(map1);
        return list;
    }
    /**
     * 获取女生性别比例
     */
    @ResponseBody
    @GetMapping("/getFemaleProp")
    List<Map<Object, Object>> getFemaleProp(){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("name","女");
        map.put("value",studentInfoService.getFemaleProp());
        list.add(map);
        return list;
    }
    /**
     * 获取男生性别比例
     */
    @ResponseBody
    @GetMapping("/getMaleProp")
    List<Map<Object, Object>> getMaleProp(){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("name","男");
        map.put("value",100-studentInfoService.getFemaleProp());
        list.add(map);
        return list;
    }

    /**
     * 得到学习能力的各种评分的人数
     *
     */
    @ResponseBody
    @GetMapping("/getStudentLearningAbility")
    List<Map<Object,Object>> getStudentLearningAbility(){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("value",studentInfoService.getLearningAbilityNumber("优"));
        map.put("name","学习能力优秀");
        list.add(map);

        Map<Object, Object> map1 = new HashMap<>();
        map1.put("value",studentInfoService.getLearningAbilityNumber("良"));
        map1.put("name","学习能力良好");
        list.add(map1);


        Map<Object, Object> map2 = new HashMap<>();
        map2.put("value",studentInfoService.getLearningAbilityNumber("中"));
        map2.put("name","学习能力及格");
        list.add(map2);
        return list;
    }
    /**
     * 得到表达能力的各种评分的人数
     *
     */
   @ResponseBody
    @GetMapping("/getStudentExpressAbility")
       List<Map<Object,Object>> getStudentExpressAbility (){
           List<Map<Object, Object>> list = new ArrayList<>();
           Map<Object, Object> map = new HashMap<>();
           map.put("value",studentInfoService.getExpressAbilityNumber("优"));
           map.put("name","表达能力优秀");
           list.add(map);
           Map<Object, Object> map1 = new HashMap<>();
           map1.put("value",studentInfoService.getExpressAbilityNumber("良"));
           map1.put("name","表达能力良好");
           list.add(map1);


           Map<Object, Object> map2 = new HashMap<>();
           map2.put("value",studentInfoService.getExpressAbilityNumber("中"));
           map2.put("name","表达能力及格");
           list.add(map2);
           return list;
       }
    /**
     * 得到思维能力的各种评分的人数
     *
     */
    @ResponseBody
    @GetMapping("/getStudentThinkingAbility")
    List<Map<Object,Object>> getStudentThinkingAbility (){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("value",studentInfoService.getThinkingAbilityNumber("优"));
        map.put("name","思维能力优秀");
        list.add(map);
        System.out.println(list);
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("value",studentInfoService.getThinkingAbilityNumber("良"));
        map1.put("name","思维能力良好");
        list.add(map1);
        System.out.println(list);

        Map<Object, Object> map2 = new HashMap<>();
        map2.put("value",studentInfoService.getThinkingAbilityNumber("中"));
        map2.put("name","思维能力及格");
        list.add(map2);
        return list;
    }

    /***
     *   得到执行能力各种评分的人数
     *
     */
    @ResponseBody
    @GetMapping("/getStudentExecuteAbilityNumber")
    List<Map<Object,Object>> getStudentExecuteAbilityNumber(){
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("value",studentInfoService.getExecuteAbilityNumber("优"));
        map.put("name","执行能力优秀");
        list.add(map);
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("value",studentInfoService.getExecuteAbilityNumber("良"));
        map1.put("name","执行能力良好");
        list.add(map1);
        Map<Object, Object> map2 = new HashMap<>();
        map2.put("value",studentInfoService.getExecuteAbilityNumber("中"));
        map2.put("name","执行能力及格");
        list.add(map2);
        return list;
    }

    /**
     * 返回 已报名人的省份分布和这个省份已报名的人数 比如：
     * {
     * 		"姓名": "重庆市",
     * 		"人数": 6
     *        },
     *
     */
    @ResponseBody
    @GetMapping("/getAddressNumber")
    List<Map<Object,Object>>getAddressNumber(){
        List<Map<Object, Object>> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList;
        List<StudentInfoEntity> studentInfo ;
        String address;
        studentInfo=studentInfoService.getAllStudentInfo();
        for (StudentInfoEntity studentInfoEntity : studentInfo) {
            address = "";
            for (int j = 0; j < studentInfoEntity.getAddress().length(); j++) {
                address = address + studentInfoEntity.getAddress().charAt(j);
                if (studentInfoEntity.getAddress().charAt(j) == '省' || studentInfoEntity.getAddress().charAt(j) == '市' || studentInfoEntity.getAddress().charAt(j) == '区') {
                    if (stringList.size() == 0) {
                        stringList.add(address);
                        break;
                    }
                    for (int k = 0; k < stringList.size(); k++) {
                        if (Objects.equals(stringList.get(k), address))
                            break;
                        if (k + 1 == stringList.size()) {
                            stringList.add(address);
                            break;
                        }
                    }

                    break;
                }

            }
        }
       integerList = studentInfoService.getStudentAddressNumber(stringList);
        for (int i=0;i<integerList.size();i++){
            Map<Object, Object> map = new HashMap<>();
            map.put("人数",integerList.get(i));
            map.put("地址",stringList.get(i));
            list.add(map);
        }
        return list;
    }

    /**
     * 地图用的数据，返回地名和经纬度和人数 例如
     *      "name": "北京市",
     * 		"value": [
     * 			116.4133836971231,
     * 			39.910924547299565,
     * 			9
     * 		]
     *
     */

    @ResponseBody
    @GetMapping("/getPoint")
    List<Map<Object,Object>> getPoint(){
        List<Map<Object,Object>> last =new ArrayList<>();
        List<Point> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList;
        List<StudentInfoEntity> studentInfo ;
        String address;
        studentInfo=studentInfoService.getAllStudentInfo();
        for (StudentInfoEntity studentInfoEntity : studentInfo) {
            address = "";
            for (int j = 0; j < studentInfoEntity.getAddress().length(); j++) {
                address = address + studentInfoEntity.getAddress().charAt(j);
                if (studentInfoEntity.getAddress().charAt(j) == '省' || studentInfoEntity.getAddress().charAt(j) == '市' || studentInfoEntity.getAddress().charAt(j) == '区') {
                    if (stringList.size() == 0) {
                        stringList.add(address);
                        break;
                    }
                    for (int k = 0; k < stringList.size(); k++) {
                        if (Objects.equals(stringList.get(k), address))
                            break;
                        if (k + 1 == stringList.size()) {
                            stringList.add(address);
                            break;
                        }
                    }

                    break;
                }

            }
        }

        for (int i=0;i<stringList.size();i++){
            list.add(i,DistanceUtil.getPoint(stringList.get(i)));
        }
        integerList = studentInfoService.getStudentAddressNumber(stringList);
        List<List<Number>> test =new ArrayList<>();
       for (int i=0;i<integerList.size();i++){
           List<Number> three =new ArrayList<>();
           three.add(list.get(i).getLng());
           three.add(list.get(i).getLat());
           three.add(integerList.get(i));
           test.add(i,three);
       }

        for (int i=0;i<integerList.size();i++){
            Map<Object, Object> map = new HashMap<>();
            map.put("name",stringList.get(i));
            map.put("value",test.get(i));
            last.add(map);
        }
        return   last;

    }
}
