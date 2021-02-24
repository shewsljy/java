package cn.jiayuli.allsome.user.service.imp;

import cn.jiayuli.allsome.user.dao.UserDao;
import cn.jiayuli.allsome.user.dto.UserDto;
import cn.jiayuli.allsome.user.entity.UserBean;
import cn.jiayuli.allsome.user.service.UserService;
import cn.jiayuli.allsome.user.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(UserDto userDto) {
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userDto,userBean);
        userDao.save(userBean);
    }

    @Override
    public List<UserDto> queryUsers(UserVo userVo) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        List<UserBean> userBeans = userDao.findAll();
        if (!CollectionUtils.isEmpty(userBeans)){
            for (UserBean userBean : userBeans) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(userBean,userDto);
                userDtos.add(userDto);
            }
        }
        return userDtos;
    }
}
