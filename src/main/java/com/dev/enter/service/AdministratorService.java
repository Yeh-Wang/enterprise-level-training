package com.dev.enter.service;

import com.dev.enter.entity.AdministratorEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.enter.entity.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface AdministratorService extends IService<AdministratorEntity> {
    public AdministratorEntity getAllAdministrator(String id);
}
