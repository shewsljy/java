package cn.jiayuli.honey.repository;

import cn.jiayuli.honey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: UserRepository <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/02/18
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
