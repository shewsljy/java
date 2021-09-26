package cn.jiayuli.allsome.service.impl;

import cn.jiayuli.allsome.constant.DefaultConstant;
import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.mapper.UserMapper;
import cn.jiayuli.allsome.mapper.custom.CustomUserMapper;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.util.MD5Util;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jiayu
 * @since 2021-09-22
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomUserMapper customUserMapper;

    @Override
    public UserDTO queryUserByCode(String code) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code",code);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public Integer addUser(UserDTO userDTO) {
        int count = 0;
        if (userDTO != null && checkUserCodeUnique(userDTO.getUserCode())) {
            User userBean = new User();
            BeanUtils.copyProperties(userDTO, userBean);
            String md5Pw = MD5Util.MD5Pwd(userDTO.getUserCode(),userDTO.getUserPasswd());
            userBean.setUserPasswd(md5Pw);
            userBean.setCreateBy(DefaultConstant.DEFAULT_ADMIN);
            userBean.setCreateTime(LocalDateTime.now());
            userBean.setUserStatus(DefaultConstant.DEFAULT_STATUS);
            count = userMapper.insert(userBean);
            log.debug("------ userBean = " + userBean.toString());
        }
        return count;
    }

    @Override
    public Integer addUserBatch(List<UserDTO> userDTOList) {
        int count = 0;
        if (!CollectionUtils.isEmpty(userDTOList)) {
            for (UserDTO userDTO : userDTOList ) {
                count = count + addUser(userDTO);
            }
        }
        return count;
    }

    @Override
    public List<UserVO> queryUsers(UserDTO userDTO) {
        QueryWrapper<UserVO> ew = new QueryWrapper<>();
        if (null != userDTO.getUserCode()) {
            ew.eq("user_code", userDTO.getUserCode());
        }
        List<UserVO> userVOList = customUserMapper.getAllUser(ew);
        return userVOList;
    }

    @Override
    public Boolean checkUserCodeUnique(String code) {
        UserDTO userDTO = queryUserByCode(code);
        return userDTO == null ? true : false;
    }

    @Override
    public Boolean changePassword(String code, String passwordOld, String passwordNew) {
        boolean isChange = false;
        UserDTO userDTO = queryUserByCode(code);
        log.debug("------ userDTO = " + userDTO.toString());
        String passwordDb = userDTO.getUserPasswd();
        String md5Pw = MD5Util.MD5Pwd(code,passwordOld);
        log.debug("------ md5Pw = " + md5Pw);
        if (passwordDb.equals(md5Pw)) {
            String md5PwN = MD5Util.MD5Pwd(code,passwordNew);
            log.debug("------ md5PwN = " + md5PwN);
            User user = new User();
            user.setUserId(userDTO.getUserId());
            user.setUserPasswd(md5PwN);
            user.setUpdateBy(DefaultConstant.DEFAULT_ADMIN);
            user.setUpdateTime(LocalDateTime.now());
            userMapper.updateById(user);
            log.debug("------ user = " + user.toString());
            isChange = true;
        }
        return isChange;
    }
}
