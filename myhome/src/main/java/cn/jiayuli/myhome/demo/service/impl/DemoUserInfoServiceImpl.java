package cn.jiayuli.myhome.demo.service.impl;

import cn.jiayuli.myhome.demo.dao.DemoUserInfoMapper;
import cn.jiayuli.myhome.demo.model.DemoUserInfo;
import cn.jiayuli.myhome.demo.service.DemoUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoUserInfoServiceImpl implements DemoUserInfoService {

    @Resource
    private DemoUserInfoMapper demoUserInfoMapper;

    @Override
    public DemoUserInfo queryUserInfoById(Long id){
        return demoUserInfoMapper.selectByPrimaryKey(id);
    }

}
