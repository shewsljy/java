package cn.jiayuli.allsome.service;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService {
    UserDTO queryUserByCode(String code);
    Integer addUser(UserDTO userDTO);
    Integer addUserBatch(List<UserDTO> userDTOList);
    List<UserDTO> queryUsers(UserVO userVO);
    Boolean checkUserCodeUnique(String code);
    Boolean changePassword(String code,String passwordOld,String passwordNew);
}
