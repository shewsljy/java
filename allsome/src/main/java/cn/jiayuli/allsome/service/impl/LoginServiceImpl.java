package cn.jiayuli.allsome.service.impl;

import cn.jiayuli.allsome.mapper.custom.CustomUserMapper;
import cn.jiayuli.allsome.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private CustomUserMapper customUserMapper;

    @Override
    public Integer userCount() {
        return customUserMapper.userCount();
    }
}
