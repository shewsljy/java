package cn.jiayuli.allsome.service.imp;

import cn.jiayuli.allsome.mapper.custom.CustomUserMapper;
import cn.jiayuli.allsome.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private CustomUserMapper customUserMapper;

    @Override
    public Integer userCount() {
        return customUserMapper.userCount();
    }
}
