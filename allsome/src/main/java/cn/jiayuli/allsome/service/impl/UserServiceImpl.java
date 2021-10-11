package cn.jiayuli.allsome.service.impl;

import cn.jiayuli.allsome.constant.DefaultConstant;
import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.mapper.UserMapper;
import cn.jiayuli.allsome.mapper.custom.CustomUserMapper;
import cn.jiayuli.allsome.mapper.custom.MysqlSequenceMapper;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.util.ConvertUtil;
import cn.jiayuli.allsome.util.MD5Util;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private CustomUserMapper customUserMapper;

    @Resource
    private MysqlSequenceMapper sequenceMapper;

    @Resource
    private ConvertUtil convertUtil;

    @Override
    public UserVO queryUserByCode(String code) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code",code);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return null;
        }
        UserVO userVO = convertUtil.dto2Vo(convertUtil.entity2Dto(user));
        return userVO;
    }

    @Override
    public Integer addUser(UserDTO userDTO) {
        int count = 0;
        if (!ObjectUtils.isEmpty(userDTO) && checkUserCodeUnique(userDTO.getUserCode())) {
            User userBean = convertUtil.dto2Entity(userDTO);
            addUserProperties(userBean,userDTO);
            count = userMapper.insert(userBean);
            log.debug("------ userBean = " + userBean.toString());
        }
        return count;
    }

    @Override
    public Boolean addUserBatch(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userDTOList)) {
            for (UserDTO userDTO : userDTOList ) {
                if (!ObjectUtils.isEmpty(userDTO) && checkUserCodeUnique(userDTO.getUserCode())) {
                    User user = convertUtil.dto2Entity(userDTO);
                    addUserProperties(user, userDTO);
                    userList.add(user);
                }
            }
        }
        return saveBatch(userList);
    }

    private void addUserProperties(User user,UserDTO userDTO) {
        String md5Pw = MD5Util.MD5Pwd(userDTO.getUserCode(),userDTO.getUserPasswd());
        Long id = sequenceMapper.seqUserNextVal();
        log.debug("seq_user_id : " + id.toString());
        user.setUserId(id);
        user.setUserPasswd(md5Pw);
//        user.setCreateBy(DefaultConstant.DEFAULT_SYSTEM);
        user.setUserStatus(DefaultConstant.DEFAULT_STATUS);
    }

    @Override
    public List<UserVO> queryUsers(UserDTO userDTO) {
        QueryWrapper<UserVO> ew = new QueryWrapper<>();
        if (null != userDTO.getUserCode()) {
            ew.eq("user_code", userDTO.getUserCode());
        }
        if (null != userDTO.getUserStatus()) {
            ew.eq("user_status", userDTO.getUserStatus());
        }
        List<UserVO> userVOList = customUserMapper.getAllUser(ew);
        return userVOList;
    }

    @Override
    public Boolean checkUserCodeUnique(String code) {
        UserVO userVO = queryUserByCode(code);
        return userVO == null ? true : false;
    }

    @Override
    public Boolean changePassword(String code, String passwordOld, String passwordNew) {
        boolean isChange = false;
        UserVO userVO = queryUserByCode(code);
        log.debug("------ userVO = " + userVO.toString());
        String passwordDb = userVO.getUserPasswd();
        String md5Pw = MD5Util.MD5Pwd(code,passwordOld);
        log.debug("------ md5Pw = " + md5Pw);
        if (passwordDb.equals(md5Pw)) {
            String md5PwN = MD5Util.MD5Pwd(code,passwordNew);
            log.debug("------ md5PwN = " + md5PwN);
            User user = new User();
            user.setUserId(userVO.getUserId());
            user.setUserPasswd(md5PwN);
//            user.setUpdateBy(DefaultConstant.DEFAULT_SYSTEM);
            userMapper.updateById(user);
            log.debug("------ user = " + user.toString());
            isChange = true;
        }
        return isChange;
    }

    @Override
    public IPage<UserVO> queryUsersPage(UserDTO userDTO,Integer pageNum,Integer pageSize) {
        Page<UserVO> page = new Page<>(pageNum,pageSize);
        QueryWrapper<UserVO> ew = new QueryWrapper<>();
        if (null != userDTO.getUserCode()) {
            ew.eq("user_code", userDTO.getUserCode());
        }
        if (null != userDTO.getUserStatus()) {
            ew.eq("user_status", userDTO.getUserStatus());
        }
        IPage<UserVO> userVOIPage = customUserMapper.queryUsersPage(page,ew);
        return userVOIPage;
    }
}
