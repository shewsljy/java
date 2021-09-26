package cn.jiayuli.allsome.mapper.custom;

import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomUserMapper {
    public Integer userCount();
    List<UserVO> getAllUser(@Param(Constants.WRAPPER) Wrapper ew);
}
