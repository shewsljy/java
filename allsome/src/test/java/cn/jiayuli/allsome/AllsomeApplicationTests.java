package cn.jiayuli.allsome;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.entity.User;
import cn.jiayuli.allsome.mapper.UserMapper;
import cn.jiayuli.allsome.mapper.custom.MysqlSequenceMapper;
import cn.jiayuli.allsome.service.UserService;
import cn.jiayuli.allsome.util.DateTimeUtil;
import cn.jiayuli.allsome.util.MD5Util;
import cn.jiayuli.allsome.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@SpringBootTest
class AllsomeApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Resource
    private MysqlSequenceMapper sequenceMapper;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void updateTest() {
        log.debug("------ update method test ------");
        UserDTO userDTO01 = new UserDTO();
        userDTO01.setUserCode("code01");
        userDTO01.setUserName("name01");
        userDTO01.setUserAge(11);
        userDTO01.setUserPasswd("123456");
        log.debug("------ userDTO01 = " + userDTO01.toString());
        int count01 = userService.addUser(userDTO01);
        log.debug("------ count01 = " + count01);
        boolean isChange = userService.changePassword("code01","123456","654321");
        log.debug("------ isChange = " + isChange);
    }

    @Test
    @Transactional
    void addUserBatchTest() {
        log.debug("------ addUserBatch method test ------");
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO01 = new UserDTO();
        userDTO01.setUserCode("code01");
        userDTO01.setUserName("name01");
        userDTO01.setUserAge(11);
        userDTO01.setUserPasswd("123456");
        log.debug("------ userDTO01 = " + userDTO01.toString());
        UserDTO userDTO02 = new UserDTO();
        userDTO02.setUserCode("code02");
        userDTO02.setUserName("name02");
        userDTO02.setUserAge(12);
        userDTO02.setUserPasswd("123456");
        log.debug("------ userDTO02 = " + userDTO02.toString());
        userDTOList.add(userDTO01);
        userDTOList.add(userDTO02);
        userDTOList.add(null);
        userService.addUserBatch(userDTOList);
        userService.addUserBatch(userDTOList);
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
    void md5UtilTest() {
        log.debug("------ MD5Pwd method test ------");
        String username = "0001";
        log.debug("------ username = 0001 ------");
        String password = "123456";
        log.debug("------ password = 123456 ------");
        String md5Pwd = MD5Util.MD5Pwd(username,password);
        log.debug("------ md5Pwd = " + md5Pwd + " ------");

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
        user.setUserCode("code0001");
        user.setUserName("user0001");
        user.setUserPasswd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        user.setUserAge(28);
        user.setUserId(sequenceMapper.seqUserNextVal());
        Integer insertCount = userMapper.insert(user);
        log.debug("------ insertCount : " + insertCount.toString() + " ------");

        log.debug("------ selectCountPara method test ------");
        QueryWrapper queryWrapperSelect = new QueryWrapper();
        queryWrapperSelect.eq("user_code","code0001");
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
        queryWrapperSel.eq("user_code","code0001");
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
        map.put("user_code","code0002");
        log.debug("------ map : " + map.toString() + " ------");
        Integer deleteByMap = userMapper.deleteByMap(map);
        log.debug("------ deleteByMap : " + deleteByMap.toString() + " ------");

        log.debug("------ deletePara method test ------");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_code","code0001");
        Integer deletePara = userMapper.delete(queryWrapper);
        log.debug("------ deletePara : " + deletePara.toString() + " ------");

        log.debug("------ deleteNull method test ------");
        Integer deleteNull = userMapper.delete(null);
        log.debug("------ deleteNull : " + deleteNull.toString() + " ------");
    }

    @Test
    void localDateTimeTest() {
        Long timestamp = 1631867648334L;
        Long timestamp2 = 1631867648335L;
        LocalDateTime localDateTime = DateTimeUtil.getDataTimeOfTimestamp(timestamp);
        LocalDateTime localDateTime2 = DateTimeUtil.getDataTimeOfTimestamp(timestamp2);
        log.debug("--------timestamp-------");
        log.debug("timestamp : " + timestamp + "");
        log.debug("--------localDateTime-------");
        log.debug("localDateTime : " + localDateTime + "");
        log.debug("--------timestamp2-------");
        log.debug("timestamp2 : " + timestamp2 + "");
        log.debug("--------localDateTime2-------");
        log.debug("localDateTime2 : " + localDateTime2 + "");
    }

    @Test
    void pageTest() {
        Page<User> page = new Page<>(1,3);
        IPage<User> userIPage = userMapper.selectPage(page,null);
        log.debug("userIPageTotal : " + userIPage.getTotal() + "");
        userIPage.getRecords().forEach(System.out::println);
    }

    @Test
    void jsonXmlTest() throws Exception {
        JsonMapper jsonMapper = new JsonMapper();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserStatus(0);
        IPage<UserVO> usersPage = userService.queryUsersPage(userDTO,1,3);
        String json = jsonMapper.writeValueAsString(usersPage);
        log.debug("json = " + json);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(usersPage);
        log.debug("xml = " + xml);
    }

}
