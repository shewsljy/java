package cn.jiayuli.honey.controller;

import cn.jiayuli.honey.entity.User;
import cn.jiayuli.honey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: UserController <br>
 * Description: TODO
 *
 * @author jiayu
 * @date 2019/11/05
 * @version V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * MethodName: findAll <br>
     * Description: TODO
     *
     * @return java.util.List
     * @author jiayu
     * @date 2019-11-06
     * @version V1.0
     */
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
