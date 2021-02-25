package cn.jiayuli.allsome.user.service.impl;

import cn.jiayuli.allsome.user.repository.UserRepository;
import cn.jiayuli.allsome.user.dto.UserDTO;
import cn.jiayuli.allsome.user.entity.UserBean;
import cn.jiayuli.allsome.user.service.UserService;
import cn.jiayuli.allsome.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDto) {
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userDto,userBean);
        userRepository.save(userBean);
    }

    @Override
    public List<UserDTO> queryUsers(UserVO userVo) {
        List<UserDTO> userDtos = new ArrayList<UserDTO>();
        List<UserBean> userBeans = userRepository.findAll();
        if (!CollectionUtils.isEmpty(userBeans)){
            for (UserBean userBean : userBeans) {
                UserDTO userDto = new UserDTO();
                BeanUtils.copyProperties(userBean,userDto);
                userDtos.add(userDto);
            }
        }
        return userDtos;
    }
}
