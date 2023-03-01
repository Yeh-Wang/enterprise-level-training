package com.dev.enter.service.impl;

import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.service.AdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, AdministratorEntity> implements AdministratorService {
    private AdministratorMapper administratorMapper;
    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper){
        this.administratorMapper=administratorMapper;
    }

    @Override
    public AdministratorEntity getAllAdministrator(String id) {
        return administratorMapper.selectById(id);
    }

    private AdministratorMapper administratorMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper){
        this.administratorMapper=administratorMapper;
    }

    @Override
    public AdministratorEntity getAdministratorById(String id) {
        return administratorMapper.selectById(id);
    }
}
