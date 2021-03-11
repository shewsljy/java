package cn.jiayuli.allsome.service;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.vo.UserVO;

import java.util.List;

public interface UserService {
    UserDTO queryUserByCode(String code);
    int addUser(UserDTO userDTO);
    int addUserBatch(List<UserDTO> userDTOList);
    List<UserDTO> queryUsers(UserVO userVO);
    boolean checkUserCodeUnique(String code);
    boolean changePassword(String code,String password_old,String password_new);
}
