package cn.jiayuli.allsome;

import cn.jiayuli.allsome.user.dto.UserDto;
import cn.jiayuli.allsome.user.entity.UserBean;
import cn.jiayuli.allsome.user.dao.UserDao;
import cn.jiayuli.allsome.user.service.UserService;
import cn.jiayuli.allsome.user.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootTest
class AllsomeApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void repositoryTest() {
        log.info("----- save method test ------");
        UserDto userDto = new UserDto();
        userDto.setUserCode("0001");
        userDto.setUserName("user01");
        userDto.setUserPassword("userPassword01");
        userDto.setUserAge(28);
        UserBean userBean = new UserBean();
        log.debug("userDtoBefore : " + userDto.toString());
        log.debug("userBeanBefore : " + userBean.toString());
        BeanUtils.copyProperties(userDto,userBean);
        log.debug("userBeanCopy : " + userBean.toString());
        userDao.save(userBean);
        log.debug("userDtoCopyAfter : " + userDto.toString());
        log.debug("userBeanCopyAfter : " + userBean.toString());

        log.info("----- findAll method test ------");
        List<UserBean> users = userDao.findAll();
        for (UserBean user:users) {
            log.info(user.toString());
        }

        log.info("----- count method test ------");
        Long count = userDao.count();
        log.info("count :" + count.toString());

        log.info("----- addUser method test ------");
        UserDto userDto2 = new UserDto();
        userDto2.setUserCode("0002");
        userDto2.setUserName("user02");
        userDto2.setUserPassword("userPassword02");
        userDto2.setUserAge(38);
        userService.addUser(userDto2);

        log.info("----- queryUsers method test ------");
        UserVo vo = new UserVo();
        List<UserDto> userDtos = userService.queryUsers(vo);
        for (UserDto dto:userDtos) {
            log.info("dto test:" + dto.toString());
        }

    }

}
