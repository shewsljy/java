package cn.jiayuli.myhome.service;

import cn.jiayuli.myhome.model.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserInfoService {

    UserInfo queryUserInfoById(Long id);

    List<UserInfo> queryUserInfoAll();

    PageInfo<UserInfo> queryUserInfoAllPage(int pageNo, int pageSize);

}
