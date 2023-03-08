package com.dev.enter.controller;

import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.service.AdministratorService;
import com.dev.enter.utils.JWTUtils;
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
@CrossOrigin
@RequestMapping("/administrator-entity")
public class AdministratorController {

    private AdministratorService administratorService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    /**
     * 通过管理员username获取该管理员的信息
     *
     * @param username 管理员user_name
     * @return result类
     */
    @GetMapping("/getAdministratorByUsername/{username}")
    public Result<AdministratorEntity> getAdministratorByUsername(@PathVariable String username) {
        Result<AdministratorEntity> result = new Result<>();
        if (administratorService.getAdministratorByUsername(username) == null) {
            result.setCode(404);
            result.setMessage("失败");
            result.setStatus(false);
            result.setMessage(null);
        } else {
            result.setData(administratorService.getAdministratorByUsername(username));
            result.setMessage("成功");
            result.setCode(200);
            result.setStatus(true);
        }
        return result;
    }

    /**
     * 登录验证
     *
     * @param username 管理员用户名
     * @param password 管理员密码
     * @return token
     */

    @ResponseBody
    @GetMapping("/login/{username},{password}")
    public Result<String> login(@PathVariable String username, @PathVariable String password) {
        Result<String> result = new Result<>();
        if (administratorService.checkLogin(username, password) != null) {
            String token = JWTUtils.sign(administratorService.checkLogin(username, password));
            result.setData(token);
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        } else {
            result.setData(null);
            result.setCode(404);
            result.setMessage("用户名或密码不正确");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 注册管理员
     *
     * @param administratorEntity 一个管理员实体类
     * @return 注册结果
     */

    @PostMapping("/register")
    public Result<String> register(@RequestBody AdministratorEntity administratorEntity) {
        Result<String> result = new Result<>();
        if (administratorService.checkSameUsername(administratorEntity.getUserName()) == 1) {
            result.setMessage("用户名已被占用");
            result.setCode(404);
            result.setData("0");
            result.setStatus(false);
            return result;
        }
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        administratorEntity.setId(id);
        administratorEntity.setUserType(0);

        if (administratorService.register(administratorEntity) == 1) {
            result.setData("1");
            result.setMessage("注册成功");
            result.setCode(200);
            result.setStatus(true);
            return result;
        } else {
            result.setData("0");
            result.setMessage("注册失败");
            result.setCode(404);
            result.setStatus(false);
            return result;
        }
    }

    /**
     * 修改管理员信息
     *
     * @param administratorEntity 一个管理员实体类
     * @return 修改结果
     */
    @PostMapping("/modifyAdministratorInfo")
    public Result<String> modifyAdministratorInfo(@RequestBody AdministratorEntity administratorEntity) {
        Result<String> result = new Result<>();
        if (administratorService.modifyInfo(administratorEntity) == 1) {
            result.setData("1");
            result.setMessage("修改成功");
            result.setCode(200);
            result.setStatus(true);
            return result;
        } else {
            result.setData("0");
            result.setMessage("修改失败");
            result.setCode(404);
            result.setStatus(false);
            return result;
        }
    }

}
