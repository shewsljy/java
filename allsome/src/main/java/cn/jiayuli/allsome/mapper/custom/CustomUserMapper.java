package cn.jiayuli.allsome.mapper.custom;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomUserMapper {
    Integer userCount();
    List<UserVO> getAllUser(@Param(Constants.WRAPPER) Wrapper ew);
    IPage<UserVO> queryUsersPage(Page<UserVO> page, @Param(Constants.WRAPPER) Wrapper ew);
}
