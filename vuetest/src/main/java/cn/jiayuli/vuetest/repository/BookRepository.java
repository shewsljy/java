package cn.jiayuli.vuetest.repository;

import cn.jiayuli.vuetest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: BookRepository <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/02/17
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
