package cn.jiayuli.allsome.util;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConvertUtil {

    User dto2Entity(UserDTO userDTO);
    UserDTO entity2Dto(User user);
    UserVO dto2Vo(UserDTO userDTO);
    UserDTO vo2Dto(UserVO userVO);
}
