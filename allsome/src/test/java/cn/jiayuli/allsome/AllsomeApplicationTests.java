package cn.jiayuli.allsome;

import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.mapper.UserMapper;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.util.MD5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@SpringBootTest
class AllsomeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void digestTest() {
        log.debug("------ md5DigestAsHex method test ------");
        String password = "123456";
        log.debug("------ password = 123456 ------");
        byte[] bytes = password.getBytes();
        log.debug("------ bytes = " + bytes + " ------");
        int bytesInt = bytes.length;
        log.debug("------ bytesInt = " + bytesInt + " ------");
        String digestPw = DigestUtils.md5DigestAsHex(bytes);
        log.debug("------ digestPw = " + digestPw + " ------");

    }

    @Test
    void MD5UtilTest() {
        log.debug("------ MD5Pwd method test ------");
        String username = "0001";
        log.debug("------ username = 0001 ------");
        String password = "123456";
        log.debug("------ password = 123456 ------");
        String MD5Pwd = MD5Util.MD5Pwd(username,password);
        log.debug("------ MD5Pwd = " + MD5Pwd + " ------");

    }

    @Test
    @Transactional
    void mapperTest() {
        log.debug("------ deleteById method test ------");
        Integer deleteByIdCount = userMapper.deleteById(1L);
        log.debug("------ deleteByIdCount : " + deleteByIdCount.toString() + " ------");

        log.debug("------ insert method test ------");
        log.debug("------ password maybe is e10adc3949ba59abbe56e057f20f883e ------");
        User user = new User();
        user.setCode("code0001");
        user.setName("user0001");
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        user.setAge(28);
        Integer insertCount = userMapper.insert(user);
        log.debug("------ insertCount : " + insertCount.toString() + " ------");

        log.debug("------ selectCountPara method test ------");
        QueryWrapper queryWrapperSelect = new QueryWrapper();
        queryWrapperSelect.eq("code","code0001");
        Integer selectCountPara = userMapper.selectCount(queryWrapperSelect);
        log.debug("------ selectCountPara : " + selectCountPara.toString() + " ------");

        log.debug("------ selectCount method test ------");
        Integer selectCount = userMapper.selectCount(null);
        log.debug("------ selectCount : " + selectCount.toString() + " ------");

        log.debug("------ selectList method test ------");
        List<User> users = userMapper.selectList(null);
        for (User userSub : users) {
            log.debug("------ userSub : " + userSub.toString() + " ------");
        }

        log.debug("------ selectListPara method test ------");
        QueryWrapper queryWrapperSel = new QueryWrapper();
        queryWrapperSelect.eq("code","code0001");
        List<User> userList = userMapper.selectList(queryWrapperSel);
        for (User userSub : userList) {
            log.debug("------ selectListPara userSub : " + userSub.toString() + " ------");
        }

        log.debug("------ selectById method test ------");
        User userById = userMapper.selectById(4L);
        if (userById != null) {
            log.debug("------ selectById : " + userById.toString() + " ------");
        }else {
            log.debug("------ selectById : " + "is null " + " ------");
        }

        log.debug("------ deleteBatchIds method test ------");
        List<Long> ids = Arrays.asList(1L,2L,3L);
        Integer deleteBatchIds = userMapper.deleteBatchIds(ids);
        log.debug("------ deleteBatchIds : " + deleteBatchIds.toString() + " ------");

        log.debug("------ deleteByMap method test ------");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code","code0002");
        log.debug("------ map : " + map.toString() + " ------");
        Integer deleteByMap = userMapper.deleteByMap(map);
        log.debug("------ deleteByMap : " + deleteByMap.toString() + " ------");

        log.debug("------ deletePara method test ------");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("code","code0001");
        Integer deletePara = userMapper.delete(queryWrapper);
        log.debug("------ deletePara : " + deletePara.toString() + " ------");

        log.debug("------ deleteNull method test ------");
        Integer deleteNull = userMapper.delete(null);
        log.debug("------ deleteNull : " + deleteNull.toString() + " ------");
        //Wrapper
        //userMapper
    }

}
