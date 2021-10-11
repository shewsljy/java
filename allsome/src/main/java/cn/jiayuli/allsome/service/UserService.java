package cn.jiayuli.allsome.service;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<User>{
    UserVO queryUserByCode(String code);
    Integer addUser(UserDTO userDTO);
    Boolean addUserBatch(List<UserDTO> userDTOList);
    List<UserVO> queryUsers(UserDTO userDTO);
    Boolean checkUserCodeUnique(String code);
    Boolean changePassword(String code,String passwordOld,String passwordNew);
    IPage<UserVO> queryUsersPage(UserDTO userDTO,Integer pageNum,Integer pageSize);
}
