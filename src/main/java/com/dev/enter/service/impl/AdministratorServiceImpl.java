package com.dev.enter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dev.enter.entity.AdministratorEntity;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.service.AdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, AdministratorEntity> implements AdministratorService {

    private AdministratorMapper administratorMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Override
    public AdministratorEntity getAdministratorByUsername(String username) {
        return administratorMapper.selectOne(new QueryWrapper<AdministratorEntity>().eq("user_name", username));
    }

    @Override
    public AdministratorEntity checkLogin(String username, String password) {
        if (administratorMapper.selectOne(new QueryWrapper<AdministratorEntity>().
                eq("user_name", username).eq("user_pwd", password)) == null) {
            return null;
        } else {
            return administratorMapper.selectOne(new QueryWrapper<AdministratorEntity>().
                    eq("user_name", username).eq("user_pwd", password));
        }
    }

    @Override
    public int register(AdministratorEntity administratorEntity) {
        return administratorMapper.insert(administratorEntity);
    }

    @Override
    public int modifyInfo(AdministratorEntity administratorEntity) {
        return administratorMapper.updateById(administratorEntity);
    }

    @Override
    public int checkSameUsername(String username) {
        List<AdministratorEntity> administratorEntities = administratorMapper.selectList(new QueryWrapper<AdministratorEntity>()
                .eq("user_name", username));
        if (administratorEntities.size() != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer modifyPassword(String id, String newPassword) {
        AdministratorEntity administrator = administratorMapper.selectOne(new QueryWrapper<AdministratorEntity>().eq("id",id));
        administrator.setUserPwd(newPassword);
        return administratorMapper.updateById(administrator);
    }

}
