package cn.jiayuli.allsome.user.service;

import cn.jiayuli.allsome.user.dto.UserDto;
import cn.jiayuli.allsome.user.vo.UserVo;

import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    List<UserDto> queryUsers(UserVo userVo);
}
