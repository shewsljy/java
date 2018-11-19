package cn.jiayuli.myhome.demo.service;

import cn.jiayuli.myhome.demo.model.DemoUserInfo;

import java.util.List;

public interface DemoUserInfoService {

    DemoUserInfo queryUserInfoById(Long id);

    List<DemoUserInfo> queryUserInfoAll();

}
