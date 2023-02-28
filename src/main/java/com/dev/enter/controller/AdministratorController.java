package com.dev.enter.controller;

import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private AdministratorService administratorService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService){
        this.administratorService=administratorService;
    }

    @GetMapping("/getAllAdministrator/{id}")
    public Result<AdministratorEntity> getAllAdministrator(@PathVariable String id){
        Result<AdministratorEntity> result = new Result<>();
        result.setData(administratorService.getAllAdministrator(id));
        result.setMessage("成功");
        result.setCode(200);
        return result;
    }

}
