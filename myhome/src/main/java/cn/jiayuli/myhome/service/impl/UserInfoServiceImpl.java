package cn.jiayuli.myhome.service.impl;

import cn.jiayuli.myhome.dao.UserInfoMapper;
import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.model.UserInfoExample;
import cn.jiayuli.myhome.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<UserInfo> queryUserInfoAllPage(int pageNo, int pageSize) {
        UserInfoExample example = new UserInfoExample();
        PageHelper.startPage(pageNo, pageSize);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(userInfoList);
        return pageInfo;
    }

}
