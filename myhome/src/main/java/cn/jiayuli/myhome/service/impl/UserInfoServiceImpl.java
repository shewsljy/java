package cn.jiayuli.myhome.service.impl;

import cn.jiayuli.myhome.dao.UserInfoMapper;
import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.model.UserInfoExample;
import cn.jiayuli.myhome.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryUserInfoById(Long id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserInfo> queryUserInfoAll(){
        List<UserInfo> demoUserInfoList = new ArrayList<UserInfo>();
        UserInfoExample example = new UserInfoExample();
        demoUserInfoList = userInfoMapper.selectByExample(example);
        return demoUserInfoList;
    }

}
