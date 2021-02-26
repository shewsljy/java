package cn.jiayuli.allsome.service.imp;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(UserDTO userDto) {
        User userBean = new User();
        BeanUtils.copyProperties(userDto,userBean);
    }

    @Override
    public List<UserDTO> queryUsers(UserVO userVo) {
        List<UserDTO> userDtos = new ArrayList<UserDTO>();
        List<User> userBeans = new ArrayList<User>();
        if (!CollectionUtils.isEmpty(userBeans)){
            for (User userBean : userBeans) {
                UserDTO userDto = new UserDTO();
                BeanUtils.copyProperties(userBean,userDto);
                userDtos.add(userDto);
            }
        }
        return userDtos;
    }
}
