package cn.jiayuli.allsome.service;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.vo.UserVO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDto);
    List<UserDTO> queryUsers(UserVO userVo);
}
