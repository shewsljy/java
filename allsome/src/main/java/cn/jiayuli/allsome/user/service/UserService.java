package cn.jiayuli.allsome.user.service;

import cn.jiayuli.allsome.user.dto.UserDTO;
import cn.jiayuli.allsome.user.vo.UserVO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDto);
    List<UserDTO> queryUsers(UserVO userVo);
}
