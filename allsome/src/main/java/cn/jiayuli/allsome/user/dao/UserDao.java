package cn.jiayuli.allsome.user.dao;

import cn.jiayuli.allsome.user.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserBean,Long> {
}
