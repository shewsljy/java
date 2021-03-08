package cn.jiayuli.allsome.service.imp;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.mapper.UserMapper;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.util.MD5Util;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO queryUserByCode(String code) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("code",code);
        User user = userMapper.selectOne(queryWrapper);
        if (!ObjectUtils.isEmpty(user)) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public int addUser(UserDTO userDto) {
        String md5Pw = MD5Util.MD5Pwd(userDto.getCode(),userDto.getPassword());
        userDto.setPassword(md5Pw);
        int count = 0;
        if (!ObjectUtils.isEmpty(userDto)) {
            User userBean = new User();
            BeanUtils.copyProperties(userDto, userBean);
            count = userMapper.insert(userBean);
        }
        return count;
    }

    @Override
    public List<UserDTO> queryUsers(UserVO userVo) {
        List<UserDTO> userDtos = new ArrayList<UserDTO>();
        List<User> userBeans = new ArrayList<User>();
        if (!CollectionUtils.isEmpty(userBeans)){
            for (User userBean : userBeans) {
                UserDTO userDto = new UserDTO();
                if (!ObjectUtils.isEmpty(userBean)) {
                    BeanUtils.copyProperties(userBean, userDto);
                    userDtos.add(userDto);
                }
            }
        }
        return userDtos;
    }

    @Override
    public boolean checkLoginNameUnique(String code) {
        UserDTO userDTO = queryUserByCode(code);
        if (ObjectUtils.isEmpty(userDTO)) {
            return false;
        }
        return true;
    }


}
