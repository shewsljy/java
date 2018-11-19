package cn.jiayuli.myhome.service;

import cn.jiayuli.myhome.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo queryUserInfoById(Long id);

    List<UserInfo> queryUserInfoAll();

}
