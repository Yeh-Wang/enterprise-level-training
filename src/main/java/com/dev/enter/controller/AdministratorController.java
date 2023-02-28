package com.dev.enter.controller;

import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private AdministratorMapper administratorMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper){
        this.administratorMapper=administratorMapper;
    }

    @GetMapping("/getAllAdministrator")
    public Result<AdministratorEntity> getAllAdministrator(){
        Result<AdministratorEntity> result = new Result<AdministratorEntity>();
        result.setData(administratorMapper.selectOne(null));
        return result;
    }

}
