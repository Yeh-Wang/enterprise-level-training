package com.dev.enter.service;

import com.dev.enter.entity.AdministratorEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface AdministratorService extends IService<AdministratorEntity> {


    AdministratorEntity getAdministratorById(String id);

    /**
     * 登陆验证
     */
    AdministratorEntity checkLogin(String id,String password);

}
