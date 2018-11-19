package cn.jiayuli.myhome.demo.service.impl;

import cn.jiayuli.myhome.demo.dao.DemoUserInfoMapper;
import cn.jiayuli.myhome.demo.model.DemoUserInfo;
import cn.jiayuli.myhome.demo.model.DemoUserInfoExample;
import cn.jiayuli.myhome.demo.service.DemoUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoUserInfoServiceImpl implements DemoUserInfoService {

    @Resource
    private DemoUserInfoMapper demoUserInfoMapper;

    @Override
    public DemoUserInfo queryUserInfoById(Long id){
        return demoUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DemoUserInfo> queryUserInfoAll(){
        List<DemoUserInfo> demoUserInfoList = new ArrayList<DemoUserInfo>();
        DemoUserInfoExample example = new DemoUserInfoExample();
        DemoUserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andPasswordIsNotNull();
        demoUserInfoList = demoUserInfoMapper.selectByExample(example);
        return demoUserInfoList;
    }

}
