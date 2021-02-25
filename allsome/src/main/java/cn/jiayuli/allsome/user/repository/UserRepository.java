package cn.jiayuli.allsome.user.repository;

import cn.jiayuli.allsome.user.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserBean,Long> {
    UserBean findByUserNameIgnoreCase(String name);
    UserBean findByUserNameIgnoreCaseContaining(String name);

    @Query(value = "select a from UserBean a where a.userName like concat('%', ?1 ,'%')")
    UserBean findByUserNameLikeQuery(String name);
}
