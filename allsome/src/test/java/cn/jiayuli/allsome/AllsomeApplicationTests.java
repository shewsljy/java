package cn.jiayuli.allsome;

import cn.jiayuli.allsome.user.dto.UserDTO;
import cn.jiayuli.allsome.user.entity.UserBean;
import cn.jiayuli.allsome.user.repository.UserRepository;
import cn.jiayuli.allsome.user.service.UserService;
import cn.jiayuli.allsome.user.vo.UserVO;
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
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void repositoryTest() {
        log.info("----- save method test ------");
        UserDTO userDto = new UserDTO();
        userDto.setUserCode("0001");
        userDto.setUserName("user01");
        userDto.setUserPassword("userPassword01");
        userDto.setUserAge(28);
        UserBean userBean = new UserBean();
        log.debug("userDtoBefore : " + userDto.toString());
        log.debug("userBeanBefore : " + userBean.toString());
        BeanUtils.copyProperties(userDto,userBean);
        log.debug("userBeanCopy : " + userBean.toString());
        userRepository.save(userBean);
        log.debug("userDtoCopyAfter : " + userDto.toString());
        log.debug("userBeanCopyAfter : " + userBean.toString());

        log.info("----- findAll method test ------");
        List<UserBean> users = userRepository.findAll();
        for (UserBean user:users) {
            log.info(user.toString());
        }

        log.info("----- count method test ------");
        Long count = userRepository.count();
        log.info("count :" + count.toString());

        log.info("----- findByUserNameIgnoreCase method test ------");
        UserBean bean = userRepository.findByUserNameIgnoreCase("USER01");
        log.info("bean :" + bean.toString());

        log.info("----- findByUserNameIgnoreCaseContaining method test ------");
        UserBean contain = userRepository.findByUserNameIgnoreCaseContaining("USER01");
        log.info("contain :" + contain.toString());

        log.info("----- findByUserNameLikeQuery method test ------");
        UserBean query = userRepository.findByUserNameLikeQuery("USER01");
        log.info("query :" + query.toString());

        log.info("----- addUser method test ------");
        UserDTO userDto2 = new UserDTO();
        userDto2.setUserCode("0002");
        userDto2.setUserName("user02");
        userDto2.setUserPassword("userPassword02");
        userDto2.setUserAge(38);
        userService.addUser(userDto2);

        log.info("----- queryUsers method test ------");
        UserVO vo = new UserVO();
        List<UserDTO> userDtos = userService.queryUsers(vo);
        for (UserDTO dto:userDtos) {
            log.info("dto test:" + dto.toString());
        }

    }

}
