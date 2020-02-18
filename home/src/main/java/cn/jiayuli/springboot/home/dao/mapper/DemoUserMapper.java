package cn.jiayuli.springboot.home.dao.mapper;

import cn.jiayuli.springboot.home.dao.model.DemoUser;
import cn.jiayuli.springboot.home.dao.model.DemoUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoUserMapper {
    long countByExample(DemoUserExample example);

    int deleteByExample(DemoUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    List<DemoUser> selectByExample(DemoUserExample example);

    DemoUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByExample(@Param("record") DemoUser record, @Param("example") DemoUserExample example);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);
}