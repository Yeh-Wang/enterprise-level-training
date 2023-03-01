package com.dev.enter.controller;

import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.service.AdministratorService;
import com.dev.enter.utils.JWTUtils;
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
@RequestMapping("/administrator-entity")
public class AdministratorController {

    private AdministratorService administratorService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService){
        this.administratorService=administratorService;
    }

    /**
     * 通过管理员id获取该管理员的信息
     * @param id 管理员id
     * @return result类
     */
    @GetMapping("/getAdministratorById/{id}")
    public Result<AdministratorEntity> getAdministratorById(@PathVariable String id){
        Result<AdministratorEntity> result = new Result<>();
        if (administratorService.getAdministratorById(id)==null){
            result.setCode(404);
            result.setMessage("失败");
            result.setStatus(false);
            result.setMessage(null);
        }else {
            result.setData(administratorService.getAdministratorById(id));
            result.setMessage("成功");
            result.setCode(200);
            result.setStatus(true);
        }
        return result;
    }

    /**
     * 登录验证
     */
    @ResponseBody
    @PostMapping("/login")
    public Result<String> login(@RequestBody AdministratorEntity administrator){
        System.out.println(administrator.getRealName());
        String token = JWTUtils.sign(administrator);
        Result<String> result = new Result<>();
        result.setData(token);
        result.setCode(200);
        result.setMessage("OK");
        result.setStatus(true);
        return result;
    }

}
