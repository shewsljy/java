package cn.jiayuli.allsome.shiro;

import cn.jiayuli.allsome.constant.DigestConstant;
import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-------身份认证方法--------");
        Object object = authenticationToken.getPrincipal();
        if (ObjectUtils.isEmpty(object)) {
            return null;
        }
        String name = (String) object;
//        String password = String.valueOf((char[])authenticationToken.getCredentials());
        UserDTO userDTO = userService.queryUserByCode(name);
        if (ObjectUtils.isEmpty(userDTO)) {
            throw new AccountException("用户不存在");
        }
//        else if (!md5psw.equals(userDTO.getPassword())){
//            throw new AccountException("密码不正确");
//        }
        else {
            String passwordInDb = userDTO.getPassword();
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            //SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, password, getName());
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, passwordInDb, ByteSource.Util.bytes(name + DigestConstant.STRING_SALT), getName());
            return simpleAuthenticationInfo;
        }
    }
}
