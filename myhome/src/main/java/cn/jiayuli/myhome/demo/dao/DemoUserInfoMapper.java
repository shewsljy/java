package cn.jiayuli.myhome.demo.dao;

import cn.jiayuli.myhome.demo.model.DemoUserInfo;
import cn.jiayuli.myhome.demo.model.DemoUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoUserInfoMapper {
    long countByExample(DemoUserInfoExample example);

    int deleteByExample(DemoUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DemoUserInfo record);

    int insertSelective(DemoUserInfo record);

    List<DemoUserInfo> selectByExample(DemoUserInfoExample example);

    DemoUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DemoUserInfo record, @Param("example") DemoUserInfoExample example);

    int updateByExample(@Param("record") DemoUserInfo record, @Param("example") DemoUserInfoExample example);

    int updateByPrimaryKeySelective(DemoUserInfo record);

    int updateByPrimaryKey(DemoUserInfo record);
}