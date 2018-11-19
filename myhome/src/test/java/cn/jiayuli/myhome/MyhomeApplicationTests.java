package cn.jiayuli.myhome;

import cn.jiayuli.myhome.demo.dao.DemoUserInfoMapper;
import cn.jiayuli.myhome.demo.model.DemoUserInfo;
import cn.jiayuli.myhome.demo.model.DemoUserInfoExample;
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

    @Test
    public void contextLoads() {
    }

    @Test
    public void mapperTest(){
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
}
