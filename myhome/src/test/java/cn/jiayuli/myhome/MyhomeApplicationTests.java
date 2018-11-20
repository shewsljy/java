package cn.jiayuli.myhome;

import cn.jiayuli.myhome.dao.UserInfoMapper;
import cn.jiayuli.myhome.demo.dao.DemoUserInfoMapper;
import cn.jiayuli.myhome.demo.model.DemoUserInfo;
import cn.jiayuli.myhome.demo.model.DemoUserInfoExample;
import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.model.UserInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyhomeApplicationTests {

    @Resource DemoUserInfoMapper demoUserInfoMapper;

    @Resource UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void demoUserInfoTest() {
        List<DemoUserInfo> demoUserInfoList = new ArrayList<DemoUserInfo>();
        DemoUserInfoExample example = new DemoUserInfoExample();
        DemoUserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andPasswordIsNotNull();
        criteria.andPhoneNumberIsNotNull();
        demoUserInfoList = demoUserInfoMapper.selectByExample(example);
        for (DemoUserInfo demoUserInfo : demoUserInfoList) {
            System.out.println(demoUserInfo.toString());
        }
    }

    @Test
    public void userInfoTest() {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andPassWordIsNotNull();
        criteria.andUpdateUserIsNull();
        userInfoList = userInfoMapper.selectByExample(example);
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo.toString());
        }
    }
}
